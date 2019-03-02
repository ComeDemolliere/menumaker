package sample.view;

public class DishView extends View {
    private final String XML_FILE = "ressources/fxml/DishWithIngredients.fxml";

    private final String LABEL = "DISH";

    private final int WIDTH = 1280;

    public String getXML_FILE() {
        return XML_FILE;
    }

    public String getLABEL() {
        return LABEL;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    private final int HEIGHT = 720;
}

