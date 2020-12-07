import { Postagem } from './Postagem';

export class Tema{
    public  Id_tema: number
    public quantidade: number
    public  nome: string
    public descricao: string
    public  postagem: Postagem[];
    
    }