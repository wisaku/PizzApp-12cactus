package com.example.saba.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapDropDown;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PedidoActivity extends AppCompatActivity {
    Pedido pedido = null;
    BootstrapButton toFrist = null;
    BootstrapButton cerrarPedido = null;
    ListView itemList = null;
    BootstrapDropDown spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        Bundle bundle = getIntent().getExtras();
        pedido = (Pedido) bundle.get("pedido");

        toFrist = findViewById(R.id.irALista);
        itemList = findViewById(R.id.listComponent);
        spinner = findViewById(R.id.ordersSpn);
        cerrarPedido = findViewById(R.id.cerrarPedido);

        renderMesa();

        spinner.setOnDropDownItemClickListener(new BootstrapDropDown.OnDropDownItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View v, int id) {


                if(id == 0){
                    pedido.setCliente("212");
                    spinner.setText("Mesa 1");
                    return;
                }
                if(id == 1){
                    pedido.setCliente("213");
                    spinner.setText("Mesa 2");
                    return;
                }
                if(id == 2){
                    pedido.setCliente("214");
                    spinner.setText("Mesa 3");
                    return;
                }
                if(id == 3){
                    pedido.setCliente("215");
                    spinner.setText("Mesa 4");
                    return;
                }
                if(id == 4){
                    pedido.setCliente("216");
                    spinner.setText("Mesa 5");
                    return;
                }
                if(id == 5){
                    pedido.setCliente("217");
                    spinner.setText("Mesa 6");
                    return;
                }
                if(id == 6){
                    pedido.setCliente("218");
                    spinner.setText("Mesa 7");
                    return;
                }
                if(id == 7){
                    pedido.setCliente("219");
                    spinner.setText("Mesa 8");
                    return;
                }
                if(id == 8){
                    pedido.setCliente("220");
                    spinner.setText("Mesa 9");
                    return;
                }
                if(id == 9){
                    pedido.setCliente("221");
                    spinner.setText("Mesa 10");
                    return;
                }



            }
        });

        cerrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("0".equalsIgnoreCase(pedido.getCliente())){
                    Toast.makeText(getApplicationContext(),"Ingrese una mesa por favor",Toast.LENGTH_SHORT).show();

                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(PedidoActivity.this).
                        setTitle("Crear pedido").setMessage("¿Seguro desea Crear el pedido?");

                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        closePedido();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


                
            }
        });

        toFrist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tofristStep();
            }
        });


        render();


    }

    private void closePedido() {

        try {

            final RequestQueue queue = Volley.newRequestQueue(PedidoActivity.this);

        final JSONObject param;

            param = new JSONObject((new Gson()).toJson(pedido));

            String ipconfig = getString(R.string.ipConfig);
            String url =  "http://"+ ipconfig +"/PizzApp/rest/pedidoService/crearPedido/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                AlertDialog.Builder builder = new AlertDialog.Builder(PedidoActivity.this);
                builder.setMessage("La orden se creo correctamente")
                        .setTitle("Aviso").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pedido = null;
                        tofristStep();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

                Log.d("pedido", response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public byte[] getBody() {
                return param.toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


            queue.add(stringRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void render() {
        PedidoArrayAdapter adapter= new PedidoArrayAdapter(PedidoActivity.this,pedido.getLinea(), 0);
        itemList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void tofristStep() {

        Intent intent = new Intent(PedidoActivity.this,MainActivity.class);
        intent.putExtra("pedido", pedido);

        startActivity(intent);
    }


    private void renderMesa(){
        if("212".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 1");
            return;
        }
        if("213".equalsIgnoreCase(pedido.getCliente())){

            spinner.setText("Mesa 2");
            return;
        }
        if("214".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 3");
            return;
        }
        if("215".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 4");
            return;
        }
        if("216".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 5");
            return;
        }
        if("217".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 6");
            return;
        }
        if("218".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 7");
            return;
        }
        if("219".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 8");
            return;
        }
        if("220".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 9");
            return;
        }
        if("221".equalsIgnoreCase(pedido.getCliente())){
            spinner.setText("Mesa 10");
            return;
        }
        
    }


}
