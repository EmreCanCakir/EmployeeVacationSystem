package db.controller;

import db.model.X;
import db.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RedirectAdminController extends BaseController{

    public RedirectAdminController(X x, ViewFactory viewFactory, String fxmlName) {
        super(x, viewFactory, fxmlName);
    }

    @FXML
    void adminPageRedirectButon(ActionEvent event) {

    }

    @FXML
    void userPageRedirectButon(ActionEvent event) throws SQLException {
        viewFactory.showEmployeeWindow();
    }

}
