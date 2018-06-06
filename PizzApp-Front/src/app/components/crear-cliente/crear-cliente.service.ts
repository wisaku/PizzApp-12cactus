import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrearClienteService {

  constructor(private http: HttpClient) { }

  createClienteFromServer(unCliente): Observable<Object> {

    const url = 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente';
    const body = JSON.stringify(unCliente);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post(url, body);
  }

  getHeaders(): HttpHeaders {
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'Application/Json');
    return headers;
  }

}
