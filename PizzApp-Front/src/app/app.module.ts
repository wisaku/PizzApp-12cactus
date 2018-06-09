// Angular
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

// Routing
import { APP_ROUTING} from './app.routes';

// Components
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import {NuevoPedidoModule} from './components/nuevo-pedido/nuevo-pedido.module';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { HomeClientesComponent } from './components/home-clientes/home-clientes.component';
import {CrearClienteService} from './components/crear-cliente/crear-cliente.service';
import { PedidoComponent } from './pedido/pedido.component';
import { DropdownComponent } from './dropdown/dropdown.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PedidoComponent,
    CrearClienteComponent,
    HomeClientesComponent,
    DropdownComponent,
  ],
  imports: [
    BrowserModule,
    NuevoPedidoModule,
    APP_ROUTING,
    HttpClientModule
  ],
  providers: [CrearClienteService],
  bootstrap: [AppComponent]
})

export class AppModule {
}
