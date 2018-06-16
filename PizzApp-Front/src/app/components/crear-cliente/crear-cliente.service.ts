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
    let json = JSON.stringify(cliente);
    let params = json;
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    console.log(this.url);
    return this.http.post(this.url, params, { headers: headers });//.pipe();
  }


}



/*import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Cliente} from '../../interfaces/Cliente';
import { catchError, retry } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpErrorHandler, HandleError } from '../../http-error-handler.service';

@Injectable()
export class CrearClienteService {
  private handleError: HandleError;
  constructor(private http: HttpClient, httpErrorHandler: HttpErrorHandler) { 
    this.handleError = httpErrorHandler.createHandleError('ClienteService');
  }

  addCliente(cliente: Cliente): Observable<any> {
    let json = JSON.stringify(cliente);
    let url: 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente';
    //El backend recogerá un parametro json
    let params = "json=" + json;
    console.log("funciona lpmqtp")
    //Establecemos cabeceras
    let headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');

    return this.http.post(url , params, { headers: headers });
  }

}
*/