import { Tema } from './Tema';

export class Postagem
{
    public id: number;
    public ano: number;
    public titulo: string;
    public autor: string;
    public texto: string;
    public data: Date;
    public tema: Tema;


}
