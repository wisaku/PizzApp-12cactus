import { RouterModule, Routes } from '@angular/router';

import {NuevoPedidoModule} from './nuevo-pedido/nuevo-pedido.module';
import {CrearPedidoService} from './nuevo-pedido/crear-pedido.service';

const APP_ROUTES: Routes = [
  {
    path: 'nuevoPedido',
    component: NuevoPedidoModule,
    canActivate: [CrearPedidoService]},
] ;

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
