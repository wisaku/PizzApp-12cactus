import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Linea } from '../../../interfaces/Linea';
import { Producto } from '../../../interfaces/Producto';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html',
  styleUrls: ['./crear-pedido.component.css']
})
export class CrearPedidoComponent implements OnInit {

  constructor(private _router: Router, private http: HttpClient) { }
  productos = null;
  productosPedidos = null;
  lines = null;
  ngOnInit() {
    this.productos = this.getProductos();
    this.productosPedidos = [];
    this.lines = [];
  }

  addProduct(producto){
    console.log(producto);
    this.productosPedidos.push(producto);
    //new productoTable(producto, 1);
    var line = new lineaTable(producto.nombre,1,producto.precio);
    this.lines.push(line);

  }
  deleteLine(index) {
    this.lines.splice(index, 1);
  }


  getProductos(){
    let self = this;
    this.http.get("http://localhost:8080/PizzApp/rest/productoService/todosLosProductos")
      .subscribe(
        result => {
          this.productos = result;
        },
        error => {
          console.log('problemas');
        })
  }

  crearPedido() {
    this._router.navigate(['dropdown']);
  }

}
export class productoTable implements Producto {
  constructor(public nombre, public precio) {}
}

export class lineaTable implements Linea {
  constructor(public producto, public cantidad, public precio) { }
}