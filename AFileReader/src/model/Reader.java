/**
 * 
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 * @author micah cooper
 *
 */
public class Reader {
	private File file;
	private URL url;
	private String contents;
	
	/**
	 * 
	 */
	public Reader(URL url) {
		System.out.println("reader created");
		this.url = url;
	}

	/**
	 * @param filename
	 */
	public void read(){
		BufferedReader buffer;
		
		try{
			file = new File( url.getPath() );
			FileReader read = new FileReader(file);
			char c;
			//System.out.println( "filename: "+file.toString()+" - message: "+read.read() );
			while ((c = (char)read.read()) != -1) {
				contents += c;
	            System.out.print( c );
	         }
			read.close();
		}
		catch(Exception e){
			System.out.println( "ERROR: "+e.getMessage() );
		}
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
}
