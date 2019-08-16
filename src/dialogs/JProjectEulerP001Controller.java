/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import ProjectEuler.P001_009.Problem001;
import java.math.BigInteger;
import java.util.Arrays;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ismael.flores
 */
public class JProjectEulerP001Controller {

    @FXML private ListView<BigInteger> multiplesList;
    @FXML private TextField fromEdit;
    @FXML private TextField toEdit;
    @FXML private TextField addEdit;
    @FXML private ComboBox algorithmComboBox;
    @FXML private Label resultLabel;
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        multiplesList.getItems().add(new BigInteger("3"));
        multiplesList.getItems().add(new BigInteger("5"));
        multiplesList.getSelectionModel().select(new BigInteger("3"));

        fromEdit.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                fromEdit.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        toEdit.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                toEdit.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        addEdit.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                addEdit.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        Problem001.Algorithm[] algorithms = Problem001.Algorithm.values();
        int last = algorithms.length - 1;
        algorithmComboBox.getItems().addAll(Arrays.asList(algorithms));
        algorithmComboBox.getSelectionModel().select(algorithms[last]);        
    }    
    
    @FXML
    public void onCalculateAction(ActionEvent event) {
        
    }
    
}
