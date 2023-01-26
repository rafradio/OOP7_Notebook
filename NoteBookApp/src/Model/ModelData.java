package Model;

import java.io.File;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ModelData {
    public ArrayList<LinkedHashMap<String, Object>> dataShell = new ArrayList<>();
    public String[] nameOfColumns;
    private String password;

    public ModelData(String[] nameOfColumns) {
        this.nameOfColumns = nameOfColumns;
    }

    public void pullFromMySQL() throws Exception {

        try {
            File myObj = new File("src/DataInFile/password.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().replaceAll("\\s", "");
                this.password = data;
            }
            myReader.close();
            
        } catch(Exception e) { System.out.println(e);}

        this.dataShell.clear();

        try {

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database3",
                "root", this.password
                );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from phonebookjava");

            
            while (resultSet.next()) {
                LinkedHashMap<String, Object> data = new LinkedHashMap<>();
                for (int i = 0; i < this.nameOfColumns.length; i++) {
                    data.put(this.nameOfColumns[i], resultSet.getString(this.nameOfColumns[i]));
                }
                // System.out.println(data);
                this.dataShell.add(data);
            }
            // System.out.println(this.dataShell);
            resultSet.close();
            statement.close();
            connection.close();
        } 
        catch(Exception e) { System.out.println(e);}
    }

    public void insertDataInMySQL(ArrayList<String> data) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("hello world insertdata");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database3",
                "root", this.password
                );

            PreparedStatement stmt = connection.prepareStatement("insert into phonebookjava (FIO, Telephone, Email, Address) values(?,?,?,?)");  
            for (int i = 0; i < data.size(); i++) {
                stmt.setString(i+1, data.get(i));
            }
            int i = stmt.executeUpdate(); 
            connection.close();
        }
        catch(Exception e) { System.out.println(e);}
    }

    public void deleteDataInMySQL(ArrayList<String> data) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("hello world deleteDataInMySQL");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database3",
                "root", this.password
                );

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM phonebookjava WHERE id=?"); 
            stmt.setString(1, data.get(0));
            // for (int i = 0; i < data.size(); i++) {
            //     stmt.setString(i+1, data.get(i));
            // }
            int i = stmt.executeUpdate(); 
            connection.close();
        }
        catch(Exception e) { System.out.println(e);}
    
    }

    
}
