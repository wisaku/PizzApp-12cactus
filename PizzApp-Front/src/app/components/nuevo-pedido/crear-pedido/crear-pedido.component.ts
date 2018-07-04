import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Linea } from '../../interfaces/Linea';
import { Producto } from '../../interfaces/Producto';
import { Pedido } from '../../interfaces/Pedido';
import { Cliente } from '../../interfaces/Cliente';
import { PedidoService } from '../../services/pedido.service';
import { ClienteService } from '../../services/cliente.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-crear-pedido',
  templateUrl: './crear-pedido.component.html'
})
export class CrearPedidoComponent implements OnInit {

  @Output() onsubmit = new EventEmitter<any>();
  // tslint:disable-next-line:max-line-length
  constructor(private route: ActivatedRoute, private _router: Router, private http: HttpClient, private pedidoService: PedidoService) { }
  productosDisponibles = null;
  productosDelPedido = null;
  productos = null;
  clientes: null;
  cliente = '';
  @Input() clienteInput: String;

  onKey(event: any) { // without type info
    this.cliente = event.target.value;
  }

  ngOnInit() {
    this.productosDisponibles = this.getProductos();
    this.productos = [];
    this.getClientes();
    const sub = this.route.params.subscribe(params => {
      console.log(JSON.stringify(params));
      this.cliente = params.cliente;
      console.log('elCli ' + this.cliente);
    });
  }

  getClientes() {
    const self = this;
    this.http.get('http://localhost:8080/PizzApp/rest/clienteService/todosLosClientes')
      .subscribe(
        result => {
          console.log(result);
          return result;
        },
        error => {
          console.log('problemas');
        });
  }


  addProduct(producto) {
    if ((this.getTodosLosProductos()).includes(producto.nombre)) {
      this.productos.forEach(element => {
        console.log(element + 'es igual a' + producto.nombre);
        if (element.nombreProd === producto.nombre) {
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
      todosLosProductos.push(element.nombreProd);
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
    const pedido = new pedidoTable(this.cliente , this.productos, '1', ' ');
    this.onsubmit.emit(pedido);
    console.log(pedido);
    this.pedidoService.addPedido(pedido).subscribe();
    this.productos = [];
  }

}
// tslint:disable-next-line:class-name
export class productoTable implements Producto {
  constructor(public id, public nombre, public precio) {}
}



// tslint:disable-next-line:class-name
export class lineaTable implements Linea {
  constructor(public idProd, public nombreProd, public precio, public cantidad ) { }
}
// tslint:disable-next-line:class-name
export class pedidoTable implements Pedido {
  constructor(public cliente, public linea, public usuario, public estado) { }
}
