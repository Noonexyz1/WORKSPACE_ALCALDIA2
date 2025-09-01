package com.sicopi.infrastructure.http.rest.config;

import com.sicopi.application.adapter.formulario.FormularioFotocopiaAdapter;
import com.sicopi.application.adapter.formulario.FormularioRetiroAdapter;
import com.sicopi.application.adapter.usuario.*;
import com.sicopi.application.adapter.dependencia.CuotaAdapter;
import com.sicopi.application.adapter.dependencia.DependenciaAdapter;
import com.sicopi.application.adapter.formulario.FormularioFuncionarioAdapter;
import com.sicopi.application.adapter.fotocopia.*;
import com.sicopi.application.adapter.funcionario.*;
import com.sicopi.application.adapter.persona.FormacionAdapter;
import com.sicopi.application.adapter.persona.PersonaAdapter;
import com.sicopi.application.adapter.precioempresa.EmpresaAdapter;
import com.sicopi.application.adapter.precioempresa.PrecioEmpresaAdapter;
import com.sicopi.application.adapter.precioempresa.PrecioFotocopiaAdapter;
import com.sicopi.application.adapter.solicitud.SolicitudAdapter;
import com.sicopi.application.adapter.solicitud.TipoSolicitudAdapter;
import com.sicopi.application.port.in.formulario.FormularioFotocopiaService;
import com.sicopi.application.port.in.formulario.FormularioRetiroService;
import com.sicopi.application.port.in.usuario.*;
import com.sicopi.application.port.in.dependencia.CuotaService;
import com.sicopi.application.port.in.dependencia.DependenciaService;
import com.sicopi.application.port.in.formulario.FormularioFuncionarioService;
import com.sicopi.application.port.in.fotocopia.*;
import com.sicopi.application.port.in.funcionario.*;
import com.sicopi.application.port.in.persona.FormacionService;
import com.sicopi.application.port.in.persona.PersonaService;
import com.sicopi.application.port.in.empresa.EmpresaService;
import com.sicopi.application.port.in.empresa.PrecioEmpresaService;
import com.sicopi.application.port.in.empresa.PrecioFotocopiaService;
import com.sicopi.application.port.in.solicitud.SolicitudService;
import com.sicopi.application.port.in.solicitud.TipoSolicitudService;
import com.sicopi.application.port.out.persistence.usuario.*;
import com.sicopi.application.port.out.persistence.dependencia.CuotaAbs;
import com.sicopi.application.port.out.persistence.dependencia.DependenciaAbs;
import com.sicopi.application.port.out.persistence.fotocopia.*;
import com.sicopi.application.port.out.persistence.funcionario.*;
import com.sicopi.application.port.out.persistence.persona.FormacionAbs;
import com.sicopi.application.port.out.persistence.persona.PersonaAbs;
import com.sicopi.application.port.out.persistence.empresa.EmpresaAbs;
import com.sicopi.application.port.out.persistence.empresa.PrecioEmpresaAbs;
import com.sicopi.application.port.out.persistence.empresa.PrecioFotocopiaAbs;
import com.sicopi.application.port.out.persistence.solicitud.SolicitudAbs;
import com.sicopi.application.port.out.persistence.solicitud.TipoSolicitudAbs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationController {

    //PERSONA
    @Bean
    public FormacionService formacionServiceBean(FormacionAbs formacionAbs) {
        return new FormacionAdapter(formacionAbs);
    }

    @Bean
    public PersonaService personaServiceBean(PersonaAbs personaAbs) {
        return new PersonaAdapter(personaAbs);
    }


    //FUNCIONARIO
    @Bean
    public CargoService cargoServiceBean(CargoAbs cargoAbs) {
        return new CargoAdapter(cargoAbs);
    }
    @Bean
    public CuotaService cuotaServiceBean(CuotaAbs cuotaAbs) {
        return new CuotaAdapter(cuotaAbs);
    }

    @Bean
    public DependenciaService dependenciaServiceBean(DependenciaAbs dependenciaAbs) {
        return new DependenciaAdapter(dependenciaAbs);
    }

    @Bean
    public FuncCargoService funcCargoServiceBean(FuncCargoAbs funcCargoAbs) {
        return new FuncCargoAdapter(funcCargoAbs);
    }

    @Bean
    public FuncDependenciaService funcDependenciaServiceBean(FuncDependenciaAbs funcDependenciaAbs) {
        return new FuncDependenciaAdapter(funcDependenciaAbs);
    }

    @Bean
    public FuncionarioService funcionarioServiceBean(FuncionarioAbs funcionarioAbs) {
        return new FuncionarioAdapter(funcionarioAbs);
    }


    //USUARIO
    @Bean
    public PermisoService permisoServiceBean(PermisoAbs permisoAbs) {
        return new PermisoAdapter(permisoAbs);
    }

    @Bean
    public PermisoRolService permisoRolServiceBean(PermisoRolAbs permisoRolAbs) {
        return new PermisoRolAdapter(permisoRolAbs);
    }

    @Bean
    public RolService rolServiceBean(RolAbs rolAbs) {
        return new RolAdapter(rolAbs);
    }

    @Bean
    public UsuarioService usuarioServiceBean(UsuarioAbs usuarioAbs) {
        return new UsuarioAdapter(usuarioAbs);
    }

    @Bean
    public UsuarioRolService usuarioRolServiceBean(UsuarioRolAbs usuarioRolAbs) {
        return new UsuarioRolAdapter(usuarioRolAbs);
    }


    //SOLICITUD
    @Bean
    public SolicitudService solicitudService(SolicitudAbs solicitudAbs, TipoSolicitudAbs tipoSolicitudAbs) {
        return new SolicitudAdapter(solicitudAbs, tipoSolicitudAbs);
    }

    @Bean
    public TipoSolicitudService tipoSolicitudServiceBean(TipoSolicitudAbs tipoSolicitudAbs) {
        return new TipoSolicitudAdapter(tipoSolicitudAbs);
    }


    //FOTOCOPIA
    @Bean
    public DocumentoService documentoServiceBean(DocumentoAbs documentoAbs) {
        return new DocumentoAdapter(documentoAbs);
    }

    @Bean
    public FotocopiaService fotocopiaServiceBean(FotocopiaAbs fotocopiaAbs) {
        return new FotocopiaAdapter(fotocopiaAbs);
    }

    @Bean
    public RetiroService retiroServiceBean(RetiroAbs retiroAbs, DocumentoAbs documentoAbs) {
        return new RetiroAdapter(retiroAbs, documentoAbs);
    }


    //PRECIO-EMPRESA
    @Bean
    public PrecioFotocopiaService precioFotocopiaServiceBean(PrecioFotocopiaAbs precioFotocopiaAbs) {
        return new PrecioFotocopiaAdapter(precioFotocopiaAbs);
    }

    @Bean
    public EmpresaService empresaServiceBean(EmpresaAbs empresaAbs) {
        return new EmpresaAdapter(empresaAbs);
    }

    @Bean
    public PrecioEmpresaService precioEmpresaServiceBean(
            PrecioEmpresaAbs precioEmpresaAbs,
            PrecioFotocopiaAbs precioFotocopiaAbs,
            EmpresaAbs empresaAbs
    ) {
        return new PrecioEmpresaAdapter(precioEmpresaAbs, precioFotocopiaAbs, empresaAbs);
    }


    //FORMULARIO
    @Bean
    public FormularioFuncionarioService formularioFuncionarioServiceBean(
            PersonaAbs personaAbs,
            FormacionAbs formacionAbs,
            CargoAbs cargoAbs,
            DependenciaAbs dependenciaAbs,
            FuncionarioAbs funcionarioAbs,
            FuncCargoAbs funcCargoAbs,
            FuncDependenciaAbs funcDependenciaAbs) {

        return new FormularioFuncionarioAdapter(
                personaAbs,
                formacionAbs,
                cargoAbs,
                dependenciaAbs,
                funcionarioAbs,
                funcCargoAbs,
                funcDependenciaAbs);
    }

    @Bean
    public FormularioFotocopiaService formularioFotocopiaServiceBean(
            FuncionarioAbs funcionarioAbs,
            SolicitudAbs solicitudAbs,
            TipoSolicitudAbs tipoSolicitudAbs,
            FotocopiaAbs fotocopiaAbs,
            DocumentoAbs documentoAbs,
            PrecioFotocopiaAbs precioFotocopiaAbs
    ) {
        return new FormularioFotocopiaAdapter(
                funcionarioAbs,
                solicitudAbs,
                tipoSolicitudAbs,
                fotocopiaAbs,
                documentoAbs,
                precioFotocopiaAbs
        );
    }

    @Bean
    public FormularioRetiroService formularioRetiroServiceBean(
            RetiroAbs retiroAbs,
            DocumentoAbs documentoAbs
    ) {
        return new FormularioRetiroAdapter(retiroAbs, documentoAbs);
    }
}
