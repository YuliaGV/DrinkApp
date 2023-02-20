import java.util.ArrayList;

public class Drink {

    private int id;
    private String name;
    private String category;
    private ArrayList<String> ingredients = new ArrayList<String>();
    private String instructions;
    private String urlPhoto;



    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
    //Setters


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }


    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }
}
