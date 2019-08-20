/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import ProjectEuler.P001_009.Problem001;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

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
    public void onAddToList(ActionEvent event) {
        BigInteger add = new BigInteger(addEdit.getText());
/*        for (BigInteger bi : multiplesList.getItems()) {
            if (add.mod(bi).compareTo(BigInteger.ZERO) == 0) {
                JOptionPane.showMessageDialog(null, "El valor es múltiple de " + bi.toString() + ", que ya se encuentra en la lista", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }*/
        multiplesList.getItems().add(add);
    }

    @FXML
    public void onRemoveFromList(ActionEvent event) {
        ObservableList<BigInteger> items = multiplesList.getItems();
        items.removeAll(multiplesList.getSelectionModel().getSelectedItems());
    }
    
    @FXML
    public void onCalculate(ActionEvent event) {
        Problem001 problem001 = new Problem001();
        BigInteger from = new BigInteger(fromEdit.getText());
        BigInteger below = new BigInteger(toEdit.getText());
        Object selectedItem = algorithmComboBox.getSelectionModel().getSelectedItem();
        Problem001.Algorithm algorithm = (Problem001.Algorithm)selectedItem;
        ArrayList<BigInteger> values = new ArrayList<>();
        values.addAll(multiplesList.getItems());
        BigInteger result = problem001.solve(values, from, below, algorithm);
        resultLabel.setText(result.toString());
    }
    
}
