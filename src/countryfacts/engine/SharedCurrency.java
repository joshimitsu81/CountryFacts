package countryfacts.engine;

import countryfacts.connection.RestClient;
import countryfacts.domain.*;

import java.util.ArrayList;

import com.google.gson.Gson;

public class SharedCurrency {
   private String curr1 = "";
   private String curr2 = "";
   private String memberlist = "";
   private String endpoint = "currency/";

   public SharedCurrency (String search_curr1, String search_curr2) {
      
      String json_input = "";
      curr1 = search_curr1;
      curr2 = search_curr2;
      
      try {
         json_input = RestClient.resourceLookup(endpoint, search_curr1);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
      try {
         RestCountry[] countrylist = new Gson().fromJson(json_input, RestCountry[].class);
         int currsize = countrylist.length;

         for (int i = 0; i < currsize; i++) {
            ArrayList<RestCurrency> currency_list = countrylist[i].getCurrencies();
            for (int j = 0; j < currency_list.size(); j++) {
               String thiscurr = currency_list.get(j).getCode();
               if (thiscurr != null && thiscurr.equals(search_curr2)) {
                  memberlist += countrylist[i].getName();
                  
                  if (i < currsize - 1) {
                     memberlist += ", ";
                  }
               }
            
            }
                        
         }
      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
   public String getCurrency1() {
      return this.curr1;  
   }
   
   public String getCurrency2() {
      return this.curr2;  
   }
   
   public String getMembers() {
      return this.memberlist;
   }

}