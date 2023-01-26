import java.sql.*;

import Model.ModelData;
import View.CreatFormClass;
import View.CreatForm1;
import View.CreatForm2;

public class App {
    public static void main(String[] args) throws Exception {

        String[] initColumnsNames = new String[] {"id", "FIO", "Telephone", "Email", "Address"};
        ModelData model = new ModelData(initColumnsNames);
        try {
            model.pullFromMySQL();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String[] nameOfFields1 = new String[] {"Введите пароль"};
        String[] nameOfButtons1 = new String[] {"Открыть базу", "Записать в файл"};
        int[] initFormSettings1 = new int[] {300, 150, 1, 2};

        CreatFormClass obj1 = new CreatForm1(nameOfFields1, nameOfButtons1, initFormSettings1, model);
        obj1.createAverageGUI();
    }
}
