package countryfacts.engine;

import countryfacts.connection.RestClient;
import countryfacts.domain.*;

import java.util.ArrayList;

import com.google.gson.Gson;

public class CountryCallingCode {
   private String countryname = "";
   private String countrycode = "";
   private String endpoint = "name/";
   
   public CountryCallingCode(String search_country) {
      
      String json_input = "";
   
      try {
         json_input = RestClient.resourceLookup(endpoint, search_country);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
      try {
         RestCountry[] countrylist = new Gson().fromJson(json_input, RestCountry[].class);
         RestCountry rc = countrylist[0];
         countryname = rc.getName();
         ArrayList<String> country_codes_list = rc.getCallingCodes();
         for (int i = 0; i < country_codes_list.size(); i++) {
            countrycode += country_codes_list.get(i);
            if (i < country_codes_list.size() - 1) {
               countrycode += ", ";
            }
         }
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public String getName() {
      return this.countryname;
   }
   
   public String getCode() {
      return this.countrycode;
   }
   
}