import { RouterModule, Routes } from '@angular/router';
import {CrearPedidoComponent} from './components/nuevo-pedido/crear-pedido/crear-pedido.component';
import {CrearClienteComponent} from './components/crear-cliente/crear-cliente.component';
import {HomeClientesComponent} from './components/home-clientes/home-clientes.component';
import {DropdownComponent} from './dropdown/dropdown.component';
/*import {CrearPedidoService} from './nuevo-pedido/crear-pedido.service';*/

const APP_ROUTES: Routes = [
  {
    path: 'nuevoPedido', component: CrearPedidoComponent
    /*canActivate: [CrearPedidoService]*/
  },
  {
    path: 'crearCliente', component: CrearClienteComponent
  },
  {
    path: 'homeClientes', component: HomeClientesComponent
  },
  {
    path: 'dropdown', component: DropdownComponent
  }
] ;

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
