package model;

import java.io.Serializable;
import java.util.Comparator;

public class Technique implements Serializable {
	private String name;
	private double factor;
	private Technique bef;
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
	 * @return the bef
	 */
	public Technique getBef() {
		return bef;
	}








	/**
	 * @param bef the bef to set
	 */
	public void setBef(Technique bef) {
		this.bef = bef;
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
	
	public double compareFactor(Technique t) {
		
		return factor - t.getFactor();
	}
	
	

	@Override
	public String toString() {
		return "Technique [name=" + name + ", factor=" + factor + "]";
	}

	
	
	
	
    public void addBTechnique( Technique tec ) throws MyException{
    	//creo una tecnica?
    	
    	if(tec.compareName(tec)!=0) {
    		
    		tec.nex=nex;
    		if( nex != null )
    			nex.bef = tec;
        		tec.bef = this;
        		nex=tec;
        		bef = tec;
    	}else 
    		throw new MyException("La tecnica tiene el mismo nombre");
    	
        
    }

    

	
	

}
