package com.sicopi.infrastructure.persistence.db.adapter.persona;

import com.sicopi.application.port.out.persistence.persona.FormacionAbs;
import com.sicopi.domain.model.persona.Formacion;
import com.sicopi.infrastructure.persistence.db.entity.persona.FormacionEntity;
import com.sicopi.infrastructure.persistence.db.entity.persona.PersonaEntity;
import com.sicopi.infrastructure.persistence.db.map.persona.FormacionMapper;
import com.sicopi.infrastructure.persistence.db.repository.persona.FormacionRepository;
import com.sicopi.infrastructure.persistence.db.repository.persona.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FormacionAbsAdapter implements FormacionAbs {

    @Autowired
    private FormacionRepository formacionRepository;
    @Autowired
    private PersonaRepository personaRepository;


    // Debo traer el context pues estoy usando cascadas, de no ser asi,
    // pues jpa asume que el id de Persona dentro de formacion existe, entonces usaria
    // el truco de los ids
    @Override
    @Transactional //Tiene su motivo, buscar en gemini, por unicidad de trancacion de dos pasos, tabla fuerte y debil en una sola transaccion
    public Formacion registrarFormacionAbs(Formacion formacion) {

        //Si la formacion es nueva pero la persona si existe
        if (formacion.getId() == null && formacion.getPersona().getId() != null) {
            //Busco el id de la persona si existe o no
            PersonaEntity personaEntity = this.personaRepository
                    .findById(formacion.getPersona().getId()).orElse(null);

            if (personaEntity == null) {
                throw new RuntimeException("Esta persona con este id no existe");
            }

            FormacionEntity formacionEntity = FormacionMapper
                    .INSTANCE.toFormacionEntity(formacion);

            formacionEntity.setPersona(personaEntity);
            this.formacionRepository.save(formacionEntity);
            return FormacionMapper.INSTANCE.toFormacion(formacionEntity);
        }

        //Si la formacion si existe pero la persona no
        if (formacion.getId() != null && formacion.getPersona().getId() == null) {
            throw new RuntimeException("Es necesario asiginar una persona existente a una formacion");
        }

        FormacionEntity formacionSave = this.formacionRepository
                .save(FormacionMapper.INSTANCE.toFormacionEntity(formacion));

        return FormacionMapper.INSTANCE.toFormacion(formacionSave);
    }


    @Override
    public Formacion editarFormacionAbs(Formacion formacion) {
        FormacionEntity formacionEntity = this.formacionRepository
                .save(FormacionMapper.INSTANCE.toFormacionEntity(formacion));
        return FormacionMapper.INSTANCE.toFormacion(formacionEntity);
    }

    @Override
    public Page<Formacion> listaDeFormacionesAbs(Pageable pageable) {
        return this.formacionRepository.findAll(pageable)
                .map(FormacionMapper.INSTANCE::toFormacion);
    }

    @Override
    public void deshabilitarFormacionAbs(Formacion formacion) {
        FormacionEntity formacionEntity = this.formacionRepository
                .save(FormacionMapper.INSTANCE.toFormacionEntity(formacion));
    }

    @Override
    public Formacion findFormacionById(Long idFormacion) {
        return this.formacionRepository
                .findById(idFormacion)
                .map(FormacionMapper.INSTANCE::toFormacion)
                .orElse(null);
    }
}
