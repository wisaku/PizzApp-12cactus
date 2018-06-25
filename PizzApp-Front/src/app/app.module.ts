// Angular
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
// Routing
import { APP_ROUTING} from './app.routes';

// Components
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { NuevoPedidoModule } from './components/nuevo-pedido/nuevo-pedido.module';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { HomeClientesComponent } from './components/home-clientes/home-clientes.component';
import { CrearClienteService } from './components/crear-cliente/crear-cliente.service';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './components/footer/footer.component';
import { BuscarClienteComponent } from './components/buscar-cliente/buscar-cliente.component';
import { NuevoProductoComponent } from './components/nuevo-producto/nuevo-producto.component';
import { BuscarProductoComponent } from './components/buscar-producto/buscar-producto.component';
import { HttpErrorHandler } from './http-error-handler.service';
import { MessageService } from './message.service';
import { PedidoService } from './components/services/pedido.service';
import { ClienteService } from './components/services/cliente.service';
import { BuscarPedidoComponent } from './components/buscar-pedido/buscar-pedido.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CrearClienteComponent,
    HomeClientesComponent,
    FooterComponent,
    BuscarClienteComponent,
    NuevoProductoComponent,
    BuscarProductoComponent,
    BuscarPedidoComponent,
  ],
  imports: [
    BrowserModule,
    NuevoPedidoModule,
    APP_ROUTING,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    CrearClienteService,
    ClienteService,
    PedidoService,
    HttpErrorHandler,
    MessageService
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
