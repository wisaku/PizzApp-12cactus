import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from '../../components/interfaces/Pedido';


@Injectable()
export class PedidoService {

    public url: string;

    constructor(
        public http: HttpClient
    ) {
        this.url = 'http://localhost:8080/PizzApp/rest/pedidoService/crearPedido';
    }

    addPedido(pedido: Pedido): Observable<any> {
        const json = JSON.stringify(pedido);
        const params = json;
        const headers = new HttpHeaders().set('Content-Type', 'application/json');
        console.log(this.url);
        return this.http.post(this.url, params, { headers: headers }); // .pipe();
    }

}

