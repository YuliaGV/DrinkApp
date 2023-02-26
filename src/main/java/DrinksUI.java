import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinksUI {

    JPanel panelDrink;
    private JButton showRecipe;
    private JLabel name;
    private JLabel category;
    private JPanel panelData;
    private JList ingredients;
    private JTextArea instructions;
    private JPanel recipePhoto;


    public DrinksUI() {
        showRecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinksDAO drinksDAO = new DrinksDAOImp();
                Drink randomDrink  =  drinksDAO.getDrink();

                name.setText(randomDrink.getName());
                category.setText(randomDrink.getCategory());

                //Create object DefaultListModel
                DefaultListModel listModel = new DefaultListModel();

                //Recorrer el contenido del ArrayList
                for(int i=0; i<randomDrink.getIngredients().size(); i++) {
                    //Añadir cada elemento del ArrayList en el modelo de la lista
                    listModel.add(i,randomDrink.getIngredients().get(i));
                }
                //Asociar el modelo de lista al JList
                ingredients.setModel(listModel);

                instructions.setText(randomDrink.getInstructions().replaceAll("\\. ", "\n"));


                /*Image photo = drinksDAO.getPhoto(randomDrink.getUrlPhoto());
                JLabel picLabel = new JLabel(new ImageIcon(photo));
                recipePhoto.add(picLabel);*/





            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
