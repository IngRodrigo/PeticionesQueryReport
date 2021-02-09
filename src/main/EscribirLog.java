/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author rodrigo_dev
 */
public class EscribirLog {

    Calendar calendario = Calendar.getInstance();

    public static void ejecutarLog(String tipo, String mensaje) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = "Resultado: " + tipo + " Detalle: " + mensaje + "\n";
            File file = new File("log_" + EscribirLog.fechaActual() + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("información agregada!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String fechaActual() {
        String fecha = "";
        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        String hora = String.format("%02d", calendario.get(Calendar.HOUR_OF_DAY));
        String minuto = String.format("%02d", calendario.get(Calendar.MINUTE));
        String segundo = String.format("%02d", calendario.get(Calendar.SECOND));

        fecha = anio + "-" + mes + "-" + dia + "-" + hora + "-" + minuto;

        return fecha;
    }
}
