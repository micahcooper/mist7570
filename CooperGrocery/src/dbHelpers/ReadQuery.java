/**
 * 
 */
package dbHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author micah cooper
 *
 */
public class ReadQuery {
	private Connection connection;
	private ResultSet results;
	
	/**
	 * 
	 */
	public ReadQuery() {
		// TODO Auto-generated constructor stub
	}
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		//set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead(){
		String query = "select * from products";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			results = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getHTMLTable(){
		String table = "";
		
		table += "<table border=1 class=table1>";
		try {
			while(this.results.next()){
				Product product = new Product();
				product.setSku( this.results.getString("SKU") );
				product.setProductType( this.results.getString("Product Type") );
				product.setFlavor( this.results.getString("Flavor") );
				product.setCost( this.results.getDouble("Cost") );
				product.setPrice( this.results.getDouble("Price") );
				product.setQuantity( this.results.getInt("Quantity") );
				
				table += "<tr>";
				table += "<td>";
					product.getSku();
				table += "</td>";
				table += "<td>"+product.getSku()+"</td>";
				table += "<td>"+product.getProductType()+"</td>";
				table += "<td>"+product.getFlavor()+"</td>";
				table += "<td>"+product.getCost()+"</td>";
				table += "<td>"+product.getPrice()+"</td>";
				table += "<td>"+product.getQuantity()+"</td>";
				table += "<td>";
					table += "<a href='update?productSku'>UPDATE</a>";
				table += "</td>";
				table += "<td>";
					table += "<a href='delete?productSku'>DELETE</a>";
				table += "</td>";
				table += "</tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table += "</table>";
		
		return table;
	}
}
