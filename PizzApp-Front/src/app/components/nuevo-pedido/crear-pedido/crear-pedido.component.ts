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
        if (element.producto === producto.nombre) {
          this.sumarUnoAlProducto(element);
        }
      });
    } else {
        const line = new lineaTable(producto.nombre, 1, producto.precio);
        this.productos.push(line);
    }
  }

  getTodosLosProductos() {
    const todosLosProductos = [];
    this.productos.forEach(element => {
        todosLosProductos.push(element.producto);
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
        },
        error => {
          console.log('problemas');
        });
  }

  crearPedido() {
    console.log('hola que aseeee00');
    const pedido = new pedidoTable('1' , this.productos, '1');
    this.onsubmit.emit(pedido);
    console.log(pedido);
    this.pedidoService.addPedido(pedido).subscribe(pedidoNuevo => this.pedidos.push(pedidoNuevo));
  }

}
// tslint:disable-next-line:class-name
export class productoTable implements Producto {
  constructor(public productoId, public nombre, public precio) {}
}



// tslint:disable-next-line:class-name
export class lineaTable implements Linea {
  constructor(public productoId , public producto, public cantidad, public precio) { }
}
// tslint:disable-next-line:class-name
export class pedidoTable implements Pedido {
  constructor(public cliente, public linea, public usuario) { }
}
