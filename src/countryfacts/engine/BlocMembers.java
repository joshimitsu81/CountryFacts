package countryfacts.engine;

import countryfacts.connection.RestClient;
import countryfacts.domain.*;

import com.google.gson.Gson;

public class BlocMembers {
   private String blocname = "";
   private int blocsize = 0;
   private String memberlist = "";
   private String endpoint = "regionalbloc/";

   public BlocMembers(String search_bloc) {
      
      String json_input = "";
      blocname = search_bloc;
      
      try {
         json_input = RestClient.resourceLookup(endpoint, search_bloc);
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   
      try {
         RestCountry[] countrylist = new Gson().fromJson(json_input, RestCountry[].class);
         blocsize = countrylist.length;

         for (int i = 0; i < blocsize; i++) {
            memberlist += countrylist[i].getName();
            if (i < blocsize - 1) {
               memberlist += ", ";
            }
         }
      
      } catch (Exception e) {
         e.printStackTrace();
      }
      
   }
   
   public String getBloc() {
      return this.blocname;  
   }
   
   public int getSize() {
      return this.blocsize;
   }
   
   public String getMembers() {
      return this.memberlist;
   }

}