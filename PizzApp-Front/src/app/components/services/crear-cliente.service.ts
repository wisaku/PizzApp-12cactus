import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../../interfaces/Cliente';

@Injectable()
export class CrearClienteService {
  public url: string;

  constructor(
    public http: HttpClient
  ) {
    this.url = 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente';
  }


  addCliente(cliente: Cliente): Observable<any> {
    const json = JSON.stringify(cliente);
    const params = json;
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.url, params, { headers: headers }); // .pipe();
  }
}
