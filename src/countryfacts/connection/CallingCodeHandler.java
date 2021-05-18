package countryfacts.connection;

import countryfacts.engine.CountryCallingCode;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CallingCodeHandler implements HttpHandler {    
   
   @Override    
   public void handle(HttpExchange httpExchange) throws IOException {
   
      String requestParamValue=null; 
      if("GET".equals(httpExchange.getRequestMethod())) { 
         requestParamValue = handleGetRequest(httpExchange);
         }else if("POST".equals(httpExchange)) { 
            requestParamValue = handlePostRequest(httpExchange);        
         }  
      
      handleResponse(httpExchange,requestParamValue); 
   }
  
   private String handlePostRequest(HttpExchange httpExchange) {
      return httpExchange
         .getRequestURI()
         .toString();
   } 
   
   private String handleGetRequest(HttpExchange httpExchange) {
      return httpExchange
         .getRequestURI()
         .toString();
   }
   
   private void handleResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
      OutputStream outputStream = httpExchange.getResponseBody();
      
      String request_country = requestParamValue.split("/")[2];
      System.out.println("urlparam:"+request_country);       
      String answer = "Response Not Found";

      try {
         CountryCallingCode target = new CountryCallingCode(request_country);
         answer = String.valueOf(target.getCode());
   
         httpExchange.sendResponseHeaders(200, answer.length());

         outputStream.write(answer.getBytes());
         outputStream.flush();
         outputStream.close();

      } catch (Exception ex) {
          ex.printStackTrace();
      }

   }
}
