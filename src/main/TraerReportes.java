package main;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Conexion;
import modelo.Reportes;

public class TraerReportes {

    public static ArrayList<Reportes> idReportes() {

        Conexion conexion = new Conexion();
        ResultSet reportes;
        ArrayList<Reportes> respuesta = new ArrayList<>();
        Reportes reporte;
        try {
            reportes = conexion.listarRegistros();
            while (reportes.next()) {
                reporte = new Reportes();
                reporte.setId(reportes.getString("id_reporte"));
                reporte.setFechas(reportes.getString("fechas"));
                reporte.setDias(reportes.getString("dias"));
                reporte.setHoras(reportes.getString("horas"));
                respuesta.add(reporte);
            }
        } catch (Exception e) {
            EscribirLog.ejecutarLog("Error", "Exception: " + e);
        }
        return respuesta;
    }
}
