import { Component, OnInit, Output, EventEmitter} from '@angular/core';
import {CrearClienteService} from './crear-cliente.service';
import {Cliente} from '../interfaces/Cliente';


@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  clientes: Cliente[];
  model: Cliente = new clienteTable('', '', '', 0);
  @Output() onsubmit = new EventEmitter<any>();
  constructor(private clienteService: CrearClienteService) { }

  ngOnInit() {
  }

  submit() {
    this.onsubmit.emit(this.model);
    console.log(this.model);
    this.clienteService.addCliente(this.model).subscribe();
    this.model = new clienteTable('', '', '', 0);
  }

}

// tslint:disable-next-line:class-name
export class clienteTable implements Cliente {
  constructor(public nombre, public apellido, public direccion, public telefono) { }
}

