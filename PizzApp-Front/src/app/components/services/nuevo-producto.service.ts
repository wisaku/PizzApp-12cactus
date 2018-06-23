import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../interfaces/Producto';

@Injectable({
  providedIn: 'root'
})
export class NuevoProductoService {
  public url: string;

  constructor(
    public http: HttpClient
  ) {
    this.url = 'http://localhost:8080/PizzApp/rest/productoService/crearProducto';
  }


  addProducto(producto: Producto): Observable<any> {
    const json = JSON.stringify(producto);
    const params = json;
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, params, { headers: headers }); // .pipe();
  }
} 

// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class NuevoProductoService {

//   constructor() { }
// }
