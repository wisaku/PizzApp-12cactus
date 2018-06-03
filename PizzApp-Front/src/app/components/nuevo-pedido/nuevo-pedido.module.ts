import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CrearPedidoComponent } from './crear-pedido/crear-pedido.component';
import {CrearPedidoService} from './crear-pedido.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CrearPedidoComponent
  ],
  exports: [
    CrearPedidoComponent
  ],
  providers: []
})

export class NuevoPedidoModule { }
