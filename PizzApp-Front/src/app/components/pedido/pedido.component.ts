import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
})
export class PedidoComponent implements OnInit {
  contador: number;
  constructor() {
   }

  ngOnInit() {
    this.contador = 0;
  }

  incrementar() {
    this.contador++;
  }

  decrementar() {
    this.contador--;
  }

}
