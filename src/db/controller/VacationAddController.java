package db.controller;

import db.model.Account;
import db.model.Employee;
import db.model.X;
import db.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.Date;

public class VacationAddController extends BaseController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private DatePicker finishDateDatePicker;

    @FXML
    private Label infoLabel;

    @FXML
    private DatePicker startDateDatePicker;

    @FXML
    public ChoiceBox<String> typeChoiceBox;

    public VacationAddController(X x, ViewFactory viewFactory, String fxmlName) {
        super(x, viewFactory, fxmlName);
    }

    @FXML
    void createVacation()throws SQLException {
        X x = new X();
        Account account;
        Employee employee;
        Date startDate = java.sql.Date.valueOf(startDateDatePicker.getValue());
        Date finishDate = java.sql.Date.valueOf(finishDateDatePicker.getValue());
        if(isNullValues(startDate,finishDate)){
            x.insertVacationAdd(startDate,finishDate,typeChoiceBox.getValue(), LoginWindowController.account.employeeId,LoginWindowController.employee.departmentId, descriptionTextArea.getText());
            System.out.println("Vacation is added. ");
        }else {
            System.out.println("Vacation is NOT added !!!");
        }
    }

    private boolean isNullValues(Date startDate, Date finishDate){
        if(!startDate.toString().isEmpty() && !finishDate.toString().isEmpty()){
            return true;
        }
        return false;
    }

}