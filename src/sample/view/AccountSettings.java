package sample.view;

public class AccountSettings extends View {
    private final String XML_FILE = "ressources/fxml/AccountSettings.fxml";

    private final String LABEL = "SETTINGS";

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

    private final String CSS_FILE = "sample/css/stylesheet.css";

    public String getCSS_FILE(){
        return CSS_FILE;
    }
    private final int HEIGHT = 720;
}
