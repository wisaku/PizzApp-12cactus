// Angular
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
import {HttpClientModule} from '@angular/common/http';
import { FooterComponent } from './components/footer/footer.component';
import { BuscarClienteComponent } from './components/buscar-cliente/buscar-cliente.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PedidoComponent,
    CrearClienteComponent,
    HomeClientesComponent,
    DropdownComponent,
    FooterComponent,
    BuscarClienteComponent,
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
