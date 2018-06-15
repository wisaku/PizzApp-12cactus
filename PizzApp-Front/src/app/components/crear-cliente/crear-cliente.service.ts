import { Injectable } from '@angular/core';
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

  extensionUrl: 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente';

 /* crearCliente(cliente: Cliente): Observable<Response> {

    const header = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions ( { headers: header });


    this._http.post(this.extensionUrl, cliente, options).map((res: any) => { res.json(); } );

  }
  

  crearCliente() {
    console.log("data");
    
    
    let self = this;
    this.http.post("url", data)

    .subscribe(
      result => {
        this.articulos = result;
      },
      error => {
        console.log('problemas');
      })
   }
*/
  /** POST: add a new hero to the database */
  crearCliente(cliente: Cliente): Observable<Cliente> {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'text/html; charset=iso-8859-1',
      })
    };
    console.log(httpOptions)
    return this.http.post<Cliente>(this.extensionUrl, cliente, httpOptions)
      .pipe(
      catchError(this.handleError('addHero', cliente))
      );
  }
   
  crearCliente(cliente: Cliente): Observable<Cliente>  {
    return this.http.post<Cliente>(this.extensionUrl, cliente, httpOptions).pipe(
      tap((cliente: Cliente) => this.log(`added hero w/ nombre${cliente.nombre}`)),
      catchError(this.handleError<Cliente>('addHero'))
    );
  }



}
