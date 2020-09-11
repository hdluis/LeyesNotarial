package umg.leyesnotarial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ActividadLeyes extends AppCompatActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_leyes);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.txtsearch);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
            String selection = adapterView.getItemAtPosition(position).toString();

                if (selection == "Acuerdo de Arancel Registro Mercantil")
                {
                    Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                    intent.putExtra("url","file:///android_asset/AcuerdoArancelRegistroMercantil.html");
                    startActivity(intent);
                    finish();
                }
                if (selection == "Acuerdo Gubernativo No. 325-2005")
                {
                    Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                    intent.putExtra("url","file:///android_asset/AcuerdoGubernativo-325-2005.html");
                    startActivity(intent);
                    finish();
                }
                if (selection == "Arancel Registro General de Propiedad")
                {
                    Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                    intent.putExtra("url","file:///android_asset/ArancelRegistroGeneraldePropiedad.html");
                    startActivity(intent);
                    finish();
                }
                if (selection == "Caracteristicas de Hoja Papel Sellado")
                {
                    Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                    intent.putExtra("url","file:///android_asset/CaracteristicasHojaPapelSellado.html");
                    startActivity(intent);
                    finish();
                }
                if (selection == "Celebracion de Matrimonios en el Extranjero")
                {
                    Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                    intent.putExtra("url","file:///android_asset/CelebracionMatrimoniosExtranjero.html");
                    startActivity(intent);
                    finish();
                }
                /*switch (position) {
                    case 0:
                        Intent intent = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                        intent.putExtra("url","file:///android_asset/LeyFondoTierras24-99.html");
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Intent b = new Intent(ActividadLeyes.this, LeyFondoTierra.class);
                        b.putExtra("url","file:///android_asset/ReglamentoAplicacionPreceptos.html");
                        startActivity(b);
                        finish();
                        break;
                }*/
            }
            });

        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                s.toString().length();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    //Retes List
                    initList();
                } else {
                    //Search
                    searchItem(s.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                /*if (s.toString().length() < length) {
                    initList();
                    for (String item:items) {
                        if (!item.toLowerCase().contains(s.toString().toLowerCase())) {
                            listItems.remove(item);
                        }}}*/
            }
        });
    }

    ;

    public void searchItem(String textToSearch) {
        for (String item : items) {
            if (!item.toLowerCase().contains(textToSearch.toString().toLowerCase())) {
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }


    public void initList() {
        items = new String[]{
                "Acuerdo de Arancel Registro Mercantil",
                "Acuerdo Gubernativo No. 325-2005",
                "Arancel Registro General de Propiedad",
                "Caracteristicas de Hoja Papel Sellado",
                "Celebracion de Matrimonios en el Extranjero",
                "Ley Fondo Tierras24-99",
                "Reglamento Aplicacion Preceptos",
        };

        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
    }
}
