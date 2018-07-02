import { Linea } from '../interfaces/Linea';

export interface Pedido {
  cliente: string;
  linea: Linea[];
  usuario: string;
  estado: string;
}
