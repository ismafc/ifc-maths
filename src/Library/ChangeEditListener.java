/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * @author ismael.flores
 *
 * Listener that matches string in order to assure that:<br><br>
 * 
 * <b>1.-</b> Is a natural number or not (<b><i>naturalNumber</i></b> is true or false)<br>
 * <b>2.-</b> The String length is less or equal than <b><i>maxLength</i></b><br>
 * 
 */
public class ChangeEditListener implements ChangeListener<String> {

    private int maxLength = 10;
    private boolean naturalNumber = false;
   
    /** 
     * Listener constructor
     * @param nMaxLength Maximum string length
     * @param nNaturalNumber Boolean indicanting if string must be a natural number or not
     */
    public ChangeEditListener(int nMaxLength, boolean nNaturalNumber) {
        maxLength = nMaxLength;
        naturalNumber = nNaturalNumber;
    }

    /** 
     * Method called every time the string wants to be changed
     * This method checks if <b><i>newValue</i></b> fits restrictions of
     * length (<b><i>naturalNumber</i></b>) and type (<b><i>maxLength</i></b>)
     * @param observable Wrapping of value being observing (checked/monitoring)
     * @param oldValue Old value for string
     * @param newValue New value for string that has to be checked
     */
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        StringProperty textProperty = (StringProperty) observable;
        TextField textField = (TextField)textProperty.getBean();
        if (naturalNumber && !newValue.matches("\\d*"))
            textField.setText(newValue.replaceAll("[^\\d]", ""));
        if (newValue.length() > maxLength)
            textField.setText(newValue.substring(0, maxLength));
    }

}
