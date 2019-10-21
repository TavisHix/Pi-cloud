import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
   
public class dbHandler {  
     /** 
     * Connect to a sample database 
     */  
    public static void connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
            String url = "jdbc:sqlite:C:/sqlite/Users.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }
    
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/Users.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"  
                + " _id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " _name text NOT NULL,\n"  
                + " _password text NOT NULL\n"  
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    
    public static void insertAndDisplay(String user, String pass) {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/Users.db";  
          
        // SQL statement for creating a new table  
        String sql = "INSERT INTO users(_name, _password) VALUES('" + user + "','" + pass +"')";  
         
        try{  
           Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
           stmt.execute(sql);  
        } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
        //End of Insert

    }  
    
    public static void printdb(){
    	//BEGINING SELECT
    	
    	String url = "jdbc:sqlite:C://sqlite/Users.db";  
        String sql2 = "Select * from users";  
        
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql2);
            
            while(rs.next())
            {
                System.out.println(rs.getInt("_id") +  "\t" +   
                        rs.getString("_name") + "\t" +  
                        rs.getString("_password"));
            }
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        
        //END OF SELECT
    }
    

    public static int validateLogin(String user, String password) {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/Users.db";  
        boolean userExist = false;
        boolean passwordExist = false;
        int correctLogin = 0;
        //BEGINING SELECT
        String search = "Select * from users where _name = '" + user + "'";  
        
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(search);
            
            if(rs.next())
            {
            	userExist = true;
            	passwordExist = checkPassword(user, password);
            }
            else{
            	 return correctLogin = 1;
            }
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        
        if(passwordExist && userExist)
        {
        	correctLogin = 0;
        }
        else{
        	return correctLogin = 2;
        }
        return correctLogin;
        //END OF SELECT
    }  
    
    public static boolean checkPassword(String user, String password) {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/Users.db";  
        boolean passwordExist = false;
        //BEGINING SELECT
        String search = "Select * from users where _name = '" + user + "' and _password = '" + password + "'";  
        
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(search);
            
            if(rs.next())
            {
            	passwordExist = true;
            }
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return passwordExist;
        //END OF SELECT
    }  
    
    public static void  delete()
    {
    	String url = "jdbc:sqlite:C:/sqlite/Users.db";
    	
    	String del = "Delete from users";  
    	
    	try{  
            Connection conn = DriverManager.getConnection(url);  
             Statement stmt = conn.createStatement();  
            stmt.execute(del);  
         } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    public static void main(String[] args)
    {
    	delete();
    	printdb();
    }
}