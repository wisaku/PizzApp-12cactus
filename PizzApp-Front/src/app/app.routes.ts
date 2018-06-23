import { RouterModule, Routes } from '@angular/router';
import {CrearPedidoComponent} from './components/nuevo-pedido/crear-pedido/crear-pedido.component';
import {CrearClienteComponent} from './components/crear-cliente/crear-cliente.component';
import {HomeClientesComponent} from './components/home-clientes/home-clientes.component';
import {BuscarClienteComponent} from './components/buscar-cliente/buscar-cliente.component';
import {NuevoProductoComponent} from './components/nuevo-producto/nuevo-producto.component';
import {BuscarProductoComponent} from './components/buscar-producto/buscar-producto.component';
import { BuscarPedidoComponent } from './components/buscar-pedido/buscar-pedido.component';
/*import {CrearPedidoService} from './nuevo-pedido/crear-pedido.service';*/

const APP_ROUTES: Routes = [
  {
    path: 'nuevoPedido', component: CrearPedidoComponent
    /*canActivate: [CrearPedidoService]*/
  },
  {
    path: 'buscarPedido', component: BuscarPedidoComponent
  },
  {
    path: 'crearCliente', component: CrearClienteComponent
  },
  {
    path: 'homeClientes', component: HomeClientesComponent
  },
  {
    path: 'buscarCliente', component: BuscarClienteComponent
  },
  {
    path: 'nuevoProducto', component: NuevoProductoComponent
  },
  {
    path: 'buscarProducto', component: BuscarProductoComponent
  }
] ;

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
