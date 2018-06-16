
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent {
  title = 'app';
  name : string;

  constructor(private http: HttpClient){
  	this.name = "ALCORNOKE"; 
  	/*this.postService.getPosts().subscribe(posts=>{
  		console.log(posts);
  	});*/
  }

  guardarEnBbdd(){
  	/*lo que quiero q haga*/
  }
 
  ngOnInit(uno): void {
    //aca esta la direccion donde maru puso el get!!!
    this.http.get('https://localhost/get/' + uno).subscribe(data => {
      console.log(data);
    });
  }

  guardarEnBBDD(pedido){
  	/*lo que quiero q haga*/
    console.log("hola soy un pedido --->" +pedido.value);
    
    this.ngOnInit(pedido.value);
    

  	return false;
  } 
}
