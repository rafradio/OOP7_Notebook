package Presenter;

import javax.swing.*;
import Model.ModelData;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;

public class ButtonAction<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonAction(T view, String str, ModelData model) {
        super(view, str, model);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.view.txtAllFields.length; i++) {
            this.view.txtAllFields[i].setText("");
        } 
    }
}
