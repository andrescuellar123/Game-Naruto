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
	 
	
	

	
	public boolean addCharacter(Charact chac) throws MyException {
		boolean ad = false;
		if(!repetitiveCharacter(chac)) {
			if(first == null) {
				first = chac;
			}
			else {
				chac.setNext(first);
				first.setBefore(chac);
				first = chac;
			}
			ad = true;
		}
		else {
			throw new MyException("no se puede aniadir");
		}
		return ad;
	}
	
	
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
	
	
	
	public boolean deleteCharcter(Charact charc) {
		
		boolean h = false;
		Charact act = first;
		
		if(first != null && first.getName().equals(charc.getName())) {
			
			first = first.getNext();
			
			if(first != null) {
				
				first.setBefore(null);
				
			}
			h = true;
		}
		else {
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
		return h;
	}
	
	
	//update
	
	public boolean updateCharacterName(Charact t) {
		Charact act = first;
		boolean upda = false;
		if(!repetitiveCharacter(t)) {
			while(act != null && !upda) {
				if(act.getName().equals(t.getName())) {
					act.setName(t.getName());
					upda = true;
				}
				act = act.getNext();
			}
		}
		return upda;
	}
	
	
	public boolean updateCharacterPersonality(Charact t) {
		Charact act = first;
		boolean upda = false;
		if(!repetitiveCharacter(t)) {
			while(act != null && !upda) {
				if(act.getPersonality().equals(t.getPersonality())) {
					act.setPersonality(t.getPersonality());
					upda = true;
				}
				act = act.getNext();
			}
		}
		return upda;
	}
	
	public boolean updateCharacterCreationDate(Charact t) {
		Charact act = first;
		boolean upda = false;
		if(!repetitiveCharacter(t)) {
			while(act != null && !upda) {
				if(act.getCreationDate().equals(t.getCreationDate())) {
					act.setCreationDate(t.getCreationDate());
					upda = true;
				}
				act = act.getNext();
			}
		}
		return upda;
	}
	
	
	public boolean updatePower(Charact t) {
		Charact act = first;
		boolean upda = false;
		if(!repetitiveCharacter(t)) {
			while(act != null && !upda) {
				if(act.getPower()-t.getPower()!= 0) {
					act.setPower(t.getPower());
					upda = true;
				}
				act = act.getNext();
			}
		}
		return upda;
	}
	
	
	//responsabilidades tecnicas
	
	
	
	
	public String theTechniques() {
		String ms = "";
		Charact act = first;
		while(act != null) {
			ms += act.techniquesOfTheCharacter();
			act = act.getNext();
		}
		return ms;
	}
	
	public boolean addTechnique(Technique tec, String nameNinja) throws MyException {
		boolean ad = false;
		Charact act = first;
		while( ad==true && act != null ) {
			if(act.getName().equals(nameNinja)) {
				ad = act.addTechnique(tec);
				act = act.getNext();
			}
			else
				throw new MyException("no se puede agregar la tecnica");
		}
		return ad;
	}
	
	
	public boolean deleteTechnique(Technique tec) {
		boolean del = false;
		Charact actual = first;
		while(actual != null) {
			try {
				if(actual.deleteTechnique(tec)) {
					del = true;
				}
			} catch (MyException e) {
				
				e.printStackTrace();
			}
			actual = actual.getNext();
		}
		return del;
	}
	
	public boolean updateTechniqueName(Technique t) {
		Charact act = first;
		boolean upda = false;
	
			while(act != null && !upda) {
				if(act.updateTechniqueName(t)) {
					
					upda = true;
				}
				act = act.getNext();
			}
		
		return upda;
	}
	
	public boolean updateTechniqueFactor(Technique t) {
		Charact act = first;
		boolean upda = false;
		
			while(act != null && !upda) {
				if(act.updateTechniqueFactor(t)) {
					
					upda = true;
				}
				act = act.getNext();
			}
		
		return upda;
	}
	
	
	
	


	

	 
}
