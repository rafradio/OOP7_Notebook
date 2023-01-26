package View;

import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;  
import java.awt.event.*;

public abstract class CreatFormClass implements InterfaceForForms {
    public String[] nameOfFields;
    public String[] nameOfButtons;
    public int[] initFormSettings;
    public JTextField[] txtAllFields;
    public JButton[] allButtons;
    public JComboBox filter;
    public JFrame myForm;

    public CreatFormClass(String[] nameOfFields, String[] nameOfButtons, int[] initFormSettings) {
        this.nameOfFields = nameOfFields;
        this.nameOfButtons = nameOfButtons;
        this.initFormSettings = initFormSettings;
    }

    public abstract void createAverageGUI();

    public abstract void actionsForButtons();

    public abstract JPanel filterPanel();

    public JPanel creatLabelsFields() {

        this.txtAllFields = new JTextField[this.nameOfFields.length];
        JPanel inputControls = new JPanel(new BorderLayout(5,5));
        // inputControls.setSize(800, 1200);
        JPanel inputControlsLabels = new JPanel(new GridLayout(this.nameOfFields.length, 1,3,3));
        JPanel inputControlsFields = new JPanel(new GridLayout(this.nameOfFields.length, 1,3,3));

        for (int i = 0; i < this.nameOfFields.length; i++) {
            JLabel txtField = new JLabel(this.nameOfFields[i]);
            inputControlsLabels.add(txtField);
            JTextField field = new JTextField(20);
            inputControlsFields.add(field);
            this.txtAllFields[i] = field;
        }

        inputControls.add(inputControlsLabels, BorderLayout.WEST);
        inputControls.add(inputControlsFields, BorderLayout.CENTER);

        return inputControls;

    }

    public JPanel createButons() {
        this.allButtons = new JButton[this.nameOfButtons.length];
        JPanel controls = new JPanel();
        for (int i = 0; i < this.nameOfButtons.length; i++) {
            JButton btn = new JButton(this.nameOfButtons[i]);
            controls.add(btn);
            this.allButtons[i] = btn;
        }

        controls.setLayout(new GridLayout(this.initFormSettings[2],this.initFormSettings[3],3,3));
        controls.setSize(30, 10);    
        controls.setVisible(true);
        return controls;
    }

    
}
