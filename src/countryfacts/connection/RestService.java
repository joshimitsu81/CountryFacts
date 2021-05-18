package countryfacts.connection;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class RestService {

   private String calling_code_context = "/callingcode";
   private String capital_city_context = "/capital";
   private String bloc_members_context = "/regionalbloc";
   private String currency_members_context = "/currency";
   private String shared_currency_context = "/sharedcurrency";
   ///int port = 5050;

   public RestService(int port) throws Exception {
    
      HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
      server.createContext(calling_code_context, new CallingCodeHandler());
      server.createContext(capital_city_context, new CapitalHandler());
      server.createContext(bloc_members_context, new CountryBlocHandler());
      server.createContext(currency_members_context, new CurrencyHandler());
      server.createContext(shared_currency_context, new SharedCurrencyHandler());
      server.setExecutor(null); 
      server.start();   
   }
   
}
