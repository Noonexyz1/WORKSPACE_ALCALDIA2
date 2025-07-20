package com.sicopi.application.port.in;

public interface AdministradorService {
    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    // Vemos la BD, para ver que operaciones
    //anteriores implican hacer o registrar antes de crear un FUNCIONARIO
    void registrarFormacion();
    void deshabilitarFormacion();
    void editarFormacion();
    void listaDeFormaciones();

    void registrarPersona();
    void editarPersona();

    void registrarPersonaFormacion();
    void editarPersonaFormacion();
    void deshabilitarPersonaFormacion();


    //Casos de uso, segun historias de usuario CREAR FUNCIONARIO,
    void registrarFuncionario();

    //Casos de uso, segun historias de usuario ELIMINAR FUNCIONARIO,
    //No puedes volver a activarlo, para eso, necestiar crear toddo un registro de NUEVO FUNCIONARIO
    //void activarFuncionario();
    //void deshabilitarFuncionario();


    void registrarCargo();
    void deshabilitarCargo();
    void editarCargo();
    void listaDeCargos();

    void registrarDependencia();
    void deshabilitarDependencia();
    void editarDependencia();
    void listaDeDependencias();

    void registrarFuncionarioCargo();
    void deshabilitarFuncionarioCargo();

    void registrarFuncionarioDependencia();
    void deshabilitarFuncionarioDependencia();


    //Casos de uso, segun historias de usuario CREAR ROLES, EDITARLOS, PERMISOS
    void registrarUsuario();
    //void editarUsuario();
    void deshabilitarUsuario(); //Esto es a nivel de sistema, no podra iniciar sesion

    void registarRol();
    void deshabilitarRol();
    void editarRol();
    void listaDeRoles();

    void registarPermiso();
    void deshabilitarPermiso();
    void editarPermiso();
    void listaDePermisos();

    void registrarUsuarioRol();
    void deshabilitarUsuarioRol();

    void registrarPermisoRol();
    void deshabilitarPermisoRol();

    //Funciones adicionales para cumplir con los casos de usos anteriores
//    List<Rol> listaDeRoles();
//    List<Unidad> listaDeUnidades();
//    List<Cargo> listaDeCargos();


//    PaginableOut<UsuarioUnidad> listaDeUsuarios(PaginableIn paginableIn);
}
