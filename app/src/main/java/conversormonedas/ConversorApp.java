import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException  {
        Conversor.eleccionUserMenu();
    }
    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
        // Cliente HTTP para hacer el GET
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .GET()
                .build();
        
        try {
            // Enviando solicitud y recibiendo respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            
            // Convirtiendo y leyendo el JSON
            JsonElement elemento = JsonParser.parseString(respuesta.body());
            JsonObject objectRoot = elemento.getAsJsonObject();
    
            //Accediendo a JsonObject
            double tasa = objectRoot.get("conversion_rate").getAsDouble();
            return tasa;
        } catch (Exception e) {
            // Capturo errores
            throw new IOException("Error en la API: Código " + e.getMessage());
        }
    }
}