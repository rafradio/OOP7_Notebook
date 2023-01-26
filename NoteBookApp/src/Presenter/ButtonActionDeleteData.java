package Presenter;

import javax.swing.*;
import Model.ModelData;
import View.CreatForm2;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;

public class ButtonActionDeleteData<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonActionDeleteData(T view, String str, ModelData model) {
        super(view, str, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < this.view.txtAllFields.length; i++) {
            data.add(this.view.txtAllFields[i].getText());

        } 
        System.out.println(data.size());

        try {
            this.model.deleteDataInMySQL(data);
            this.model.pullFromMySQL();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        ((CreatForm2) this.view).insertDataIntoForm(0);

        this.updateFilter();
        
    }

    public void updateFilter() {
        String[] idList1 = new String[this.model.dataShell.size()];
        for (int i = 0; i < this.model.dataShell.size(); i++) {
            idList1[i] = (String) this.model.dataShell.get(i).get("FIO");
        }
        ((CreatForm2) this.view).filter.setModel(new DefaultComboBoxModel(idList1));
    }
}
