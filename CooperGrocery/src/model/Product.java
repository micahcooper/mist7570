/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author micah cooper
 *
 */
public class Product {
	private String sku;
	private String productType;
	private String flavor;
	private double cost;
	private double price;
	private int quantity;
	
	/**
	 * 
	 */
	public Product(String sku, String productType, String flavor, double cost, double price, int quantity) {
		// TODO Auto-generated constructor stub
		this.sku = sku;
		this.productType = productType;
		this.flavor = flavor;
		this.cost = cost;
		this.price = price;
		this.quantity =  quantity;
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
	public String getHTMLRow(){
		String row ="";

		// Consider: Could this table row code be refactored to be part of Product?
		// Would that be a good idea or not?

		row +="<tr>";
		row +="\t<td>"+this.getSku()+"</td>";
		row +="<td>"+this.getProductType()+"</td>";
		row +="<td>"+this.getFlavor()+"</td>";
		row +="<td>"+this.getCost()+"</td>";
		row +="<td>"+this.getPrice()+"</td>";
		row +="<td>"+this.getQuantity()+"</td>";
		
		row +="\n\t<td>";
		
		// We made changes to the Delete servlet, so that it can't be accessed via 'GET'
		// Thus, this HTML needs to change as well. 
		// We'll create a small form that POSTs instead.
		row += "<a href=update?productID=" + this.getCost() + " >update</a><br>";
		row += "<form action=\"delete\" method=\"post\">";
		row += "<input type=\"hidden\" name=\"productID\" value=\"" + this.getCost() + "\">";
		row += "<input type=\"submit\" value=\"Delete\"></form>";
		
		// Consider adding behavior that might make this more user friendly:
		// a) adding an "Are you sure?" Javascript popup.
		// b) adding a success message to the reloaded page.
		
		row +="</td>\n";
		
		row +="</tr>\n";


		return row;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the flavor
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * @param flavor the flavor to set
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
