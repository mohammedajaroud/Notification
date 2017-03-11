package pdmii.aulas.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Classe acessória do exemplo de Notificações.
 * @author vagner
 */
public class Atividade2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);

        //mapeia os botões e trata o evento onClick
        findViewById(R.id.bt_cancelarNotificacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //obtém o gerenciador de Notificações
                nm.cancel(1); //manda cancelar a Notificação a partir do id dela
            }
        });

        findViewById(R.id.bt_cancelarTodas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); //obtém o gerenciador de Notificações
                nm.cancelAll(); //cancela todas as notificações da app
            }
        });
    }

}//fim de classe