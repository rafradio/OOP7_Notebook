package Presenter;

import javax.swing.*;
import Model.ModelData;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;

public class ButtonActionCloseForm<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonActionCloseForm(T view, String str, ModelData model) {
        super(view, str, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.myForm.dispose();
    }
}
