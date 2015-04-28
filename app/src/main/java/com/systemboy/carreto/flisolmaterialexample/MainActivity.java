package com.systemboy.carreto.flisolmaterialexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    //Objeto de la clase toolbar para modificar las propiedades de nuestro actionbar
    Toolbar toolbar;
    RecyclerView listaTarjetas;
    InformacionCiudad uno,dos,tres,cuatro;
    List<InformacionCiudad> lista;

    //Floaoting actionButton
    FloatingActionButton compartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compartir= (FloatingActionButton)findViewById(R.id.btnShare);
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);


        //CardView
        listaTarjetas= (RecyclerView)findViewById(R.id.cardList);
        listaTarjetas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaTarjetas.setLayoutManager(llm);

        //Generamos nuestros datos para las Tarjetas

        uno= new InformacionCiudad();
        uno.setPais("Francia");
        uno.setCiudad("Paris");
        uno.setContinente("Europa");
        uno.setDescripcion("Lorem Ipsum");

        dos= new InformacionCiudad();
        dos.setPais("Alemania");
        dos.setCiudad("Berlin");
        dos.setContinente("Europa");
        dos.setDescripcion("Lorem Ipsum Blah blah blah");

        tres= new InformacionCiudad();
        tres.setPais("New York");
        tres.setCiudad("Estados Unidos de América");
        tres.setContinente("América");
        tres.setDescripcion("Lorem Ipsum mas Blah blah blah");

        cuatro= new InformacionCiudad();
        cuatro.setPais("Japón");
        cuatro.setCiudad("Tokyo");
        cuatro.setContinente("Asia");
        cuatro.setDescripcion("Lorem Ipsum Pokemon,blahblahmanga, blahanime, pan blah blah");

        lista= new ArrayList<>();
        lista.add(uno);
        lista.add(dos);
        lista.add(tres);
        lista.add(cuatro);
        lista.add(uno);
        lista.add(dos);
        lista.add(tres);
        lista.add(cuatro);

        //mandamos nuestra informacion a las tarjetas con nuestro adapter
        CardAdapter mAdapter = new CardAdapter(lista);
        listaTarjetas.setAdapter(mAdapter);

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Compartir",Toast.LENGTH_SHORT).show();
                Intent cambiar= new Intent(getBaseContext(),MainActivity2Activity.class);
                startActivity(cambiar);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
