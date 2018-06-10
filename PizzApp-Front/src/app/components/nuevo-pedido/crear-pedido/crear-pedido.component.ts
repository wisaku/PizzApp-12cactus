import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html',
  styleUrls: ['./crear-pedido.component.css']
})
export class CrearPedidoComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  crearPedido() {
    this._router.navigate(['dropdown']);
  }

}
