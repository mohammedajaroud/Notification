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
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Esta classe demonstra como utilizar as Notificações no Android.
 * @author vagner
 */
public class Experimento1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento1);
    }

    public void gerarNotificação(View v) {

        //obtém o gerenciador de Notificações
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //cria uma IntentPendente. Neste caso, a Intent é abrir outra Activity
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, Atividade2.class), 0);

        //Constrói as características da Notificação
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this); //cria um builder de Notificações
        builder.setTicker(getResources().getText(R.string.ticker_notificacao));
        builder.setContentTitle(getResources().getText(R.string.titulo_notificacao));
        //builder.setContentText("Descrição 1.");
        builder.setSmallIcon(R.drawable.ic_sim_card_alert_black_18dp);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sim_card_alert_black_18dp));
        builder.setContentIntent(p); //indica qual é a intenção da Notificação (ao clicar na Notificação esta intenção é envia ao SO)
        builder.setColor(Color.GREEN);
        builder.setAutoCancel(false);

        //utilizando o InboxStyle para inserir mais de uma descrição
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] descs = new String[]{"Descrição 1.", "Descrição 2.", "Descrição 3."};
        for(int i=0; i < descs.length; i++){
            inboxStyle.addLine(descs[i]);
        }
        builder.setStyle(inboxStyle);

        //constrói a instância da notificação
        Notification n = builder.build(); //cria a instância
        n.vibrate = new long[]{150,300,150,600}; //manda vibrar com 150ms de pausa, 300ms de vibação, 150ms de pausa, e 600ms de vibração

        //manda notificar
        nm.notify(1, n);

        //obtém o Uri do RingTone (do tipo Notificações) e faz ele tocar
        Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); //obtém o Uri padrão do toque de notificações
        Ringtone toque = RingtoneManager.getRingtone(this,som); //obtém a instância do RingTone
        toque.play(); //manda tocar
        Log.d("Experimento1", "Uri = " + som);
    }

}//fim da classe
