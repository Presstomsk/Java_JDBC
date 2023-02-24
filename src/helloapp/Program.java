package helloapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Program {
	  public static void main(String[] args) {
		  
		     try {
				Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/store","root","root")){
					System.out.println("Connection succes");
					Statement statement = connection.createStatement(); 
					int rows = statement.executeUpdate("INSERT buyer(Name) VALUES ('Bill')"); //Вставка
			        System.out.printf("Added %d rows\n", rows);
			        rows = statement.executeUpdate("INSERT country(Name) VALUES ('Russia')");
			        System.out.printf("Added %d rows\n", rows);
			        rows = statement.executeUpdate("INSERT city(Name,countryId) VALUES ('Tomsk',1)");
			        System.out.printf("Added %d rows\n", rows);
			        rows = statement.executeUpdate("INSERT section(Name) VALUES ('Sport')");
			        System.out.printf("Added %d rows\n", rows);
			        rows = statement.executeUpdate("INSERT promotionalgoods(Name,sectionId) VALUES ('Ball',1)");
			        System.out.printf("Added %d rows\n", rows);
			        rows = statement.executeUpdate("UPDATE buyer SET Name = 'Ron' Where Id = 1"); //Редактирование
	                System.out.printf("Updated %d rows\n", rows);
	                rows = statement.executeUpdate("UPDATE country SET Name = 'China' Where Id = 1"); 
	                System.out.printf("Updated %d rows\n", rows);
	                rows = statement.executeUpdate("UPDATE city SET Name = 'Shanghai' Where countryId = 1"); 
	                System.out.printf("Updated %d rows\n", rows);
	                rows = statement.executeUpdate("UPDATE section SET Name = 'Culture' Where Id = 1"); 
	                System.out.printf("Updated %d rows\n", rows);
	                rows = statement.executeUpdate("UPDATE promotionalgoods SET Name = 'Piano' Where sectionId = 1"); 
	                System.out.printf("Updated %d rows\n", rows);
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM buyer"); //Выборка
	                while(resultSet.next()){
	                     
	                    int id = resultSet.getInt(1);
	                    String name = resultSet.getString(2);	                    
	                    System.out.printf("%d. %s\n", id, name);
	                }
				}	
				
			} 
		     catch (Exception ex) {
		    	 System.out.println("Connection failed");
			}          
	  }
}



