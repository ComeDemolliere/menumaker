package sample.view;

public class Fridge extends View {
    private final String XML_FILE = "ressources/Fridge.fxml";

    private final String LABEL = "FRIDGE";

    private final int WIDTH = 1920;

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

    private final int HEIGHT = 1080;
}
