/**
 * 
 */
package model;

import java.io.FileReader;

/**
 * @author mrcooper
 *
 */
public class Reader {
	public int[] test;
	private String filename;
	boolean isAvailable;
	
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		read("");
		return isAvailable;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * 
	 */
	public Reader() {
		System.out.println("reader created");
		test = new int [5];
		int [] test = {1,2,3,4,5};	
	}
	
	public void read(String filename){
		if(filename.equals(""))
			filename=this.filename;
		
		try{
			FileReader read = new FileReader(filename);
			read.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
