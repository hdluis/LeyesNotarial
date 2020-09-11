package umg.leyesnotarial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button inicioLeyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioLeyes=(Button) findViewById(R.id.btnInicio);
        inicioLeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent inicioLeyes = new Intent(MainActivity.this, ActividadLeyes.class);
               startActivity(inicioLeyes);
            }
        });
    }
}
