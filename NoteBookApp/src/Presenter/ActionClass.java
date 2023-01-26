package Presenter;

import java.awt.*;  
import java.awt.event.*;
import Model.ModelData;
import View.CreatFormClass;

public class ActionClass <T extends CreatFormClass> implements ActionListener {
    public T view;
    public String str;
    public ModelData model;

    public ActionClass(T view, String str, ModelData model) {
        this.view = view;
        this.str = str;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
