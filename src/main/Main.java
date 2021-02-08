package main;

/**
 *
 * @author rodrigo_dev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EscribirLog.ejecutarLog("OK: ", "Iniciando procesos");
            EscribirLog.ejecutarLog("**", "*********************");
            ProcesoCompararFechas.compararFechasParaEnviar();
            EscribirLog.ejecutarLog("OK: ", "Procesos finalizados");
        } catch (Exception e) {
            EscribirLog.ejecutarLog("ERROR: ", "Excption: "+e);
        }
    }
    
}
