import { Component, OnInit } from '@angular/core';
import {CrearClienteService} from './crear-cliente.service';
import {Cliente} from '../../interfaces/Cliente';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  clientes: Cliente[];

  constructor(private _clienteService: CrearClienteService) { }

  ngOnInit() {
  }

  persistirCliente() { }

}
