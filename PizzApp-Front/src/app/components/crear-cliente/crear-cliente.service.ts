import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Cliente} from '../../interfaces/Cliente';
//import { Http, RequestOptions, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class CrearClienteService {
/*
  constructor(private _http: Http) { }

  extensionUrl: 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente/';

  crearCliente(cliente: Cliente): Observable<Response> {

    const header = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions ( { headers: header });


    this._http.post(this.extensionUrl, cliente, options).map((res: any) => { res.json(); } );

  }
  */
 constructor(private http: HttpClient) { }

  crearCliente() {
    console.log("data");
    
    
    /*let self = this;
    this.http.post("url", data)

    .subscribe(
      result => {
        this.articulos = result;
      },
      error => {
        console.log('problemas');
      })*/
   }
}
