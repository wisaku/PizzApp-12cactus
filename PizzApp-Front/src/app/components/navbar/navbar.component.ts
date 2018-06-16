import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Router } from '@angular/core';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  productos = [];
  constructor(private http: HttpClient){}
    //, public navCtrl: ) { }

  ngOnInit() {
  }

 /* irAProductos(){
    this.navCtrl.push('Productos')
  }


  <div ngFor="producto in this.productos">
    <p> {{ producto.nombre }} <\p>

  // Esto va en el component Productos que vas a crear =). 
  // En el constructor vas a llamar a esta funcion, asi ni bien arranca ya los trae
  listarProductos(){
    this.http.get()
      .then( (data)=> {
        if(data.status = 'success'){
          this.productos = JSON.parse(data.data);
        }
      })
  }*/

}
