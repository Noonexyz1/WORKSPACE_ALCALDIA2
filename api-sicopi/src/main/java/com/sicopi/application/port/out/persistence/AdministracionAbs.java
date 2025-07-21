package com.sicopi.application.port.out.persistence;

public interface AdministracionAbs {
    void registrarFormacionAbs();
    void deshabilitarFormacionAbs();
    void editarFormacionAbs();
    void listaDeFormacionesAbs();

    void registrarPersonaAbs();
    void editarPersonaAbs();

    void registrarPersonaFormacionAbs();
    void editarPersonaFormacionAbs();
    void deshabilitarPersonaFormacionAbs();


    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    void registrarFuncionarioAbs();

    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
    //void activarFuncionario();
    //void deshabilitarFuncionario();


    void registrarCargoAbs();
    void deshabilitarCargoAbs();
    void editarCargoAbs();
    void listaDeCargosAbs();

    void registrarDependenciaAbs();
    void deshabilitarDependenciaAbs();
    void editarDependenciaAbs();
    void listaDeDependenciasAbs();

    void registrarFuncionarioCargoAbs();
    void deshabilitarFuncionarioCargoAbs();

    void registrarFuncionarioDependenciaAbs();
    void deshabilitarFuncionarioDependenciaAbs();


    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    void registrarUsuarioAbs();
    //void editarUsuario();
    void deshabilitarUsuarioAbs(); //Esto es a nivel de sistema, no podra iniciar sesion

    void registarRolAbs();
    void deshabilitarRolAbs();
    void editarRolAbs();
    void listaDeRolesAbs();

    void registarPermisoAbs();
    void deshabilitarPermisoAbs();
    void editarPermisoAbs();
    void listaDePermisosAbs();

    void registrarUsuarioRolAbs();
    void deshabilitarUsuarioRolAbs();

    void registrarPermisoRolAbs();
    void deshabilitarPermisoRolAbs();
}
