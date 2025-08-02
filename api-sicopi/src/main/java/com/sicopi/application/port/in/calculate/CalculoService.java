package com.sicopi.application.port.in.calculate;

public interface CalculoService {
    //Funciones adicionales para cumplir con los casos de usos anteriores
//    List<Rol> listaDeRoles();
//    List<Unidad> listaDeUnidades();
//    List<Cargo> listaDeCargos();


//    PaginableOut<UsuarioUnidad> listaDeUsuarios(PaginableIn paginableIn);


    //Metodo que no necesita de PUERTOS salientes por ser un metodo de negocio
    // tipo calular algo cosas asi
    void calcularImpuesto();
}
