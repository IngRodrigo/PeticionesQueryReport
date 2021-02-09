/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
import modelo.Reportes;

/**
 *
 * @author rodrigo_dev
 */
public class ProcesoCompararFechas {

    public static void compararFechasParaEnviar() {
        Calendar calendario = Calendar.getInstance();
        ArrayList<Reportes> respuesta = TraerReportes.idReportes();
        String[] fechasIndividual = null;
        String[] horasIndividual = null;
        String dia_del_mes = String.format("%02d", calendario.get(Calendar.DAY_OF_MONTH));

        String hora = String.format("%02d", calendario.get(Calendar.HOUR_OF_DAY));
        String minuto = String.format("%02d", calendario.get(Calendar.MINUTE));
        // System.out.println("hora = " + hora);
        // System.out.println("minuto = " + minuto);
        String hora_actual = hora + ":" + minuto;
        for (int i = 0; i < respuesta.size(); i++) {
            fechasIndividual = respuesta.get(i).getFechas().split(";");
            horasIndividual = respuesta.get(i).getHoras().split(";");
            //String[] diaNombre = respuesta.get(i).getDias().split(";");
            System.out.println("Reporte con el id: " + respuesta.get(i).getId());
            EscribirLog.ejecutarLog("OK: ", "Reporte con el id: " + respuesta.get(i).getId());
            for (String fecha : fechasIndividual) {

                System.out.println("dia_del_mes = " + dia_del_mes);
                System.out.println("fecha = " + fecha);
                EscribirLog.ejecutarLog("OK: ", "Dia actual: " + dia_del_mes);
                EscribirLog.ejecutarLog("OK: ", "Dia enistema: " + fecha);
                if (String.valueOf(dia_del_mes).equals(fecha) || fecha.equals("0")) {

                    for (String horaIndividual : horasIndividual) {
                        System.out.println("horaActual: " + hora_actual);
                        System.out.println("horaIndividual: " + horaIndividual);
                        if (hora_actual.equals(horaIndividual)) {
                            Peticiones.ejecutarPeticionPostCreateRegistro(respuesta.get(i).getId());
                            EscribirLog.ejecutarLog("OK: ", "Se envio el correo al id del reporte: "+respuesta.get(i).getId());
                        }
                    }
                } else {
                    EscribirLog.ejecutarLog("OK: ", "No se cumplen las condiciones para enviar correo");
                }
            }
            System.out.println("-----------------------------------------------");
        }
    }
}
