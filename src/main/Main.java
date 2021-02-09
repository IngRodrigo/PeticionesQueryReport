package main;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rodrigo_dev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask procesarPorMinuto = new TimerTask() {
            @Override
            public void run() {
                try {
                    EscribirLog.ejecutarLog("OK: ", "Iniciando procesos "+new Date());
                    EscribirLog.ejecutarLog("**", "*********************");
                    ProcesoCompararFechas.compararFechasParaEnviar();
                    EscribirLog.ejecutarLog("OK: ", "Procesos finalizados - "+new Date());
                } catch (Exception e) {
                    EscribirLog.ejecutarLog("ERROR: ", "Excption: " + e);
                }
            }
        };
        //timer.schedule(tareaEnviarCorreos,0, 1800000);//cada media hora
        //timer.schedule(tareaEnviarCorreos,0, 600000);//cada dies min 
        timer.schedule(procesarPorMinuto,0, 300000);//cada 5 minuto
    }

}
