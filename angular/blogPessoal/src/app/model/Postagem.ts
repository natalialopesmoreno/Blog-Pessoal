import { Tema } from './Tema';

export class Postagem
{
    public id: number;
    public ano: number;
    public titulo: string;
    public autor: string;
    public descricao: string;
    public data: Date;
    public tema: Tema;


}