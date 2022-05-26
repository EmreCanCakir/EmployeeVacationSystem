package db.view;

import db.controller.*;
import db.model.X;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ViewFactory {
    private X x;

    public ViewFactory(X x) {
        this.x = x;
    }

    public void showLoginWindow() throws SQLException {
        BaseController controller = new LoginWindowController(x,this,"loginWindow.fxml");
        initializeStage(controller);
    }
    public void showSignUpWindow(){
        BaseController controller = new SignUpController(x,this,"signUp.fxml");
        initializeStage(controller);
        ((SignUpController) controller).genderChoiceBox.getItems().add("F");
        ((SignUpController) controller).genderChoiceBox.getItems().add("M");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Marketing");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Operation");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Finance");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Sales");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Human Resources");
        ((SignUpController) controller).departmentChoiceBox.getItems().add("Secretary");

    }
    public void showVacationAdd(){
        BaseController controller = new VacationAddController(x,this,"vacationAdd.fxml");
        initializeStage(controller);
        ((VacationAddController) controller).typeChoiceBox.getItems().add("Pregnant Vacation");
        ((VacationAddController) controller).typeChoiceBox.getItems().add("Yearly Vacation");
        ((VacationAddController) controller).typeChoiceBox.getItems().add("Emergency Vacation");
        ((VacationAddController) controller).typeChoiceBox.getItems().add("Maternity Vacation");
        ((VacationAddController) controller).typeChoiceBox.getItems().add("Another");
    }
    public void showRedirectAminController(){
        BaseController controller = new RedirectAdminController(x,this,"redirectAdmin.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void closeStage(Stage stage) {
        stage.close();
    }

}
