package countryfacts.engine;

import countryfacts.connection.RestClient;
import countryfacts.domain.*;

import com.google.gson.Gson;

public class CurrencyMembers {
   private String currname = "";
   private int currsize = 0;
   private String memberlist = "";
   private String endpoint = "currency/";

   public CurrencyMembers(String search_curr) {
      
      String json_input = "";
      currname = search_curr;
      
      try {
         json_input = RestClient.resourceLookup(endpoint, search_curr);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
      try {
         RestCountry[] countrylist = new Gson().fromJson(json_input, RestCountry[].class);
         currsize = countrylist.length;

         for (int i = 0; i < currsize; i++) {
            memberlist += countrylist[i].getName();
            if (i < currsize - 1) {
               memberlist += ", ";
            }
         }
      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
   public String getCurrency() {
      return this.currname;  
   }
   
   public int getSize() {
      return this.currsize;
   }
   
   public String getMembers() {
      return this.memberlist;
   }

}