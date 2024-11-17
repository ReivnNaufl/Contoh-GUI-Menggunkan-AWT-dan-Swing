package com.example.guipesanan;

public class MainApplication{
    public static void main(String[] args) {
        // Initialize the view
        PesananView view = new PesananView();

        // Initialize the controller and connect it to the view
        PesananController controller = new PesananController(view);

        // Display the UI
        view.show();
    }
}