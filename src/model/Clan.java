package model;

public class Clan {
	 private  String name;
	 private Charact first;
	 private Charact before;
	 private Charact next;
	 
	 
	public Clan(String name) {
	
		this.name = name;
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
	 * @return the first
	 */
	public Charact getFirst() {
		return first;
	}




	/**
	 * @param first the first to set
	 */
	public void setFirst(Charact first) {
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




	public int compareName(Clan cla) {
		
		return name.compareTo(cla.getName());
	}
	 
	
	
	/**
	 * @param t a new Charact
	 * return upda
	 */
	
	public boolean addCharacter(Charact chac) throws MyException {
		boolean ad = false;
		
		 if(repetitiveCharacter(chac) == false) {
			chac.setNext(first);
			first.setBefore(chac);
			first = chac;
			ad = true;
		}
		 else if(first == null) {
				first = chac;
				ad = true;
			}

			
		
		else {
			throw new MyException("no se puede aniadir");
		}
		return ad;
	}
	
	/**
	 * @param t a new Charact
	 * return repetitive
	 */
	
	public boolean repetitiveCharacter(Charact charc) {
		boolean repetitive = false;
		Charact act = first;
		while(!repetitive && act != null) {
			if(act.compareTo(charc)==0) {
				repetitive = true;
			}
			act = act.getNext();
		}
		return repetitive;
	}
	
	/**
	 * @param charc a new Charact
	 * return h
	 */
	
	public boolean deleteCharcter(Charact charc) throws MyException{
		
		boolean h = false;
		Charact act = first;
		
		if(first != null && first.getName().equals(charc.getName()) == true) {
			
			first = first.getNext();
			
			if(first != null) {
				
				first.setBefore(null);
				
			}
			h = true;
		}
		else if(first != null && first.getName().equals(charc.getName()) == false) {
			while(h == true  &&  act != null) {
				
				if(act.getName().equals(charc.getName())) {
					
					act = act.getBefore();
					act.setNext(act.dobleSiguiente());
					
					if(act.getNext() != null) {
						act.getNext().setBefore(act);
					}
					h = true;
				}
				act = act.getNext();
			}
		}
		
		else if (first == null)
			throw new MyException("no se puede borrar");
		return h;
	}
	
	
	//update
	/**
	 * @param t a new Charact
	 * return upda
	 */
	
	public boolean updateCharacterName(Charact t) throws MyException{
		Charact act = first;
		boolean upda = false;
		if(repetitiveCharacter(t)== false) {
			if(first !=null) {
				while(act != null && !upda) {
					if(act.getName().equals(t.getName())) {
						act.setName(t.getName());
						upda = true;
					}
					act = act.getNext();
				}
			}
			else if (first == null)
				throw new MyException("no se puede actualizar");
		}
		return upda;
	}
	
	/**
	 * @param t a new Charact
	 * return upda
	 */
	
	public boolean updateCharacterPersonality(Charact t) throws MyException{
		Charact act = first;
		boolean upda = false;
		if(repetitiveCharacter(t)== false) {
				if(first != null) {
				while(act != null && !upda) {
					if(act.getPersonality().equals(t.getPersonality())) {
						act.setPersonality(t.getPersonality());
						upda = true;
					}
					act = act.getNext();
				}
			}
		}
		else if (first == null)
			throw new MyException("no se puede actualizar");
		return upda;
	}
	/**
	 * @param t a new Charact
	 * return upda
	 */
	public boolean updateCharacterCreationDate(Charact t) throws MyException{
		Charact act = first;
		boolean upda = false;
		if(repetitiveCharacter(t)== false) {
			if(first!= null) {
				while(act != null && !upda) {
					if(act.getCreationDate().equals(t.getCreationDate())) {
						act.setCreationDate(t.getCreationDate());
						upda = true;
					}
					act = act.getNext();
				}
			}
		}
		else if (first == null)
			throw new MyException("no se puede actualizar");
		return upda;
	}
	
	/**
	 * @param t a new Charact
	 * return act
	 */
	
	public boolean updatePower(Charact t)throws MyException {
		Charact act = first;
		boolean upda = false;
		if(first != null) {
			if(!repetitiveCharacter(t)) {
				while(act != null && !upda) {
					if(act.getPower()-t.getPower()!= 0) {
						act.setPower(t.getPower());
						upda = true;
					}
					act = act.getNext();
				}
			}
		}
		else if (first == null)
			throw new MyException("no se puede actualizar");
		return upda;
	}
	
	
	//responsabilidades tecnicas
	
	
	/**
	 * return ms
	 */
	
	public String theTechniques() {
		String ms = "";
		Charact act = first;
		while(act != null) {
			ms += act.techniquesOfTheCharacter();
			act = act.getNext();
		}
		return ms;
	}
	/**
	 * @param t a new technique
	 * @param name a new name
	 * return ad
	 */
	public boolean addTechnique(Technique tec, String name) throws MyException {
		boolean ad = false;
		Charact act = first;
		while( ad==true && act != null ) {
			if(act.getName().equals(name)) {
				ad = act.addTechnique(tec);
				act = act.getNext();
			}
			else
				throw new MyException("no se puede agregar la tecnica");
		}
		return ad;
	}
	/**
	 * @param tec a new technique
	 * return del
	 */
	
	
	public boolean deleteTechnique(Technique tec) {
		boolean del = false;
		Charact act= first;
		while(act != null) {
			try {
				if(act.deleteTechnique(tec)) {
					del = true;
				}
			} catch (MyException e) {
				
				e.printStackTrace();
			}
			act = act.getNext();
		}
		return del;
	}
	/**
	 * @param t a new technique
	 * return upda
	 */
	
	public boolean updateTechniqueName(Technique t)throws MyException {
		Charact act = first;
		boolean upda = false;
			if(act != null) {
				while(act != null && !upda) {
					if(act.updateTechniqueName(t)) {
						
						upda = true;
					}
					act = act.getNext();
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
	
	public boolean updateTechniqueFactor(Technique t) throws MyException{
		Charact act = first;
		boolean upda = false;
			if(act != null) {
				while(act != null && !upda) {
					if(act.updateTechniqueFactor(t)) {
						
						upda = true;
					}
					act = act.getNext();
				}
			}
			else
				throw new MyException("no se puede actualizar la tecnica");
		
		return upda;
	}
	
	
	
	


	

	 
}
