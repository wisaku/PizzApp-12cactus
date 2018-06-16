import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-buscar-producto',
  templateUrl: './buscar-producto.component.html',
  styleUrls: ['./buscar-producto.component.css']
})
export class BuscarProductoComponent implements OnInit {
  productos = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.productos = this.getProductos();
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
}