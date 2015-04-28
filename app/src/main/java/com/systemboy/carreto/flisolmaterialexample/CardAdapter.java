package com.systemboy.carreto.flisolmaterialexample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Daniel on 24/04/2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ContactViewHolder> {
    List<InformacionCiudad> infoCity;
    //Constructor de nuestra clase que recibe la lista de objetos
    public CardAdapter(List<InformacionCiudad> infoCity){
        this.infoCity=infoCity;
    }
    //Inflamos la vista de nuestra tarjeta
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View tarjeta= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);
        return new ContactViewHolder(tarjeta);
    }



    //Llenamos las tarjetas de informacion
    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        final InformacionCiudad ci = infoCity.get(i);
        contactViewHolder.vCiudad.setText(ci.getCiudad());
        contactViewHolder.vContinente.setText(ci.getContinente());
        contactViewHolder.vDescripcion.setText(ci.getDescripcion());
        contactViewHolder.vPais.setText(ci.getPais());

        contactViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"tarjetas:"+ci.getPais()+ci.getCiudad(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Regresa el total de elementos de una lista
     */
    @Override
    public int getItemCount() {
        return infoCity.size();
    }

    /**
     * por medio del View Holder optimizamos la creacion del contenido de la tarjeta
     */
    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        protected TextView vCiudad;
        protected TextView vContinente;
        protected TextView vDescripcion;
        protected TextView vPais;
        protected CardView card;
        public ContactViewHolder(View v) {
            super(v);
            vCiudad =  (TextView) v.findViewById(R.id.txtCiudad);
            vContinente = (TextView)  v.findViewById(R.id.txtContinente);
            vDescripcion = (TextView)  v.findViewById(R.id.txtDescripcion);
            vPais = (TextView) v.findViewById(R.id.pais);
            card= (CardView) v.findViewById(R.id.card);
        }
    }
}
