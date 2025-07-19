package com.sicopi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // <- ¡Activa la auditoría!
public class SicopiApplication {

    /*@Autowired
    private PersonaRepository personaRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(SicopiApplication.class, args);
    }

    /*@Bean
    CommandLineRunner init() {
        return (args) -> {
            Persona persona = Persona.builder()
                    .id(123L)
                    .nombre("Diego")
                    .build();

            personaRepository.save(fromPersonaToPersonaEntity(persona));

        };
    }


    public PersonaEntity fromPersonaToPersonaEntity(Persona persona) {
        var personaEntity = new PersonaEntity();
        personaEntity.setId(persona.getId());
        personaEntity.setNombre(persona.getNombre());
        return personaEntity;
    }*/

}
