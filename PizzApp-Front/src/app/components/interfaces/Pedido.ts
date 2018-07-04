import { Linea } from '../interfaces/Linea';

export interface Pedido {
  id: String;
  cliente: string;
  linea: Linea[];
  usuario: string;
  estado: string;
}
