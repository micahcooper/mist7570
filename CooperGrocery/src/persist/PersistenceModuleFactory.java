/**
 * 
 */
package persist;

/**
 * @author mrcooper
 *
 */

import java.sql.*;

public class PersistenceModuleFactory {

  private static final String url = "jdbc:mysql://localhost:3306/grocery";
  private static final String user = "root";
  private static final String pass = "";
  
  private static Connection p_conn;
  
  static{
  	if(p_conn == null){
  		try {
			// create the driver for MySQL
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// establish the database connection
			p_conn = DriverManager.getConnection( url, user, pass );
		}catch( Exception e ) {	// just in case...
			e.printStackTrace();
		}
  	}
  }

  public static PersistenceModule createPersistenceModule() throws Exception{
  		return new PersistenceModuleImpl( p_conn );
  }

};
