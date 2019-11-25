/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import Library.ChangeEditListener;
import Library.InOut;
import ProjectEuler.P001_009.Problem001;
import ProjectEuler.P001_009.Problem001Parallel;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
    @FXML private Label numbersLabel;
    @FXML private Label resultLabel;
    @FXML private Button calculateButton;
    @FXML private Button addToListButton;
    @FXML private Button removeFromListButton;
    @FXML private Button cancelButton;
    @FXML private ProgressBar calculationProgressBar; 

    ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
    String error = bundle.getString("base.error");
    String warning = bundle.getString("base.warning");
    
    private final int FIRST_VALUES = 3;
    private final int LAST_VALUES = 3;
    private final int REFRESH_TIME_MS = 500;
    private final Color COLOR_OK = Color.GREEN;
    private final Color COLOR_CALCULATING = Color.BLUE;
    private final Color COLOR_ERROR = Color.RED;
    
    Problem001Parallel p001parallel = null;
    Timeline refreshTimer = new Timeline();

    /**
     * Local Listener needed because, in addition to check length and type of string,
     * interface updating is needed in order to enable or disable controls every
     * time a control changes.
     */
    public class ChangeEditListenerLocal extends ChangeEditListener {

        /** 
         * Listener constructor
         * @param nMaxLength Maximum string length
         * @param nNaturalNumber Boolean indicanting if string must be a natural number or not
         */
        public ChangeEditListenerLocal(int nMaxLength, boolean nNaturalNumber) {
            super(nMaxLength, nNaturalNumber);
        }

        /** 
         * Method called every time the string wants to be changed
         * This method checks if <b><i>newValue</i></b> fits restrictions of
         * length (<b><i>naturalNumber</i></b>) and type (<b><i>maxLength</i></b>)
         * and finally updates interface in order to enable or disable controls
         * @param observable Wrapping of value being observing (checked/monitoring)
         * @param oldValue Old value for string
         * @param newValue New value for string that has to be checked
         */
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            super.changed(observable, oldValue, newValue);
            updateButtons();
        }
    }
    
    /**
     * Local handler needed for timer. 
     * Used to update interface during calculations.
     * @param <ActionEvent> Event launched by timer through KeyFrame
     */
    public class TimerHandler<ActionEvent> implements EventHandler {
        /**
         * Method called while calculation is in progress so here we
         * actualize interface (progress bar and result label)
         * @param t Event received
         */
        @Override
        public void handle(Event t) {
            if (p001parallel != null) {
                if (p001parallel.calculationInProgress())
                    calculationProgressBar.setProgress(p001parallel.getProgress());
                else if (p001parallel.calculationIsDone()) {
                    refreshTimer.stop();
                    updateVisibility();
                    updateButtons();
                    Color c = p001parallel.getProgress() < 1.0 ? COLOR_ERROR : COLOR_OK;
                    resultLabel.setTextFill(c);
                }
                // Update resultLabel with actual calculated value and time
                String result = p001parallel.getResult().toString();
                String duration = InOut.getDurationText(p001parallel.getMilliseconds(), bundle);
                resultLabel.setText(result + " (" + duration + ")");
            }
        }
    };
    
    /**
     * This method updates the state of all buttons depending on values 
     * found in controls (basically if they are empty or not)
     */
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
     * This method updates the visibility of controls
     * depending on state of calculation.
     */
    private void updateVisibility() {
        boolean calculating = p001parallel.calculationInProgress();
        calculationProgressBar.setVisible(calculating);
        cancelButton.setVisible(calculating);
        calculateButton.setDisable(calculating);
        removeFromListButton.setDisable(calculating);
        addToListButton.setDisable(calculating);
        multiplesList.setDisable(calculating);
        fromEdit.setDisable(calculating);
        toEdit.setDisable(calculating);
        addEdit.setDisable(calculating);
        algorithmComboBox.setDisable(calculating);
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        multiplesList.getItems().add(new BigInteger("3"));
        multiplesList.getItems().add(new BigInteger("5"));
        multiplesList.getSelectionModel().select(new BigInteger("3"));
        multiplesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        fromEdit.textProperty().addListener(new ChangeEditListenerLocal(15, true));
        toEdit.textProperty().addListener(new ChangeEditListenerLocal(20, true));
        addEdit.textProperty().addListener(new ChangeEditListenerLocal(10, true));
        
        Problem001.Algorithm[] algorithms = Problem001.Algorithm.values();
        int last = algorithms.length - 1;
        algorithmComboBox.getItems().addAll(Arrays.asList(algorithms));
        algorithmComboBox.getSelectionModel().select(algorithms[last]);
        
        InputStream stream = getClass().getResourceAsStream("/resources/stop.png");
        cancelButton.setGraphic(new ImageView(new Image(stream)));
        
        refreshTimer.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyframe = new KeyFrame(Duration.millis(REFRESH_TIME_MS), new TimerHandler<>());
        refreshTimer.getKeyFrames().add(keyframe);
        resultLabel.setTextFill(COLOR_OK);
    }    

    /**
     * Remove all selected items from list
     */
    private void removeSelectedItemsFromMultiplesList() {
        ObservableList<BigInteger> items = multiplesList.getItems();
        items.removeAll(multiplesList.getSelectionModel().getSelectedItems());        
    }
    
    /**
     * Function called when <b><i>addToListButton</i></b> is clicked and, so,
     * we want to add a number to list of multiples of. 
     * @param event Event received
     */
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
                Alert alert = new Alert(Alert.AlertType.ERROR, msg);
                alert.setHeaderText(error);
                alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR, msg);
            alert.setHeaderText(error);
            alert.showAndWait();
            return;
        }
        if (multiples.size() > 0) {
            String divideto = bundle.getString("p001.divideto");
            String addanyway = bundle.getString("p001.addanyway");
            String msg = value + " " + add + " " + divideto + " " + multiples.toString() + " " + pinlistp + ". " + addanyway;
            Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(warning);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.NO)
                return;
            // If we decide to add this value, its multiples in list can be removed
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

    /**
     * Function called when <b><i>removeFromListButton</i></b> is clicked and, so,
     * we want to remove numbers from list of multiples of. 
     * @param event Event received
     */
    @FXML
    public void onRemoveFromList(ActionEvent event) {
        removeSelectedItemsFromMultiplesList();
        updateButtons();
    }

    /**
     * Build a string with the numbers in list <b><i>first</i></b> separated by
     * <b>'+'</b> followed by <b>' + ... + '</b> and the numbers 
     * in list <b><i>last</i></b> separated by <b>'+'</b>. If both list overlaps,
     * text <b>' + ... + '</b> is not needed. <b><i>value</i></b> is next value to
     * <b><i>first</i></b> list and is used to check if both lists overlaps.
     * @param first List of first numbers to show separated by <b>'+'</b>
     * @param last List of lasts numbers to show separated by <b>'+'</b>
     * @param value Next value to first list, used to check if both lists overlaps
     * @return String with desired result (sum of numbers)
     */
    private String getNumbersText(ArrayList<BigInteger> first, ArrayList<BigInteger> last, BigInteger value) {
        String txt = "";
        if (first.isEmpty())
            txt = bundle.getString("lbl.novaluestoadd");
        else {
            boolean overlapped = (value == null || last.contains(value));
            InOut<BigInteger> io = new InOut<>();
            if (overlapped) {
                for (BigInteger i : last) {
                    if (!first.contains(i)) {
                        first.add(i);
                    }
                }
                txt += io.getListText(first, " + ");
            }
            else {
                txt += io.getListText(first, " + ");
                txt += " + ... + ";
                txt += io.getListText(last, " + ");
            }
        }
        return txt;
    }
    
    /**
     * Function called when <b><i>calculateButton</i></b> is clicked and, so,
     * we want to begin calculation.
     * @param event Event received
     */
    @FXML
    public void onCalculate(ActionEvent event) {
        BigInteger from = new BigInteger(fromEdit.getText());
        BigInteger below = new BigInteger(toEdit.getText());
        if (from.compareTo(below) == -1) {
            Object selectedItem = algorithmComboBox.getSelectionModel().getSelectedItem();
            Problem001.Algorithm algorithm = (Problem001.Algorithm)selectedItem;
            ArrayList<BigInteger> values = new ArrayList<>();
            values.addAll(multiplesList.getItems());

            // Launch calculation and timer to refresh progress bar
            p001parallel = new Problem001Parallel();
            p001parallel.set(values, from, below, algorithm);
            p001parallel.start();
            refreshTimer.play();
            calculationProgressBar.setProgress(0.0);
            resultLabel.setTextFill(COLOR_CALCULATING);
            resultLabel.setText(bundle.getString("lbl.result"));
            updateVisibility();

            // Actualize numbersLabel with list of first and last added values
            Problem001 problem001 = new Problem001();
            ArrayList<BigInteger> f = problem001.getFirstValues(values, from, below, FIRST_VALUES);
            ArrayList<BigInteger> l = problem001.getLastValues(values, from, below, LAST_VALUES);
            BigInteger v = problem001.getValue(values, from, below, FIRST_VALUES + 1);
            numbersLabel.setText(getNumbersText(f, l, v));
        }
        else {
            String msg = bundle.getString("p001.fromlessthanto");
            Alert alert = new Alert(Alert.AlertType.ERROR, msg);
            alert.setHeaderText(error);
            alert.showAndWait();
            resultLabel.setText(bundle.getString("lbl.result"));
            numbersLabel.setText(bundle.getString("lbl.valuestoadd"));
            resultLabel.setTextFill(COLOR_OK);
        }
    }
    
    /**
     * Function called when <b><i>cancelButton</i></b> is clicked and, so,
     * we want to cancel the current calculation in progress.
     * @param event Event received
     */
    @FXML
    public void onCancel(ActionEvent event) {
        if (p001parallel != null)
            p001parallel.doStop();
    }
}
