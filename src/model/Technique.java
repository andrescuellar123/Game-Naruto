package model;

import java.io.Serializable;
import java.util.Comparator;

public class Technique implements Serializable {
	private String name;
	private double factor;
	private Technique nex;
	
	
	/**
	 * @param name
	 * @param factor
	 */
	public Technique(String name, double factor) {
		super();
		this.name = name;
		this.factor = factor;
	}
	
	






	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}









	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}









	/**
	 * @return the factor
	 */
	public double getFactor() {
		return factor;
	}









	/**
	 * @param factor the factor to set
	 */
	public void setFactor(double factor) {
		this.factor = factor;
	}



	





	/**
	 * @return the nex
	 */
	public Technique getNex() {
		return nex;
	}









	/**
	 * @param nex the nex to set
	 */
	public void setNex(Technique nex) {
		this.nex = nex;
	}




  



	public int compareName(Technique t) {
		
		return name.compareTo(t.getName());
	}
	

	
	

	@Override
	public String toString() {
		return "Technique [name=" + name + ", factor=" + factor + "]";
	}





	/** use this method to jump two times
	 * return Technique
	 */



	public Technique dobleSiguiente() {
		return nex = nex.nex;
		
	}






		













    

	
	

}
