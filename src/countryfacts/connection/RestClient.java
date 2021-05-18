package countryfacts.connection;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URL;

public class RestClient {
      
   public static String resourceLookup (String endpoint, String label) {
      String baseURL = "https://restcountries.eu/rest/v2/";
      String remoteaddr = baseURL + endpoint + label;
      String json_result = "";      
      
      try {     
         URL url= new URL(remoteaddr);
         URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            
         var client = HttpClient.newHttpClient();
         var httpRequest = HttpRequest.newBuilder()
            .uri(uri)
            .GET()
            .build();
            
         var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
         json_result = response.body();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return json_result;  
   }
   
}