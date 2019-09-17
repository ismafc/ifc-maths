/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import Library.ChangeEditListener;
import ProjectEuler.P001_009.Problem001;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    @FXML private Button calculateButton;
    @FXML private Button addToListButton;
    @FXML private Button removeFromListButton;

    ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
    String error = bundle.getString("base.error");
    String warning = bundle.getString("base.warning");
    
    public class ChangeEditListenerLocal extends ChangeEditListener {

        public ChangeEditListenerLocal(int nMaxLength, boolean nNaturalNumber) {
            super(nMaxLength, nNaturalNumber);
        }

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            super.changed(observable, oldValue, newValue);
            JProjectEulerP001Controller.this.updateButtons();
        }
    }
    
    public void updateButtons() {
        calculateButton.setDisable(false);
        addToListButton.setDisable(false);
        removeFromListButton.setDisable(false);
        
        if (fromEdit.getText() == null || fromEdit.getText().isEmpty())
            calculateButton.setDisable(true);
        if (toEdit.getText() == null || toEdit.getText().isEmpty())
            calculateButton.setDisable(true);
        if (multiplesList.getItems().isEmpty())
            calculateButton.setDisable(true);
        
        if (multiplesList.getSelectionModel().getSelectedItems().isEmpty())
            removeFromListButton.setDisable(true);
        
        if (addEdit.getText() == null || addEdit.getText().isEmpty())
            addToListButton.setDisable(true);
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        multiplesList.getItems().add(new BigInteger("3"));
        multiplesList.getItems().add(new BigInteger("5"));
        multiplesList.getSelectionModel().select(new BigInteger("3"));
        multiplesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        fromEdit.textProperty().addListener(new ChangeEditListenerLocal(10, true));
        toEdit.textProperty().addListener(new ChangeEditListenerLocal(15, true));
        addEdit.textProperty().addListener(new ChangeEditListenerLocal(5, true));
        
        Problem001.Algorithm[] algorithms = Problem001.Algorithm.values();
        int last = algorithms.length - 1;
        algorithmComboBox.getItems().addAll(Arrays.asList(algorithms));
        algorithmComboBox.getSelectionModel().select(algorithms[last]);        
    }    

    private void removeSelectedItemsFromMultiplesList() {
        ObservableList<BigInteger> items = multiplesList.getItems();
        items.removeAll(multiplesList.getSelectionModel().getSelectedItems());        
    }
    
    @FXML
    public void onAddToList(ActionEvent event) {
        String value = bundle.getString("p001.thevalue");
        String pinlistp = bundle.getString("p001.pinlistp");
        ArrayList<BigInteger> multiples = new ArrayList<>();
        ArrayList<BigInteger> divisores = new ArrayList<>();
        BigInteger add = new BigInteger(addEdit.getText());
        for (BigInteger bi : multiplesList.getItems()) {
            if (add.equals(bi)) {
                String alreadyinlist = bundle.getString("p001.alreadyinlist");
                String msg = value + " " + add + " " + alreadyinlist;
                JOptionPane.showMessageDialog(null, msg, error, JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (add.mod(bi).compareTo(BigInteger.ZERO) == 0)
                divisores.add(bi);
            else if (bi.mod(add).compareTo(BigInteger.ZERO) == 0)
                multiples.add(bi);
        }

        if (divisores.size() > 0) {
            String ismultipleof = bundle.getString("p001.ismultipleof");
            String msg = value + " " + add + " " + ismultipleof + " " + divisores.toString() + " " + pinlistp;
            JOptionPane.showMessageDialog(null, msg, error, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (multiples.size() > 0) {
            String divideto = bundle.getString("p001.divideto");
            String addanyway = bundle.getString("p001.addanyway");
            String msg = value + " " + add + " " + divideto + " " + multiples.toString() + " " + pinlistp + ". " + addanyway;
            if (JOptionPane.showConfirmDialog(null, msg, warning, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION)
                return;
            multiplesList.getSelectionModel().clearSelection();
            for (BigInteger m : multiples)
                multiplesList.getSelectionModel().select(m);
            removeSelectedItemsFromMultiplesList();
        }
        
        multiplesList.getSelectionModel().clearSelection();
        multiplesList.getItems().add(add);
        multiplesList.getSelectionModel().select(add);
        updateButtons();
    }

    @FXML
    public void onRemoveFromList(ActionEvent event) {
        removeSelectedItemsFromMultiplesList();
        updateButtons();
    }
    
    @FXML
    public void onCalculate(ActionEvent event) {
        BigInteger from = new BigInteger(fromEdit.getText());
        BigInteger below = new BigInteger(toEdit.getText());
        if (from.compareTo(below) < 1) {
            Problem001 problem001 = new Problem001();
            Object selectedItem = algorithmComboBox.getSelectionModel().getSelectedItem();
            Problem001.Algorithm algorithm = (Problem001.Algorithm)selectedItem;
            ArrayList<BigInteger> values = new ArrayList<>();
            values.addAll(multiplesList.getItems());
            BigInteger result = problem001.solve(values, from, below, algorithm);
            resultLabel.setText(result.toString());
        }
        else {
            String msg = bundle.getString("p001.fromlessthanto");
            JOptionPane.showMessageDialog(null, msg, error, JOptionPane.ERROR_MESSAGE);            
        }
    }
}
