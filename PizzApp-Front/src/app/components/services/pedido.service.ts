import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
/*
import { Pedido } from './controllers';

@Injectable()
export class PedidoService {
    url = "http://localhost:8080/PizzApp/rest/testRest/";
    constructor(private http:Http) { }
    getPedido(): Observable<Pedido[]> {
        return this.http.get(this.url)
		   .map(this.extractData)
		   .catch(this.handleErrorObservable);
    }
    
    //TRABAJANDO CON OBSERVABLES
    addPedidoWithObservable(pedido:Pedido): Observable<Pedido> {
	let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url, pedido, options)
                   .map(this.extractData)
                   .catch(this.handleErrorObservable);
    }
/*
    //TRABAJANDO CON PROMISE
    getBooksWithPromise(): Promise<Book[]> {
        return this.http.get(this.url).toPromise()
		    .then(this.extractData)
	            .catch(this.handleErrorPromise);
    }
    addBookWithPromise(book:Book): Promise<Book> {
	let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url, book, options).toPromise()
	           .then(this.extractData)
                   .catch(this.handleErrorPromise);
    }		
*/   

    //ESTOS METODOS LOS NECESITO PARA TRANSFORMAR DATOS Y ENVIAR ERRORES
   /* private extractData(res: Response) {
	let body = res.json();
        return body || {};
    }
    private handleErrorObservable (error: Response | any) {
	console.error(error.message || error);
	return Observable.throw(error.message || error);
    }
    private handleErrorPromise (error: Response | any) {
	console.error(error.message || error);
	return Promise.reject(error.message || error);
    }	
}*/