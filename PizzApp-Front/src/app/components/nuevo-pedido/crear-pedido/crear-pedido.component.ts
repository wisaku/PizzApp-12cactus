import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Linea } from '../../../interfaces/Linea';
import { Producto } from '../../../interfaces/Producto';
import { Pedido } from '../../../interfaces/Pedido';
import { PedidoComponent } from '../../../pedido/pedido.component';
import { PedidoService } from '../../services/pedido.service';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html',
  styleUrls: ['./crear-pedido.component.css']
})
export class CrearPedidoComponent implements OnInit {

  @Output() onsubmit = new EventEmitter<any>();
  constructor(private _router: Router, private http: HttpClient, private pedidoService: PedidoService) { }
  productosDisponibles = null;
  productosDelPedido = null;
  productos = null;
  pedidos: Pedido[];

  ngOnInit() {
    this.productosDisponibles = this.getProductos();
    this.productos = [];
  }

  addProduct(producto) {
    if ((this.getTodosLosProductos()).includes(producto.nombre)) {
      this.productos.forEach(element => {
        console.log(element + 'es igual a' + producto.nombre);
        if (element.nombre === producto.nombre) {
          this.sumarUnoAlProducto(element);
        }
      });
    } else {
      console.log('productoId------> ' + producto.productoId);
      const line = new lineaTable(producto.id, producto.nombre, producto.precio, '1');
        this.productos.push(line);
    }
  }

  getTodosLosProductos() {
    const todosLosProductos = [];
    this.productos.forEach(element => {
        todosLosProductos.push(element.nombre);
    });
    return todosLosProductos;
  }

  sumarUnoAlProducto(producto) {
    producto.cantidad ++;
  }

  restarUnoAlProducto(producto) {
    if (producto.cantidad === 1) {
      return;
    }
    producto.cantidad--;
  }

  deleteLine(index) {
    this.productos.splice(index, 1);
  }

  getProductos() {
    const self = this;
    this.http.get('http://localhost:8080/PizzApp/rest/productoService/todosLosProductos')
      .subscribe(
        result => {
          this.productosDisponibles = result;
          console.log(result);
        },
        error => {
          console.log('problemas');
        });
  }

  crearPedido() {
    const pedido = new pedidoTable('1111' , this.productos, '1');
    this.onsubmit.emit(pedido);
    console.log(pedido);
    this.pedidoService.addPedido(pedido).subscribe();
  }

}
// tslint:disable-next-line:class-name
export class productoTable implements Producto {
  constructor(public id, public nombre, public precio) {}
}



// tslint:disable-next-line:class-name
export class lineaTable implements Linea {
  constructor(public id, public nombre, public precio, public cantidad ) { }
}
// tslint:disable-next-line:class-name
export class pedidoTable implements Pedido {
  constructor(public cliente, public linea, public usuario) { }
}
