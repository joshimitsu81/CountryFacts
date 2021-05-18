package countryfacts.domain;

import java.util.ArrayList;

public class RestCountry {
   
   private String name;
   private String capital;
   private ArrayList<String> callingCodes;
   private ArrayList<RestCurrency> currencies;
   
   RestCountry () {
   }
   
   public String getName() {
      return this.name;
   }
   
   public String getCapital() {
      return this.capital;
   }
   
   public ArrayList<String> getCallingCodes() {
      return this.callingCodes;
   }
   
   public ArrayList<RestCurrency> getCurrencies() {
      return this.currencies;
   }
}