import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PizzApp';
  private articulos = null;
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/PizzApp/rest/testRest/get/7")
      .subscribe(
        result => {
          this.articulos = result;
        },
        error => {
          console.log('problemas');
        }
      );
  }


 

/*  @Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
  })
  /*export class AppComponent {
    nombre = 'Rodriguez Pablo';
    edad = 40;
    email = 'rpablo@gmail.com';
    sueldos = [1700, 1600, 1900];
    activo = true;
  
    esActivo() {
      if (this.activo)
        return 'Trabajador Activo';
      else
        return 'Trabajador Inactivo';
    }
  
    ultimos3Sueldos() {
      let suma=0;
      for(let x=0; x<this.sueldos.length; x++)
        suma+=this.sueldos[x];
      return suma;
    }*/

    
}  

