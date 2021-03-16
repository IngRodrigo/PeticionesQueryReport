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
            File directorio = new File("Log");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            String data = "Resultado: " + tipo + " Detalle: " + mensaje + "\n";
            File file = new File(directorio,"log_" + EscribirLog.fechaActual() + ".txt");

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

    public static String diaDeSemana(int dia) {
        String dia_de_la_semana = "";
        switch (dia) {
            case 1:
                dia_de_la_semana = "Domingo";
                break;
            case 2:
                dia_de_la_semana = "Lunes";
                break;
            case 3:
                dia_de_la_semana = "Martes";
                break;
            case 4:
                dia_de_la_semana = "Miercoles";
                break;
            case 5:
                dia_de_la_semana = "Jueves";
                break;
            case 6:
                dia_de_la_semana = "Viernes";
                break;
            case 7:
                dia_de_la_semana = "Sabado";
                break;
        }

        return dia_de_la_semana;
    }
}
