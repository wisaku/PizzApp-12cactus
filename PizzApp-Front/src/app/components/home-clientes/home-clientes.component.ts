import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-clientes',
  templateUrl: './home-clientes.component.html',
  styleUrls: ['./home-clientes.component.css']
})
export class HomeClientesComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  agregarCliente(){
    this._router.navigate(['crearCliente']);
  }
}
