package Presenter;

import javax.swing.*;
import Model.ModelData;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;
import View.CreatForm2;

public class ButtonActionSaveData<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonActionSaveData(T view, String str, ModelData model) {
        super(view, str, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 1; i < this.view.txtAllFields.length; i++) {
            data.add(this.view.txtAllFields[i].getText());

        } 
        System.out.println(data.size());
        try {
            this.model.insertDataInMySQL(data);
            this.model.pullFromMySQL();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        ((CreatForm2) this.view).insertDataIntoForm(this.model.dataShell.size() - 1);
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
