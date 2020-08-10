/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Soporte
 */
public class ProyectoII {
    public static double deaths;
    public static double cured;
    public static double infected;
    public static double mortalidad;
    public static double recuperacion;

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        System.setProperty("javax.net.ssl.trustStore", "NUL");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        //Carga los datos de la API de COVID
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://covid19-api.org/api/status/CR")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(response.body().string());
                deaths = parseInt(json.get("deaths").toString());
                cured = parseInt(json.get("recovered").toString());
                infected = parseInt(json.get("cases").toString());
                mortalidad = (deaths / infected) * 100;
                recuperacion = (cured / infected) * 100;
            } catch (ParseException ex) {
                Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
        }


 //"https://ubicaciones.paginasweb.cr/Provincias.json"
    }

    public int GetInfectados(int dia, int mes) {

        //launch(args);
        System.setProperty("javax.net.ssl.trustStore", "NUL");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        //Carga los datos de la API de COVID
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://covid19-api.org/api/status/CR?date=2020-" + mes + "-" + dia)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(response.body().string());

                int infectedByDate = parseInt(json.get("cases").toString());
                return infectedByDate;

            } catch (ParseException ex) {
                Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
    
    public int GetActivos(int dia, int mes) {

        //launch(args);
        System.setProperty("javax.net.ssl.trustStore", "NUL");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        //Carga los datos de la API de COVID
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://covid19-api.org/api/status/CR?date=2020-" + mes + "-" + dia)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(response.body().string());

                int ActivByDate = parseInt(json.get("cases").toString()) - parseInt(json.get("recovered").toString());
                return ActivByDate;

            } catch (ParseException ex) {
                Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
    
    
   public int GetRecup(int dia, int mes) {

        //launch(args);
        System.setProperty("javax.net.ssl.trustStore", "NUL");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        //Carga los datos de la API de COVID
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://covid19-api.org/api/status/CR?date=2020-" + mes + "-" + dia)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(response.body().string());

                int RecoverByDate = parseInt(json.get("recovered").toString());
                return RecoverByDate;

            } catch (ParseException ex) {
                Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
   
   
     public void CargarProvincias(JComboBox caja) {
        
        System.setProperty("javax.net.ssl.trustStore", "NUL");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        //Carga los datos de la API de COVID
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://ubicaciones.paginasweb.cr/Provincias.json")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(response.body().string());
                
            } catch (ParseException ex) {
                Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProyectoII.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
    public void CargarCantones(int index, ComboBox caja) {
        
        
        } 
   
    
    public void CargarDistrito(int index) {
        
        }
   
}


