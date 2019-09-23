package model;

import java.util.Comparator;

public class Charact implements Comparable<Charact>, Comparator<Charact>{
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private Technique first;
	private Technique end;
	private Character before;
	private Character after;
	
	

	
	
	/**
	 * @param name
	 * @param personality
	 * @param creationDate
	 * @param power
	 * @param first
	 * @param end
	 * @param before
	 * @param after
	 */
	public Charact(String name, String personality, String creationDate, double power) {
		super();
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		first=null;
		this.end = end;
		this.before = before;
		this.after = after;
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
	 * @return the personality
	 */
	public String getPersonality() {
		return personality;
	}
	/**
	 * @param personality the personality to set
	 */
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the power
	 */
	public double getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(double power) {
		this.power = power;
	}
	

	public int compareName(Charact c) {
		
		return name.compareTo(c.getName());
	}
	public int comparePersonality(Charact c) {
		
		return personality.compareTo(c.getPersonality());
	}
	public int compareCreationDate(Charact c) {
		
		return creationDate.compareTo(c.getCreationDate());
	}
	public double comparePower(Charact c) {
		
		return power -c.getPower();
	}

	
	public void addTechnique(String name, double factor) throws MyException{
        Technique tecnique1 = new Technique( name, factor);
        if( first == null )
            first = tecnique1;
        else
        {
            Technique t = null;
            Technique j = tecnique1;
            while( tecnique1 != null  )
            {
                t = j;
                j = j.getNex();
            }
            t.addBTechnique( tecnique1 );
        }
        
	}
	@Override
	public int compare(Charact arg0, Charact arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int compareTo(Charact arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
