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
 *
 * @author ismael.flores
 */
public class ChangeEditListener implements ChangeListener<String> {

    private int maxLength = 10;
    private boolean naturalNumber = false;
   
    public ChangeEditListener(int nMaxLength, boolean nNaturalNumber) {
        maxLength = nMaxLength;
        naturalNumber = nNaturalNumber;
    }

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
