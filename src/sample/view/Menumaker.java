package sample.view;

public class Menumaker extends View {
    private final String XML_FILE = "ressources/fxml/MenuMaker.fxml";

    private final String CSS_FILE = "sample/css/stylesheet.css";

    private final String LABEL = "MENUMAKER";

    private final int WIDTH = 1280;

    private final int HEIGHT = 720;

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

    public String getCSS_FILE(){
        return CSS_FILE;
    }

}
