import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class DrinksDAOImp implements DrinksDAO{


    @Override
    public Drink getDrink() {


        Drink foundDrink = new Drink();

        try {

            URL url = new URL("https://www.thecocktaildb.com/api/json/v1/1/random.php");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //Get the required data using its key

                JSONArray arr = (JSONArray) data_obj.get("drinks");


                JSONObject new_obj = (JSONObject) arr.get(0);
                foundDrink.setId(Integer.parseInt(new_obj.get("idDrink").toString()));
                foundDrink.setName(new_obj.get("strDrink").toString());
                foundDrink.setCategory(new_obj.get("strCategory").toString());

                for(int i=0; i<20; i++){
                    if(new_obj.get("strMeasure"+i) != null && new_obj.get("strIngredient"+i) != null){
                        foundDrink.addIngredient(new_obj.get("strMeasure"+i).toString()+" "+new_obj.get("strIngredient"+i).toString());

                    }
                }

                foundDrink.setInstructions(new_obj.get("strInstructions").toString());
                foundDrink.setUrlPhoto(new_obj.get("strDrinkThumb").toString());


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundDrink;


    }
}
