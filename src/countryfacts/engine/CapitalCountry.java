package countryfacts.engine;

import countryfacts.connection.RestClient;
import countryfacts.domain.*;

import com.google.gson.Gson;

public class CapitalCountry {
   private String countryname = "";
   private String capitalname = "";
   private String endpoint = "capital/";
   
   public CapitalCountry(String search_capital) {
   
      String json_input = "";
   
      try {
         json_input = RestClient.resourceLookup(endpoint, search_capital);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
      try {
         RestCountry[] countrylist = new Gson().fromJson(json_input, RestCountry[].class);
         RestCountry rc = countrylist[0];
         countryname = rc.getName();
         capitalname = rc.getCapital();
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
   }
   
   public String getName() {
      return this.countryname;
   }
   
   public String getCapital() {
      return this.capitalname;
   }

}
