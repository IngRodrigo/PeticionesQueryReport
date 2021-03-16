/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author rodrigo_dev
 */
public class Peticiones {

    public static void enviarCorreo() {

    }

    public static boolean ejecutarPeticionPostCreateRegistro(String idReporte) {
        boolean respuesta=false;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "enviarCorreo=" + idReporte);
        Request request = new Request.Builder()
                .url("http://webapp2/reportes/ws/queryreport.php")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "PHPSESSID=l15lgenmjgoi76mnaq0438h173")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response = " + response.body().string());
            System.out.println("response = " + response.code());
            EscribirLog.ejecutarLog("OK", "Codigo de respuesta: " + response.code());
            EscribirLog.ejecutarLog("OK", "Response petición: " + response.body());
            respuesta=true;
        } catch (IOException e) {
            System.out.println("e = " + e);
            EscribirLog.ejecutarLog("ERROR: ", "PROBLEMAS AL INTENTAR HACER LA PETICION DE ENVIO: " + e);
            respuesta=false;
        }
        return respuesta;
    }
}
