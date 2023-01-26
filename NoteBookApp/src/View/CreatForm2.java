package View;

import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.border.*;

import Model.ModelData;
import Presenter.ButtonAction;
import Presenter.ButtonActionCloseForm;
import Presenter.ButtonActionDeleteData;
import Presenter.ButtonActionSaveData;
import Presenter.FilterAction;

import java.awt.*;  
import java.awt.event.*;
import java.util.ArrayList;  

public class CreatForm2 extends CreatFormClass {
    // private JTextField[] txtAllAverages;
    // private int testCount = 2;
    public ModelData model;
    // public JComboBox filter;

    public CreatForm2(String[] nameOfFields, String[] nameOfButtons, int[] initFormSettings, ModelData model) {
        super(nameOfFields, nameOfButtons, initFormSettings);
        this.model = model;
    }

    @Override
    public void createAverageGUI() {

        JPanel gui = new JPanel(new GridLayout(3,1,20,3));
        gui.setBorder(new TitledBorder("Контакты"));
        // gui.setSize(800, 300);
        gui.add(this.creatLabelsFields());
        gui.add(this.createButons());
        gui.add(this.filterPanel());

        JFrame averageFrame = new JFrame("Контактная книжка");
        averageFrame.setContentPane(gui);
        averageFrame.setSize(this.initFormSettings[0], this.initFormSettings[1]);
        averageFrame.setLayout(new GridLayout(3,0));
        // averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        averageFrame.setVisible(true);
        this.myForm = averageFrame;
        this.txtAllFields[0].setEnabled(false);
        this.actionsForButtons();
        this.insertDataIntoForm(0);
    }

    @Override
    public void actionsForButtons() {
        ActionListener crtBut1 = new ButtonAction<CreatForm2>(this, "Hello world", this.model);
        this.allButtons[1].addActionListener(crtBut1);

        ActionListener crtBut0 = new ButtonActionSaveData<CreatForm2>(this, "Hello world", this.model);
        this.allButtons[0].addActionListener(crtBut0);

        ActionListener crtBut2 = new ButtonActionDeleteData<CreatForm2>(this, "Hello world", this.model);
        this.allButtons[2].addActionListener(crtBut2);

        ActionListener crtFilter = new FilterAction<CreatForm2>(this, "Hello world", this.model);
        this.filter.addActionListener(crtFilter);

    }

    public void insertDataIntoForm(int index) {
        for (int i = 0; i < this.txtAllFields.length; i++) {
            this.txtAllFields[i].setText((String) this.model.dataShell.get(index).get(this.model.nameOfColumns[i]));
        }
    }

    public JPanel filterPanel() {
        JPanel inputControls = new JPanel();
        JLabel txtField = new JLabel("Выберите ID");
        String[] idList1 = new String[this.model.dataShell.size()];
        for (int i = 0; i < this.model.dataShell.size(); i++) {
            idList1[i] = (String) this.model.dataShell.get(i).get("FIO");
        }
        JComboBox cb = new JComboBox(idList1);
        cb.setSize(20, 5);
        inputControls.add(txtField);
        inputControls.add(cb);
        this.filter = cb;
        inputControls.setBounds(0, 0, 20, 5);
        // inputControls.setSize(200, 20);
        inputControls.setLayout(new GridLayout(1,2));
        return inputControls;
    }

}
