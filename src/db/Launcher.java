package db;

import db.controller.SignUpController;
import db.model.X;
import db.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        X x = new X();
        ViewFactory viewFactory = new ViewFactory(new X());
        viewFactory.showLoginWindow();
    }
}
