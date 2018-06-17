import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';




@Injectable()
export class PedidoService {
    public url: string;

    constructor(
        public http: HttpClient
    ) {
        this.url = 'http://localhost:8080/PizzApp/rest/clienteService/crearCliente';
    }

/*
    crear(cliente: number, producto: Array<number>, usuario: number): Observable<any> {
        let json = JSON.stringify(cliente);
        let params = json;
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        console.log(this.url);
        return this.http.post(this.url, params, { headers: headers });//.pipe();*/
    }


}

