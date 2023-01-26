package Presenter;

import javax.swing.*;

import Model.ModelData;
import View.CreatForm1;
import View.CreatForm2;
import View.CreatFormClass;

import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;  
import java.nio.file.*;
import java.util.*;
import java.io.FileWriter; 

public class ButtonActionMainSaveToFile<T extends CreatFormClass> extends ActionClass<T> {

    public ButtonActionMainSaveToFile(T view, String str, ModelData model) {
        super(view, str, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            this.model.pullFromMySQL();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        Path path = Paths.get("src/DataInFile/data.txt");
        try {  
                Path p = Files.createFile(path);   
        } catch (Exception e1) {}

        try {
            FileWriter myWriterCreate = new FileWriter("src/DataInFile/data.txt");
            for (int i = 0; i < this.model.dataShell.size(); i++) {
                for (Map.Entry<String, Object> map: this.model.dataShell.get(i).entrySet()) {
                    myWriterCreate.write((String) map.getValue() + ", ");
                }
                myWriterCreate.write("\n");
            }
            myWriterCreate.close();
        } catch (Exception e1) {}

        

    }
}
