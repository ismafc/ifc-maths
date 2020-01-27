/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import Library.ChangeEditListener;
import Library.InOut;
import ProjectEuler.P001_009.*;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application.Parameters;
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
    @FXML private TextField belowEdit;
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
    
    private ArrayList<BigInteger> values = new ArrayList<>(Arrays.asList(new BigInteger("3"), new BigInteger("5")));
    private BigInteger from = new BigInteger("1");
    private BigInteger below = new BigInteger("1000");
    Problem001.Algorithm algorithm = Problem001.Algorithm.SOLUTION1;
    
    Problem001Interface p001 = null;
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
            if (p001 != null) {
                if (p001.calculationInProgress())
                    calculationProgressBar.setProgress(p001.getProgress());
                else if (p001.calculationIsDone()) {
                    refreshTimer.stop();
                    updateVisibility();
                    updateButtons();
                    Color c = p001.getProgress() < 1.0 ? COLOR_ERROR : COLOR_OK;
                    resultLabel.setTextFill(c);
                }
                // Update resultLabel with actual calculated value and time
                String result = p001.getResult().toString();
                String duration = InOut.getDurationText(p001.getMilliseconds(), bundle);
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
        if (belowEdit.getText() == null || belowEdit.getText().isEmpty())
            calculateButton.setDisable(true);
        if (multiplesList.getItems().isEmpty())
            calculateButton.setDisable(true);
        
        if (multiplesList.getSelectionModel().getSelectedItems().isEmpty())
            removeFromListButton.setDisable(true);
        
        if (addEdit.getText() == null || addEdit.getText().isEmpty())
            addToListButton.setDisable(true);
    }

    // Read 'algorithm' parameter in command-line
    public static Problem001.Algorithm getAlgorithmParameter(Parameters p, Problem001.Algorithm defaultValue) {        
        Problem001.Algorithm algorithm = defaultValue;
        String algorithm_txt = InOut.getParameter(p, "algorithm", defaultValue.toString(), false);
        try {
            algorithm = Problem001.Algorithm.valueOf(algorithm_txt);
        }
        catch (Exception e) {
        }
        return algorithm;
    }
    
    // Read v1, v2, ... , vn parameters in command-line
    public static ArrayList<BigInteger> getValuesParameters(Parameters p) {        
        ArrayList<BigInteger> values = new ArrayList<>();
        long i = 1;
        BigInteger value = InOut.getParameter(p, "v" + i, (BigInteger)null);
        while (value != null) {
            values.add(value);
            i++;
            value = InOut.getParameter(p, "v" + i, (BigInteger)null);
        }
        if (values.isEmpty())
            values = new ArrayList<>(Arrays.asList(new BigInteger("3"), new BigInteger("5")));
        return values;
    }
    
    public static void calculate(Problem001Thread p001, ArrayList<BigInteger> values, BigInteger from, BigInteger below, Problem001.Algorithm algorithm) throws InterruptedException {
        p001.set(values, from, below, algorithm);
        p001.start();
        while (!p001.calculationIsDone()) {
            Thread.sleep(100);
        }
    }
    
    public static BigInteger calculateThread(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Problem001.Algorithm algorithm) throws InterruptedException {
        Problem001Thread p001t = new Problem001Thread();
        calculate(p001t, values, from, below, algorithm);
        return p001t.getResult();
    }

    public static long measureTimeThread(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Problem001.Algorithm algorithm) throws InterruptedException {
        Problem001Thread p001t = new Problem001Thread();
        calculate(p001t, values, from, below, algorithm);
        return p001t.getMilliseconds();
    }

    public static BigInteger calculateParallel(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Problem001.Algorithm algorithm, long nThreads) throws InterruptedException {
        Problem001Parallel p001p = new Problem001Parallel();
        p001p.setNumberOfThreads(nThreads);
        calculate(p001p, values, from, below, algorithm);
        return p001p.getResult();
    }

    public static long measureTimeParallel(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Problem001.Algorithm algorithm, long nThreads) throws InterruptedException {
        Problem001Parallel p001p = new Problem001Parallel();
        p001p.setNumberOfThreads(nThreads);
        calculate(p001p, values, from, below, algorithm);
        return p001p.getMilliseconds();
    }
    
    public static void statistics(long samples, ArrayList<BigInteger> values, BigInteger from, BigInteger below, String separator) throws InterruptedException {
        System.out.println("Class Problem001Thread...");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            System.out.println("Algorithm " + algorithm + ":");
            String cpu_time_by_thread = "";
            String real_time = "";
            for (long i = 1; i <= samples; i++) {
                long ms = System.currentTimeMillis();
                cpu_time_by_thread += measureTimeThread(values, from, below, algorithm);
                real_time += (System.currentTimeMillis() - ms);
                if (i < samples) {
                    cpu_time_by_thread += separator;
                    real_time += separator;
                }
            }
            System.out.println("CPU time by thread (ms): " + cpu_time_by_thread);
            System.out.println("Real time (ms): " + real_time);
        }
        
        System.out.println("Class Problem001Parallel:");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            System.out.println("Algorithm " + algorithm + ":");
            for (int nThreads = 1; nThreads <= Runtime.getRuntime().availableProcessors(); nThreads++) {
                System.out.println(nThreads + " threads:");
                String cpu_time_by_thread = "";
                String real_time = "";
                for (long i = 1; i <= samples; i++) {
                    long ms = System.currentTimeMillis();
                    cpu_time_by_thread += measureTimeParallel(values, from, below, algorithm, nThreads);
                    real_time += (System.currentTimeMillis() - ms);
                    if (i < samples) {
                        cpu_time_by_thread += separator;
                        real_time += separator;
                    }
                }
                System.out.println("CPU time by thread (ms): " + cpu_time_by_thread);
                System.out.println("Real time (ms): " + real_time);
            }
            System.out.println("");
        }        
    }
    
    /**
     * This method updates the visibility of controls
     * depending on state of calculation.
     */
    private void updateVisibility() {
        boolean calculating = p001.calculationInProgress();
        calculationProgressBar.setVisible(calculating);
        cancelButton.setVisible(calculating);
        calculateButton.setDisable(calculating);
        removeFromListButton.setDisable(calculating);
        addToListButton.setDisable(calculating);
        multiplesList.setDisable(calculating);
        fromEdit.setDisable(calculating);
        belowEdit.setDisable(calculating);
        addEdit.setDisable(calculating);
        algorithmComboBox.setDisable(calculating);
    }
    
    public void setValues(ArrayList<BigInteger> _values) {
        values = _values;
        initializeMultiplesList();
    }

    public void setFrom(BigInteger _from) {
        from = _from;
        fromEdit.setText(from.toString());
    }

    public void setBelow(BigInteger _below) {
        below = _below;
        belowEdit.setText(below.toString());
    }

    public void setAlgorithm(Problem001.Algorithm _algorithm) {
        algorithm = _algorithm;
        algorithmComboBox.getSelectionModel().select(algorithm);
    }
    
    private void initializeMultiplesList() {
        multiplesList.getItems().clear();
        for (BigInteger v : values)
            multiplesList.getItems().add(v);
        if (!values.isEmpty())
            multiplesList.getSelectionModel().select(multiplesList.getItems().get(0));
    }
   
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        initializeMultiplesList();
        multiplesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);        

        fromEdit.textProperty().addListener(new ChangeEditListenerLocal(15, true));
        fromEdit.setText(from.toString());
        belowEdit.textProperty().addListener(new ChangeEditListenerLocal(20, true));
        belowEdit.setText(below.toString());
        addEdit.textProperty().addListener(new ChangeEditListenerLocal(10, true));
        
        Problem001.Algorithm[] algorithms = Problem001.Algorithm.values();
        algorithmComboBox.getItems().addAll(Arrays.asList(algorithms));
        algorithmComboBox.getSelectionModel().select(algorithm);
        
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
        BigInteger below = new BigInteger(belowEdit.getText());
        if (from.compareTo(below) == -1) {
            Object selectedItem = algorithmComboBox.getSelectionModel().getSelectedItem();
            Problem001.Algorithm algorithm = (Problem001.Algorithm)selectedItem;
            ArrayList<BigInteger> values = new ArrayList<>();
            values.addAll(multiplesList.getItems());

            // Launch calculation and timer to refresh progress bar
            p001 = new Problem001Parallel();
            p001.set(values, from, below, algorithm);
            //((Problem001Parallel)p001).setNumberOfThreads(12);
            p001.start();
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
        if (p001 != null)
            p001.doStop();
    }
}
