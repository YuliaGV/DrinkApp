import javax.swing.*;


public class Main {


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new DrinksUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        DrinksDAO drinksDAO = new DrinksDAOImp();
        System.out.println(drinksDAO.getDrink().toString());



    }


}


/*
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

                for (int i = 0; i < arr.size(); i++) {
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    System.out.println("Total Recovered: " + new_obj.get("strDrink"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
 */