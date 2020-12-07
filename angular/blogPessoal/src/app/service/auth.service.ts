import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserLogin } from '../model/UserLogin';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
   }


   logar(userLogin : UserLogin)
   {
      return this.http.post('http://192.168.99.100:9000/usuarios/logar', userLogin );
   }

   cadastrar(usuario : Usuario)
   {
      return this.http.post('http://192.168.99.100:9000/usuarios/cadastrar', usuario );
   }

   btnSair()
   {
      let ok = false;
      let token= localStorage.getItem('token');

      if(token!=null)
      {
         ok = true;
      }

      return ok;
   }

   btnLogin()
   {
      let ok = false;
      let token= localStorage.getItem('token');

      if(token==null)
      {
         ok = true;
      }

      return ok;
   }

}