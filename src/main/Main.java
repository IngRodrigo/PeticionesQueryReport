package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rodrigo_dev
 */
public class Main {

    public static ServerSocket SERVER_SOCKET;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SERVER_SOCKET = new ServerSocket(1234);
            System.out.println("Es la primera instancia de la aplicación...");

            Timer timer = new Timer();
            TimerTask procesarPorMinuto = new TimerTask() {
                @Override
                public void run() {
                    try {
                        EscribirLog.ejecutarLog("OK: ", "Iniciando procesos " + new Date());
                        EscribirLog.ejecutarLog("**", "*********************");
                        Calendar calendario = Calendar.getInstance();
                        ProcesoCompararFechas.compararFechasParaEnviar(calendario);
                        EscribirLog.ejecutarLog("OK: ", "Procesos finalizados - " + new Date());
                    } catch (Exception e) {
                        EscribirLog.ejecutarLog("ERROR: ", "Excption: " + e);
                    }
                }
            };
            //timer.schedule(tareaEnviarCorreos,0, 1800000);//cada media hora
            //timer.schedule(tareaEnviarCorreos,0, 600000);//cada dies min 
            timer.schedule(procesarPorMinuto, 0, 300000);//cada 5 minuto
        } catch (IOException e) {
            System.out.println("Otra instancia de la aplicación se está ejecutando...");
        }
    }

}
