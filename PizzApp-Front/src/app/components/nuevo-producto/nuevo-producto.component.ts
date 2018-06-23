import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NuevoProductoService } from '../services/nuevo-producto.service';
import { Producto } from '../interfaces/Producto';
import { productoTable } from '../nuevo-pedido/crear-pedido/crear-pedido.component';

@Component({
  selector: 'app-nuevo-producto',
  templateUrl: './nuevo-producto.component.html',
})
export class NuevoProductoComponent implements OnInit {
  constructor(private productoService: NuevoProductoService) { }
  productos : Producto[];
  model: Producto = new productoTable('', '', '');
  
  @Output() onsubmit = new EventEmitter<any>();
   
    ngOnInit() {
    
   }
   
   submit() {
    this.onsubmit.emit(this.model);
    console.log(this.model);
    this.productoService.addProducto(this.model).subscribe(producto => this.productos.push(producto));
    this.model = new productoTable('', '', '');
  }

}
