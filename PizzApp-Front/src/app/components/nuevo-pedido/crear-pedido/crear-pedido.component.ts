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
    this.productos = []; 
  }

  addProduct(producto){
    if ((this.getTodosLosProductos()).includes(producto.nombre)){
      this.productos.forEach(element => {
        console.log(element + "es igual a" + producto.nombre)
        if (element.producto === producto.nombre) {
          this.sumarUnoAlProducto(element);
        }
      });
    }
    else{
        var line = new lineaTable(producto.nombre, 1, producto.precio);
        this.productos.push(line);
    }
  }

  getTodosLosProductos(){
    var todosLosProductos = [];
    this.productos.forEach(element => {
        todosLosProductos.push(element.producto)
    });
    return todosLosProductos;
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

  crearPedido(){

  }

}
export class productoTable implements Producto {
  constructor(public nombre, public precio) {}
}



export class lineaTable implements Linea {
  constructor(public producto, public cantidad, public precio) { }
}