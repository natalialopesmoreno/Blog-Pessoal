import { Usuario } from './../model/Usuario';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { AlertasService } from '../service/alertas.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  user:Usuario = new Usuario();
  senha:string;

  constructor(private authService:AuthService,
              private router: Router,
              private alert : AlertasService) { }

  ngOnInit() {


  }

  conferirSenha(event:any)
  {
      this.senha = event.target.value;
  }

  cadastrar()
  {
    if(this.senha === this.user.senha)
    {
      this.authService.cadastrar(this.user).subscribe((resp:Usuario)=>{this.user = resp})
      this.router.navigate(['/login'])
    }else
    {
      this.alert.showAlertDanger('Senha não confere')
    }
  }

}
