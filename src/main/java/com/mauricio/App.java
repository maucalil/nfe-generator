package com.mauricio;

import com.mauricio.model.MainModel;
import com.mauricio.view.MainView;
import com.mauricio.controller.MainController;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainModel mainModel = new MainModel();

            MainView.initLaF();
            MainView mainView = new MainView();

            MainController mainController = new MainController(mainView, mainModel);

            mainView.setVisible(true);
        });
    }
}
