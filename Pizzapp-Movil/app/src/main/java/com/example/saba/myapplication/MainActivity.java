package com.example.saba.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list = null;
    List<Product> arrayProduct = null;

    Pedido pedido = null;
    BootstrapButton bottonPedido = null;
    BootstrapButton bottonCancelar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey("pedido"))
            pedido = (Pedido) bundle.get("pedido");

        if(pedido == null){
            pedido = new Pedido();
        }


        list = findViewById(R.id.listComponent);
        bottonPedido = findViewById(R.id.irALista);
        bottonCancelar = findViewById(R.id.cancelarPedido);
        arrayProduct = new ArrayList<>();
        getListProduct();

        bottonPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSecondStep();
            }
        });

        bottonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).
                        setTitle("Cancelar pedido").setMessage("¿Seguro desea 'Cancelar' el pedido?");

                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        cancelPedido();
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

    }

    private void cancelPedido() {
        pedido = new Pedido();

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("El pedido fue cancelado")
                .setTitle("Aviso");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void getListProduct() {


        String ipconfig = getString(R.string.ipConfig);
        String url =  "http://"+ ipconfig +"/PizzApp/rest/productoService/todosLosProductos";

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                (JSONObject) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try {
                            // Loop through the array elements
                            for (int i = 0; i < response.length(); i++) {
                                // Get current json object
                                JSONObject productjJson = response.getJSONObject(i);
                                Product product = new Gson().fromJson(productjJson.toString(), Product.class);

                                arrayProduct.add(product);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        List<String> arrayStringProducts = new ArrayList<>();
                        for(Product p : arrayProduct){
                            arrayStringProducts.add(p.getNombre());
                        }
                        String[] stringArray = arrayStringProducts.toArray(new String[0]);

                        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                stringArray);
                        list.setAdapter(adapter);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Product product = arrayProduct.get(position);
                                agregarProductoAPedido(product);
                            }
                        });
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        e.printStackTrace();
                        Log.d("ERIC", e.toString());

                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void agregarProductoAPedido(Product product) {
        Boolean esNuevo= true;
        for(LineaDePedido lp : pedido.getLinea()){
            if(lp.getIdProd() == product.getId() ){
                lp.setCantidad(lp.getCantidad() + 1);
                lp.setPrecio(lp.getPrecio() + product.getPrecio());
                esNuevo = false;
            }
        }
        if(esNuevo){
            LineaDePedido lpNew = new LineaDePedido();
            lpNew.setIdProd(product.getId());
            lpNew.setCantidad(1);
            lpNew.setNombreProd(product.getNombre());
            lpNew.setPrecio(product.getPrecio());
            pedido.getLinea().add(lpNew);
        }

    }

    private void toSecondStep() {

        Intent intent = new Intent(MainActivity.this, PedidoActivity.class);
        intent.putExtra("pedido", pedido);

        startActivity(intent);
    }



}
