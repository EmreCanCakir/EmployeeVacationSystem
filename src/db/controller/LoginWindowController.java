package db.controller;

import db.model.Account;
import db.model.Employee;
import db.model.Validation;
import db.model.X;
import db.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginWindowController extends BaseController{

    @FXML
    public TextField emailField;

    @FXML
    public Label errorLabel;

    @FXML
    public PasswordField passwordField;

    public LoginWindowController(X x, ViewFactory viewFactory, String fxmlName) {
        super(x,viewFactory, fxmlName );
    }
    static Account account;
    static Employee employee;

    @FXML
    void loginWindowAction() throws SQLException {
        Validation validation = new Validation();
        String email = emailField.getText();
        String password = passwordField.getText();
        if(validation.validateEmailAndPassword(email,password).result && validation.validateEmailAndPassword(email,password).result1){
            viewFactory.showRedirectAminController();
            Stage stage =(Stage) errorLabel.getScene().getWindow();
            viewFactory.closeStage(stage);
            account = x.selectAccountUsingEmail(email);
            employee = x.selectEmployeeUsingEmployeeId(account.employeeId);
            System.out.println("admin page is opening");
        }else if(validation.validateEmailAndPassword(email,password).result && !validation.validateEmailAndPassword(email,password).result1){
            viewFactory.showVacationAdd();
            Stage stage =(Stage) errorLabel.getScene().getWindow();
            viewFactory.closeStage(stage);
            account = x.selectAccountUsingEmail(email);
            employee = x.selectEmployeeUsingEmployeeId(account.employeeId);
            System.out.println(employee.firstName);
            System.out.println("kullanici sayfasi");
        }else {
            errorLabel.setText("Email or Password is wrong, Please try again");
        }
    }
    @FXML
    void signupWindowAction() {
        viewFactory.showSignUpWindow();
    }
}