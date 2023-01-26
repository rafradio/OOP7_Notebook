package View;

import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.border.*;
import Model.ModelData;
import Presenter.ButtonActionMain;
import Presenter.ButtonActionMainSaveToFile;

import java.awt.*;  
import java.awt.event.*;  

public class CreatForm1 extends CreatFormClass {
    // private JTextField[] txtAllAverages;
    // private int testCount = 2;
    public ModelData model; 

    public CreatForm1(String[] nameOfFields, String[] nameOfButtons, int[] initFormSettings, ModelData model) {
        super(nameOfFields, nameOfButtons, initFormSettings);
        this.model = model;
    }

    @Override
    public void createAverageGUI() {

        JPanel gui = new JPanel(new GridLayout(2,1,20,3));
        gui.setBorder(new TitledBorder("Начало"));
        // gui.setSize(800, 300);

        gui.add(this.createButons());
        gui.add(this.creatLabelsFields());
        
        

        JFrame averageFrame = new JFrame("Первая форма");
        averageFrame.setContentPane(gui);
        averageFrame.setSize(this.initFormSettings[0], this.initFormSettings[1]);
        averageFrame.setLayout(new GridLayout(2,0));
        // averageFrame.pack();
        averageFrame.setLocationByPlatform(true);
        averageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        averageFrame.setVisible(true);

        this.actionsForButtons();
    }

    @Override
    public void actionsForButtons() {
        ActionListener crtBut1 = new ButtonActionMain<CreatForm1>(this, "Hello world", this.model);
        this.allButtons[0].addActionListener(crtBut1);

        ActionListener crtBut2 = new ButtonActionMainSaveToFile<CreatForm1>(this, "Hello world", this.model);
        this.allButtons[1].addActionListener(crtBut2);
    }

    @Override
    public JPanel filterPanel() {
        return null;
    }


}
