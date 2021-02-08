/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rodrigo_dev
 */
public class Reportes {
    String id, fechas, dias, horas;

    public Reportes() {
    }

    public Reportes(String id, String fechas, String dias, String horas) {
        this.id = id;
        this.fechas = fechas;
        this.dias = dias;
        this.horas = horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Reportes{" + "id=" + id + ", fechas=" + fechas + ", dias=" + dias + ", horas=" + horas + '}';
    }
    
}
