// Angular
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// Routing
import { APP_ROUTING} from './app.routes';

// Components
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {NuevoPedidoModule} from './nuevo-pedido/nuevo-pedido.module';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { HomeClientesComponent } from './components/home-clientes/home-clientes.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CrearClienteComponent,
    HomeClientesComponent,
  ],
  imports: [
    BrowserModule,
    NuevoPedidoModule,
    APP_ROUTING
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
