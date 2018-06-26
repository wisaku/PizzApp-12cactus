import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-buscar-cliente',
  templateUrl: './buscar-cliente.component.html',
  styleUrls: ['./buscar-cliente.component.css']
})
export class BuscarClienteComponent implements OnInit {
  clientes = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.clientes = this.getClientes();
  }

  getClientes() {
    const self = this;
    this.http.get('http://localhost:8080/PizzApp/rest/clienteService/todosLosClientes')
    .subscribe(
      result => {
        this.clientes = result;
      },
      error => {
        console.log('problemas');
      });
  }

}


