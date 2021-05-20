# CountryFacts
- Find out various information about countries of the world from a JSON endpoint, present it in cleartext via a local endpoint.
- To run: java -jar countryfactsAPI.jar <port>
  - Example: java -jar countryfactsAPI.jar <5099>
  - This opens a mini server on port 5099.
  
  Available endpoints:
  - http://localhost:<port>/callingcode/<countryname>
    - returns the calling code of the country
  - http://localhost:<port>/capital/<capitalname>
    - returns the parent country of the capital city
  - http://localhost:<port>/regionalbloc/<blocname>
    - returns the number of members of the bloc
  - http://localhost:<port>/currency/<currencycode>
    - returns the number of countries that use the currency
  - http://localhost:<port>/sharedcurrency/<currencycode1>?<currencycode2>
    - returns any countries that use both currencies
  
  Examples:
  - http://localhost:5099/callingcode/germany
  - http://localhost:5099/capital/paris
  - http://localhost:5099/regionalbloc/caricom
  - http://localhost:5099/currency/USD
  - http://localhost:5099/sharedcurrency/USD?GBP
