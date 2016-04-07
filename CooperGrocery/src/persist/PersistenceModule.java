/**
 * 
 */
package persist;

/**
 * @author micah cooper
 *
 */


import model.Product;
import java.sql.*;


public class PersistenceModule {

	private Connection connection = null;
	  //private PreparedStatement  statement = null;

	  public PersistenceModule( Connection connection ) throws Exception {
			this.connection = connection;
		}
	  
	  public void doAdd(Product product){
			String query = "INSERT INTO products (SKU, `Product Type`, Flavor, Cost, Price, Quantity) values (?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, product.getSku());
				ps.setString(2, product.getProductType());
				ps.setString(3, product.getFlavor());
				ps.setDouble(4, product.getCost());
				ps.setDouble(5, product.getPrice());
				ps.setInt(6, product.getQuantity());

				ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block; add real error handling!
				e.printStackTrace();
			}
		}

		public void doDelete(String sku) {
			String query = "DELETE FROM products WHERE SKU = ?";

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, sku);

				ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block; add real error handling!
				e.printStackTrace();
			}
		}

		public void doUpdate(Product product){
			String query = "UPDATE products SET title=?, author=?, pages=? WHERE productID=?";

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				//TODO ps.setString(1, product.getTitle());
				//ps.setString(2, product.getAuthor());
				//ps.setInt(3, product.getPages());
				//ps.setInt(4, product.getProductID());

				ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block; add real error handling!
				e.printStackTrace();
			}
		}

		/**
		 * doReadAll() is a refactor of the ReadQuery object's doRead() method
		 * in the previous version.
		 * 
		 * In this version, doReadAll() returns a result set rather than 
		 * storing it as a field of this helper object. The {@link #getHTMLTable()}
		 * helper is modified to accept the result set instead.
		 *  
		 * @return ResultSet
		 */
		public ResultSet doReadAll(){
			String query = "SELECT SKU,'Product Type',Flavor,Cost,Price,Quantity FROM products"; // <-- Better

			ResultSet results = null;
			try {
				PreparedStatement ps = this.connection.prepareStatement(query);
				results = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block; add real error handling!
				e.printStackTrace();
			}

			return results;
		}


		/**
		 * doReadOne() is a refactor of the ReadRecord object's doRead() method
		 * in the previous version.
		 * 
		 * In this version, doReadOne() accepts an integer rather than 
		 * storing it the id as a field of this helper object. It also returns a Product
		 * object, rather than storing it as a field.
		 * 
		 * One consequence of this change is that the calling code is now responsible 
		 * for keeping track of the resulting Product reference, rather than 
		 * the helper object.
		 * 
		 * @param int
		 * @return Product
		 **/
		public Product doReadOne(int productId) {
			String query = "SELECT * FROM products WHERE productID = ?";

			Product product = null;

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				ps.setInt(1, productId);
				ResultSet results = ps.executeQuery();

				results.next();

				// What if product isn't found? Is an exception thrown?
				// Is it okay to return null from this refactored method?

				product = new Product(
						results.getString("Sku"),
						results.getString("Product Type"),
						results.getString("Flavor"),
						results.getDouble("Cost"),
						results.getDouble("Price"),
						results.getInt("Quantity")
						);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return product;
		}
		
		/**
		 * This version was refactored to accept a result set, rather than rely
		 * on a result set existing as a field of the instance.
		 * 
		 * This object could be further refactored to run without a result set. 
		 * One path  might be to create an overloaded version that takes no parameters.
		 * 
		 * @param results
		 * @return String
		 */
		public String getHTMLTable(ResultSet results){
			String table ="";
			table += "<table border=1>\n";
			table += "<tr><th>SKU</th><th>Product Type</th><th>Flavor</th><th>Cost</th><th>Price</th><th>Quantity</th><th>Actions</th></tr>";
			try {
				while(results.next()) {

					// Consider: Why are we creating Book objects with these results, rather 
					// than just printing the results of the query directly?
					// (It helps us validate our data.)

					Product product = new Product(
							results.getString("Sku"),
							results.getString("Product Type"),
							results.getString("Flavor"),
							results.getDouble("Cost"),
							results.getDouble("Price"),
							results.getInt("Quantity")
							);

					table += product.getHTMLRow();
					
					// Consider adding behavior that might make this more user friendly:
					// a) adding an "Are you sure?" Javascript popup.
					// b) adding a success message to the reloaded page.
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			table += "</table>";
			return table;
		}

}
