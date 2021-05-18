package countryfacts.connection;

import countryfacts.engine.SharedCurrency;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SharedCurrencyHandler implements HttpHandler {    
   
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
      
      String request_string = requestParamValue.split("/")[2];
      String request_curr1 = request_string.split("\\?")[0];
      String request_curr2 = request_string.split("\\?")[1];
      System.out.println("request_curr1:"+request_curr1);
      System.out.println("request_curr2:"+request_curr2);       
      String answer = "Response Not Found";

      try {
         SharedCurrency target = new SharedCurrency(request_curr1, request_curr2);
         answer = String.valueOf(target.getMembers()); 
  
         httpExchange.sendResponseHeaders(200, answer.length());

         outputStream.write(answer.getBytes());
         outputStream.flush();
         outputStream.close();

      } catch (Exception ex) {
          ex.printStackTrace();
      }
   
   }
}
