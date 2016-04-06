/**
 * 
 */
package persist;

import java.sql.ResultSet;

/**
 * @author mrcooper
 *
 */
public interface PersistenceModule {
	
	public ResultSet doReadAll();
	public String getHTMLTable(ResultSet results);
}
