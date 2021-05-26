package ttviewer.ui;
/*
The reason this class exist is because of a JavaFX bug
https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing
 */
public class NewMain {

    public static void main(String[] args) {
        App.main(args);
    }
}
