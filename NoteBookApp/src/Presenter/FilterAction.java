package Presenter;

import javax.swing.*;
import Model.ModelData;
import View.CreatForm2;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;

public class FilterAction<T extends CreatFormClass> extends ActionClass<T> {

    public FilterAction(T obj, String str, ModelData model) {
        super(obj, str, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String txt = (String) this.view.filter.getSelectedItem();
        System.out.println(txt);
        int index = ((DefaultComboBoxModel<String>) this.view.filter.getModel()).getIndexOf(txt);
        System.out.println(index);
        ((CreatForm2) this.view).insertDataIntoForm(index);
        
    }
}
