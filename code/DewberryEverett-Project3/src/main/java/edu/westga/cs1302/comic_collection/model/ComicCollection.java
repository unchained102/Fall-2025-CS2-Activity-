package edu.westga.cs1302.comic_collection.model;

import java.util.ArrayList;

/** Represents a comid collection
 * 
 * @author Me
 * @version 1.0
 */
public class ComicCollection {
	private String name;
	private ArrayList<Comic> collection;
	
	/** Creates a new ComicCollection with the given name.
	 * 
	 * @param name the name of the ComicCollection
	 */
	public ComicCollection(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		
		this.name = name;
		this.collection =  new ArrayList<Comic>();
	}
	
	/** Name getter
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/** gets the list of comics in the collection.
	 * @return the collection
	 */
	public ArrayList<Comic> getCollection() {
		return this.collection;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
