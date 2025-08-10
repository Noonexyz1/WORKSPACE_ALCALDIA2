export interface Persona {
  id: number;
  ci: string;
  nombre: string;
  apellidoPaterno: string;
  apellidoMaterno: string;
}

export interface Rol {
  id: number;
  nombre: string;
  descripcion: string;
}

export interface Usuario {
  id: number | null;
  username: string;
  password?: string; // Hacemos la contraseña opcional, ya que no siempre la recibirás
  persona: Persona | null;
}

export interface UsuarioRol {
  id: number;
  isActive: boolean;
  usuario: Usuario;
  rol: Rol;
}
