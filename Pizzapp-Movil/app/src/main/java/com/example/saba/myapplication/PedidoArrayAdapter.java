package com.example.saba.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


public class PedidoArrayAdapter extends BaseArrayAdapter<LineaDePedido> {

    public PedidoArrayAdapter(@NonNull Context context, List elements, int selected) {
        super(context, R.layout.adapter_array_pedido, elements);

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        ItemInstanceControlHolder itemInstanceControlHolder;

        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.adapter_array_pedido, null);


            itemInstanceControlHolder = new ItemInstanceControlHolder();
            itemInstanceControlHolder.numeroTextView = convertView.findViewById(R.id.numero);
            itemInstanceControlHolder.nombreTextView = convertView.findViewById(R.id.nombre);
            itemInstanceControlHolder.cantidadTextView = convertView.findViewById(R.id.cantidad);
            itemInstanceControlHolder.precioTextView = convertView.findViewById(R.id.precio);



            convertView.setTag(itemInstanceControlHolder);
        }
        else
            itemInstanceControlHolder = (ItemInstanceControlHolder) convertView.getTag();

        LineaDePedido linea = elements.get(position);

        itemInstanceControlHolder.numeroTextView.setText("" + (position +1));
        itemInstanceControlHolder.nombreTextView.setText("" + linea.getNombreProd());
        itemInstanceControlHolder.cantidadTextView.setText("" + linea.getCantidad());
        itemInstanceControlHolder.precioTextView.setText("" + linea.getPrecio());


        return convertView;
    }



    private static class ItemInstanceControlHolder
    {
        public TextView numeroTextView;
        public TextView nombreTextView;
        public TextView cantidadTextView;
        public TextView precioTextView;
    }

}
