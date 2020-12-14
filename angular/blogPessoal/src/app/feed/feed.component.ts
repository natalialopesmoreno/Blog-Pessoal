import { Router, RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Postagem } from '../model/Postagem';
import { Tema } from '../model/Tema';
import { AlertasService } from '../service/alertas.service';
import { PostagemService } from '../service/postagem.service';
import { TemaService } from '../service/tema.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  constructor(private postagemService: PostagemService,
              private temaService:TemaService,
              private alert : AlertasService,
              private route :Router) { }

  key = 'data'
  reverse = true

  postagem :Postagem = new Postagem();
  listaPostagem: Postagem[];
  titulo : string;

  tema : Tema = new Tema();
  listaTema: Tema[];
  idTema: number;
  nomeTema : string;



  ngOnInit(){

    let token = localStorage.getItem('token')
    if(token == null)
    {
      this.route.navigate(['/login'])
      this.alert.showAlertInfo("Faça o login para acessar o feed")
    }


    window.scroll(0,0);
    this.findAllPostagens();
    this.findAllTemas();

  }

  findAllPostagens()
  {
    this.postagemService.getAllPostagens().subscribe((resp:Postagem[])=> {this.listaPostagem = resp})
  }

  publicar()
  {
    this.tema.id = this.idTema;
    this.postagem.tema = this.tema

    if(this.postagem.tema == null || this.postagem.titulo  == null || this.postagem.texto == null )
    {
      this.alert.showAlertDanger("Preencha os campos corretamente!")
    }
    else
    {
      this.postagemService.postPostagem(this.postagem).subscribe((resp:Postagem)=>
      {
        this.postagem = resp;
        /* essa linha esvazia os campos para pegar outra postagem*/
        this.postagem = new Postagem();
        this.alert.showAlertSuccess("Postagem realizada!")
        this.findAllPostagens();
      })
    }
  }

  findAllTemas()
  {
    this.temaService.getAllTemas().subscribe((resp:Tema[])=> {this.listaTema = resp})
  }

  findByIdTemas()
  {
    this.temaService.getByIdTema(this.idTema).subscribe((resp:Tema)=> {
      this.tema = resp
    })
  }
  findByTituloPostagem()
  {
      if(this.titulo === '')
      {
        this.findAllPostagens();
      } else
      {
        this.postagemService.getByTituloPostagem(this.titulo).subscribe((resp:Postagem[])=>
        {this.listaPostagem = resp})
      }
  }

  findByNomeTema()
  {
    if(this.titulo === '')
      {
        this.findAllTemas();
      } else
      {
        this.temaService.getByNomeTema(this.nomeTema).subscribe((resp:Tema[])=>
        {this.listaTema = resp})
      }
  }

}
