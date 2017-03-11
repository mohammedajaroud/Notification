package pdmii.aulas.notification;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author vagner
 */
public class Main extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapeia e trata o evento onClick dos botões
        findViewById(R.id.bt_experimento1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Main.this, Experimento1.class));
            }
        });

        findViewById(R.id.bt_experimento2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Main.this, Experimento2.class));
            }
        });

        findViewById(R.id.bt_experimento3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Main.this, Experimento3.class));
            }
        });

        findViewById(R.id.bt_experimento4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Main.this, Experimento4.class));
            }
        });

        findViewById(R.id.bt_experimento5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Main.this, Experimento1.class));
            }
        });
    }
}
