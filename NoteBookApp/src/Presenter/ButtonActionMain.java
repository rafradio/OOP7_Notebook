package Presenter;

import javax.swing.*;

import Model.ModelData;
import View.CreatForm1;
import View.CreatForm2;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;

public class ButtonActionMain<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonActionMain(T view, String str, ModelData model) {
        super(view, str, model);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] nameOfFields = new String[] {"ID", "ФИО", "Телефон", "email", "Адрес"};
        String[] nameOfButtons = new String[] {"Записать данные", "Новый контакт", "Удалить контакт"};
        int[] initFormSettings = new int[] {400, 400, 2, 2};

        CreatFormClass obj1 = new CreatForm2(nameOfFields, nameOfButtons, initFormSettings, this.model);
        obj1.createAverageGUI();


    }
}
