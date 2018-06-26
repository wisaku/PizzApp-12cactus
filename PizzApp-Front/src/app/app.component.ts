import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PizzApp';
  articulos = null;

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnInit() {
    const self = this;
    this.http.get('http://localhost:8080/PizzApp/rest/productoService/buscarProducto/1')
    .subscribe(
      result => {
        this.articulos = result;
      },
      error => {
        console.log('problemas');
      });
   }

}

