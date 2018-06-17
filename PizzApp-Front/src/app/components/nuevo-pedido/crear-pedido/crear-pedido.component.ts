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
  productosDisponibles = null;
  productosDelPedido = null;
  productos = null;

  ngOnInit() {
    this.productosDisponibles = this.getProductos(); 
    this.productosDelPedido = []; 
    this.productos = []; 
  }

  addProduct(producto){
    console.log(producto);
    this.productosDelPedido.push(producto);
    
    var line = new lineaTable(producto.nombre,1,producto.precio);
    this.productos.push(line);

  }

  sumarUnoAlProducto(producto){
    producto.cantidad ++;
  }

  restarUnoAlProducto(producto) {
    if(producto.cantidad==1)
      return;
    producto.cantidad--;
  }

  deleteLine(index) {
    this.productos.splice(index, 1);
  }

  getProductos(){
    let self = this;
    this.http.get("http://localhost:8080/PizzApp/rest/productoService/todosLosProductos")
      .subscribe(
        result => {
          this.productosDisponibles = result;
        },
        error => {
          console.log('problemas');
        })
  }

}
export class productoTable implements Producto {
  constructor(public nombre, public precio) {}
}

export class lineaTable implements Linea {
  constructor(public producto, public cantidad, public precio) { }
}