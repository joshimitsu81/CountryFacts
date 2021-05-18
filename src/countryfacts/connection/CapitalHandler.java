package countryfacts.connection;

import countryfacts.engine.CapitalCountry;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CapitalHandler implements HttpHandler {    
   
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
      
      String request_city = requestParamValue.split("/")[2];
      System.out.println("urlparam:"+request_city);       
      String answer = "Response Not Found";

         try {
            CapitalCountry target = new CapitalCountry(request_city);
            answer = target.getName(); 
     
            httpExchange.sendResponseHeaders(200, answer.length());
   
            outputStream.write(answer.getBytes());
            outputStream.flush();
            outputStream.close();
   
         } catch (Exception ex) {
             ex.printStackTrace();
         }
   
      }
   }
