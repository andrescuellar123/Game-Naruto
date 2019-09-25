package model;

import java.util.ArrayList;
import java.util.Comparator;

public class Charact implements Comparable<Charact>{
	
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private Technique first;
	private Charact before;
	private Charact next;

	

	
	
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
	
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;

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







	/**
	 * @return the first
	 */
	public Technique getFirst() {
		return first;
	}







	/**
	 * @param first the first to set
	 */
	public void setFirst(Technique first) {
		this.first = first;
	}








	/**
	 * @return the before
	 */
	public Charact getBefore() {
		return before;
	}







	/**
	 * @param before the before to set
	 */
	public void setBefore(Charact before) {
		this.before = before;
	}







	/**
	 * @return the next
	 */
	public Charact getNext() {
		return next;
	}







	/**
	 * @param next the next to set
	 */
	public void setNext(Charact next) {
		this.next = next;
	}


	
	public Charact dobleSiguiente() {
		return next = next.next;
		
	}





	
	@Override
	public int compareTo(Charact c) {
		
		return name.compareTo(c.getName());
	}
	
	
	//encontrar una tecnica por el nombre
	
	/**
	 * @param nameTec a new name
	 * return msj
	 */
	
    public String findName(String nameTec ){
    	Technique act =first;
    	String msj= "";
       while( act != null && act.getName().equals(nameTec) == true ) {
    	   
			msj += act+"\n";
		
       }

        return msj;
    }
    
	/**
	 * @param tec a new technique
	 * return b
	 */
	
	public boolean addTechnique(Technique tec)throws MyException {
		boolean b = false;
		Technique act = first;
		if(repetitiveTechnique(tec)== false) {
			
			if (act==null) {
				act = tec;
				b = true;
			} else {
				while(act != null) {
					tec.setNex(act);
					act = tec;
					b =true;
				}
			}
		}
		else
			throw new MyException("La tecnica tiene el mismo nombre");
		
		return b;
	}
	
	/**
	 * @param tec a new technique
	 * return repetitive
	 */
	
	public boolean repetitiveTechnique(Technique tec) {
		boolean repetitive = false;
		Technique act = first;
		while(!repetitive && act != null) {
			if(act.compareName(tec)==0) {
				repetitive = true;
			}
			act = act.getNex();
		}
		return repetitive;
	}
	
	/**
	 * @param tec a new technique
	 * return bor
	 */
	
	public boolean deleteTechnique( Technique tec) throws MyException {
		
		boolean bor = false;
		
		if(first != null) {
			
			 if(first.getName().equals(tec.getName()) == true) {
				first = first.getNex();
				bor =true;
			}else {
				while( first!= null && bor == true && first.getNex() != null ) {
					if(first.getNex().getName().equals(tec.getName())) {
						first.setNex(first.dobleSiguiente());
						bor = true;
					}
					first = first.getNex();
				}
			}
			
		} else if(first == null) {
			 
			throw new MyException("no existe esa tecnica");
		 }
		return bor;
	}
	
	//retorna las tecnicas (responsabilidades)
	
	/**
	 * return upda
	 */
	public String techniquesOfTheCharacter() {
		String ms = "";
		Technique act = first;
		while(act != null) {
			ms += act + "  ";
			act = act.getNex();
		}
		return ms;
	}

	
	/**
	 * @param tec a new technique
	 * return double
	 */
    
    public double calculateFactor(Technique tec) {
 
    	return tec.getFactor()*power;
    }
	
	/**
	 * @param t a new technique
	 * return upda
	 */
	public boolean ModifyTechniqueName(Technique t) throws MyException{
		Technique act = first;
		boolean upda = false;
		if(repetitiveTechnique(t)== false) {
			if(act != null) {
				while(act != null && upda == true) {
					if(act.getName().equals(t.getName())) {
						act.setName(t.getName());
						upda = true;
					}
					act = act.getNex();
				}
			}
		}
		else
			throw new MyException("no se puede actualizar la tecnica");
		return upda;
	}
	
	/**
	 * @param t a new technique
	 * return upda
	 */
	
	
	public boolean ModifyTechniqueFactor(Technique t) {
		Technique act = first;
		boolean upda = false;
		if(!repetitiveTechnique(t)) {
			while(act != null && upda == true) {
				if(act.getFactor()-t.getFactor()!= 0) {
					act.setFactor(t.getFactor());
					upda = true;
				}
				act = act.getNex();
			}
		}
		return upda;
	}
	
	
	

	
	
	
	
}
