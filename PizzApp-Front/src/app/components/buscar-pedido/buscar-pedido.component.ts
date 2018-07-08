import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-buscar-pedido',
  templateUrl: './buscar-pedido.component.html',
})
export class BuscarPedidoComponent implements OnInit {
  pedidos = null;
  myField;
  nroCliente = '';
  estado = '';
  pedidosPorCliente = null;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.pedidos = this.getPedidos();
  }

  getPedidos() {
    const self = this;
    this.http.get('http://localhost:8080/PizzApp/rest/pedidoService/todosLosPedidos')
    .subscribe(
      result => {
        this.pedidos = result;
        this.pedidosPorCliente = result;
        this.filtrar();
      },
      error => {
        console.log('problemas');
      });
  }
  cerrarPedido(pedido) {
    let res = 0;
    pedido.linea.forEach(lin => {
      res = res + lin.precio;
    });
    this.myField = res;
    this.mandarCierreBack(pedido);
  }

  filtrarClientes() {
    if (this.nroCliente === '') {
      this.pedidosPorCliente = this.pedidos;
    } else {
    this.pedidosPorCliente = this.pedidos.filter(p => p.cliente === this.nroCliente);
    }
  }

  cancelarPedido(pedido) {
    pedido.estado = 'RECHAZADO';
    this.http.get('http://localhost:8080/PizzApp/rest/pedidoService/cancelarPedido/' + pedido.id)
      .subscribe(
        result => {
        },
        error => {
          console.log('problemas');
        });
    this.filtrar();
  }

  mandarCierreBack(pedido) {
    pedido.estado = 'CERRADO';
    this.http.get('http://localhost:8080/PizzApp/rest/pedidoService/cerrarPedido/' + pedido.id)
      .subscribe(
        result => {
        },
        error => {
          console.log('problemas');
        });
    this.filtrar();
  }


  mostrarEnCurso() {
    this.filtrarEstado('ENCURSO');
  }
  mostrarListo() {
    this.filtrarEstado('LISTO');
  }
  mostrarEntregado() {
    this.filtrarEstado('ENTREGADO');
  }
  mostrarRechazado() {
    this.filtrarEstado('RECHAZADO');
  }
  mostrarCerrado() {
    this.filtrarEstado('CERRADO');
    console.log('puto');
  }

  filtrarEstado(estado) {
    this.filtrarClientes();
    if (estado === '') {
      return;
    } else {
      this.pedidosPorCliente = this.pedidosPorCliente.filter(p => p.estado === estado);
    }
  }


  filtrar() {
    this.pedidosPorCliente = this.pedidos.filter(p => p.estado !== 'RECHAZADO');
  }
}


