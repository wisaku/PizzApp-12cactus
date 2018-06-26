import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../../components/interfaces/Cliente';


@Injectable()
export class ClienteService {


    constructor(private http: HttpClient) { }


}

