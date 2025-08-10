import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CredencialRequest } from '../../utils/models/CredencialRequest';
import { UsuarioResponse } from '../../utils/models/UsuarioResponse';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { catchError, map, of } from 'rxjs';
import { RootNavigateService } from '../../utils/services/root-navigate/root-navigate.service';
import { LocalStorageService } from '../../utils/services/local-storage/local-storage.service';
import {UrlsProperties} from "../../utils/enums/UrlsProperties";
import {ImagesProperties} from "../../utils/enums/ImagesProperties";
import {Usuario, UsuarioRol} from "../../utils/models/TypeDTO";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html'
})
export class LoginComponent {

  PATH_IMAGE_LOGO: string = ImagesProperties.PATH_IMAGE_LOGO;
  loginForm: FormGroup;

  constructor(
    private http: HttpClient,
    private formBuilder: FormBuilder,
    //Mis servicios
    private rootNavigateService: RootNavigateService,
    private localStorage: LocalStorageService){

    this.loginForm = this.formBuilder
      .group({
        ci: [],
        pass: [],
      });
  }

  botonIniciarSesion(): void {
    // Extraer los valores del formulario
    const usuario: Usuario = {
      id: null,
      username: this.loginForm.get('ci')?.value,
      password: this.loginForm.get('pass')?.value,
      // Creamos un objeto que cumpla con la interfaz Persona
      persona: null
    };

    // Recibimos la peticion
    this.http.post<UsuarioRol>(
      UrlsProperties.PATH_LOGIN,
      usuario
    ).pipe(
      map((response: UsuarioRol) => {
        //Guardamos en el localStorage
        this.localStorage.setItem('userData', response);
        this.rootNavigateService.valorParaNavegar(response.rol.nombre);
      }),
      catchError(error => {
        alert('Hubo un error al iniciar sesión');
        return of(null);
      })
    ).subscribe();
  }

}
