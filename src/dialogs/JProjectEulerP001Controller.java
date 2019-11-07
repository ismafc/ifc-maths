/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import Library.ChangeEditListener;
import Library.InOut;
import ProjectEuler.P001_009.Problem001;
import ProjectEuler.P001_009.Problem001Thread;
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
    
    Problem001Thread p001thread = null;
    Timeline refreshTimer = new Timeline();
        
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
    
    private void setCalculatingMode(boolean calculating) {
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

        if (!calculating)
            updateButtons();
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
        
        EventHandler<ActionEvent> onTimer = new EventHandler<>() {
            public void handle(ActionEvent t) {
                if (p001thread != null) {
                    if (!p001thread.getState().equals(Thread.State.NEW) && 
                        !p001thread.getState().equals(Thread.State.TERMINATED)) {
                        calculationProgressBar.setProgress(p001thread.getProgress());
                    }
                    else if (p001thread.getState().equals(Thread.State.TERMINATED)) {
                        refreshTimer.stop();
                        setCalculatingMode(false);
                        Color c = p001thread.getProgress() < 1.0 ? COLOR_ERROR : COLOR_OK;
                        resultLabel.setTextFill(c);
                    }
                    String result = p001thread.getResult().toString();
                    String duration = InOut.getDurationText(p001thread.getMilliseconds(), bundle);
                    resultLabel.setText(result + " (" + duration + ")");
                }
            }
        };
        refreshTimer.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyframe = new KeyFrame(Duration.millis(REFRESH_TIME_MS), onTimer);
        refreshTimer.getKeyFrames().add(keyframe);
        resultLabel.setTextFill(COLOR_OK);
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
            p001thread = new Problem001Thread();
            p001thread.set(values, from, below, algorithm);
            p001thread.start();
            refreshTimer.play();
            calculationProgressBar.setProgress(0.0);
            resultLabel.setTextFill(COLOR_CALCULATING);
            resultLabel.setText(bundle.getString("lbl.result"));
            setCalculatingMode(true);

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
    
    @FXML
    public void onCancel(ActionEvent event) {
        if (p001thread != null)
            p001thread.doStop();
    }
}
