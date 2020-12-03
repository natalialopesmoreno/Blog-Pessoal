import { PostagemModel } from './PostagemModel';

export class TemaModel{
    public  Id_tema: number
    public quantidade: number
    public  nome: string
    public descricao: string
    public  postagem: PostagemModel[];
    
    }