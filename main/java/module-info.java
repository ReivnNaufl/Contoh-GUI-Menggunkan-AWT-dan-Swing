module com.example.guipesanan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.guipesanan to javafx.fxml;
    exports com.example.guipesanan;
}