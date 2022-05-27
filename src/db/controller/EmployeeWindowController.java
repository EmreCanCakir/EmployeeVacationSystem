package db.controller;

import db.model.Vacation;
import db.model.X;
import db.view.ViewFactory;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class EmployeeWindowController extends BaseController implements Initializable {

    public EmployeeWindowController(X x, ViewFactory viewFactory, String fxmlName) {
        super(x, viewFactory, fxmlName);
    }

    @FXML
    public TableColumn<Vacation, Boolean> _col_is_approved;

    @FXML
    public TableColumn<Vacation, String > col_description;

    @FXML
    public TableColumn<Vacation, Date> col_finish_date;

    @FXML
    public TableColumn<Vacation, String> col_type;

    @FXML
    public TableColumn<Vacation, Date> col_start_date;

    @FXML
    public TableView<Vacation> tableView;

    ArrayList<Vacation> vacations = new ArrayList<>();
    @FXML
    void vacationAddInEmployeePageButton(ActionEvent event) throws SQLException {
        String isApproved = null;
        viewFactory.showVacationAdd();
        for (int i =0; i<tableView.getItems().size();i++){
            tableView.getItems().clear();
        }
        Stage stage =(Stage) tableView.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Vacation> vacations = new ArrayList<>();
        try {
            vacations = x.selectVacationsByEmployeeId(LoginWindowController.employee.eid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Vacation> vacationObservableList = FXCollections.observableList(vacations);
        col_start_date.setCellValueFactory(cellData-> cellData.getValue().startDate);
        col_finish_date.setCellValueFactory(cellData-> cellData.getValue().finishDate);
        _col_is_approved.setCellValueFactory(cellData->cellData.getValue().isApproved);
        col_description.setCellValueFactory(cellData->cellData.getValue().description);
        col_type.setCellValueFactory(cellData->cellData.getValue().type);
        tableView.setItems(vacationObservableList);
    }
}
