/**
* Country Facts Finder
* @author Joshim Ahmed
*/

package countryfacts.engine;

import countryfacts.connection.RestService;

public class FactsEngine {

   public static void main(String[] args) throws Exception {
      
      /*
      String country = "spain";
      String capital = "paris";
      String bloc = "nafta";
      String currency1 = "GBP";
      String currency2 = "USD";
      CountryCallingCode codefinder = new CountryCallingCode(country);
      CapitalCountry countryfinder = new CapitalCountry(capital);
      BlocMembers blocfinder = new BlocMembers(bloc);
      CurrencyMembers currfinder = new CurrencyMembers(currency);
      SharedCurrency joint = new SharedCurrency(currency1, currency2);
      System.out.println(codefinder.getCode());
      System.out.println(countryfinder.getName());
      System.out.println(blocfinder.getSize());
      System.out.println(blocfinder.getMembers());   
      System.out.println(currfinder.getSize());
      System.out.println(currfinder.getMembers());
      System.out.println(joint.getMembers());   
      */
      int port = Integer.parseInt(args[0]);
      RestService rs = new RestService(port);
   
   }
   
   public FactsEngine() {
      
   }
}