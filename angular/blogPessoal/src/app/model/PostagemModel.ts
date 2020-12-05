import { TemaModel } from './TemaModel';

export class PostagemModel
{
    public id: number;
    public ano: number;
    public titulo: string;
    public autor: string;
    public descricao: string;
    public data: Date;
    public tema: TemaModel;


}