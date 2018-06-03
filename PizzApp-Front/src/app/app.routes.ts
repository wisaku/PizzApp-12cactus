import { RouterModule, Routes } from '@angular/router';
import {CrearPedidoComponent} from './nuevo-pedido/crear-pedido/crear-pedido.component';
/*import {CrearPedidoService} from './nuevo-pedido/crear-pedido.service';*/

const APP_ROUTES: Routes = [
  {
    path: 'nuevoPedido',
    component: CrearPedidoComponent
    /*canActivate: [CrearPedidoService]*/
  }
] ;

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
