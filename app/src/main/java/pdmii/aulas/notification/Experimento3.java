package pdmii.aulas.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

/**
 * Esta classe demonstra como usar Notification na tela de bloqueio.
 * Utilize um dispositivo com Android 5.+ .
 * @author vagner
 */
public class Experimento3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento3);
    }

    public void gerarNotificação(View v) {

        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                //obtém o gerenciador de Notificações
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                //cria uma IntentPendente. Neste caso, a Intent é abrir outra Activity
                PendingIntent p = PendingIntent.getActivity(Experimento3.this, 0, new Intent(Experimento3.this, Atividade2.class), 0);

                //Constrói as características da Notificação
                NotificationCompat.Builder buider = new NotificationCompat.Builder(Experimento3.this); //cria um buider de Notificações
                buider.setDefaults(Notification.DEFAULT_ALL); // Ativa configurações padrão
                //buider.setTicker("Ticker texto");
                buider.setContentTitle(getResources().getText(R.string.titulo_notificacao));
                //buider.setContentText("Descrição 1.");
                buider.setSmallIcon(R.drawable.ic_sim_card_alert_black_18dp);
                buider.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sim_card_alert_black_48dp));
                buider.setContentIntent(p); //indica qual é a intenção da Notificação (ao clicar na Notificação esta intenção é envia ao SO)
                buider.setAutoCancel(true); // Auto cancela a notificação ao clicar nela
                //aqui a personalização da heads-up (Android 5.+)
                // No Android 5.+
                buider.setColor(Color.BLUE);
                // Heads-up notification
                buider.setFullScreenIntent(p,false);
                // Privada se estiver na tela de bloqueio
                buider.setVisibility(NotificationCompat.VISIBILITY_PRIVATE);

                //instrução para inserir a notification na tela de bloqueio
                buider.setVisibility(NotificationCompat.VISIBILITY_PRIVATE);


                //utilizando o InboxStyle para inserir mais de uma descrição
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                String[] descs = new String[]{"Descrição 1.", "Descrição 2.", "Descrição 3."};
                for(int i=0; i < descs.length; i++){
                    inboxStyle.addLine(descs[i]);
                }
                buider.setStyle(inboxStyle);

                //constrói a instância da notificação
                Notification n = buider.build(); //cria a instância
                n.vibrate = new long[]{150,300,150,600}; //manda vibrar com 150ms de pausa, 300ms de vibação, 150ms de pausa, e 600ms de vibração
                n.flags = Notification.FLAG_AUTO_CANCEL; //indica que a Notificação será autocancelada ao clicá-la

                //manda notificar
                nm.notify(R.drawable.ic_sim_card_alert_white_18dp, n);

                //obtém o Uri do RingTone (do tipo Notificações) e faz ele tocar
                Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); //obtém o Uri padrão do toque de notificações
                Ringtone toque = RingtoneManager.getRingtone(Experimento3.this,som); //obtém a instância do RingTone
                toque.play(); //manda tocar
                Log.d("Experimento4", "Uri = " + som);
            }
        }, 3000);

    }
}
