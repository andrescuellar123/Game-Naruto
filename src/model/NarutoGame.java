package model;

import java.util.ArrayList;

public class NarutoGame {
	
	private ArrayList<Clan> clan;

	/**
	 * @return the clan
	 */
	public ArrayList<Clan> getClan() {
		return clan;
	}

	/**
	 * @param clan the clan to set
	 */
	public void setClan(ArrayList<Clan> clan) {
		this.clan = clan;
	}
	// Metdo para buscar cla 
	
	public boolean searchClan(String nameClan) {
	
		boolean finded = false;
	
		for (int i =0;i<clan.size() && !finded ; i++) {
			if (clan.get(i).getName().equals(nameClan)) {
				
				
				finded =true;
			}
		}
	 return finded;
	}
	
	public boolean deleteClan(String name)  {
		boolean del = false;
		for(int i = 0; i < clan.size() && del == true; i++) {
			if(clan.get(i).getName().equals(name)) {
				clan.remove(i);
				del = true;
				
			}
		}
		return del;
	}
	
	public boolean repetitiveClan(Clan cla) {
		boolean repetitive = false;
		for(int i = 0; i < clan.size() && repetitive == true; i++) {
			if(clan.get(i).getName().equals(cla.getName())) {
				repetitive = true;
			}
		}
		return repetitive;
	}
	
	
	
	public void organizeNameClan() {
		for(int i = 0; i < clan.size();i++) {
			for(int j = 0;j<clan.size()-1-i;j++) {
				if(clan.get(j).compareName(clan.get(j+1))>0) {
					Clan tmp = clan.get(j);
					clan.set(j, clan.get(j+1));
					clan.set(j+1, tmp);
				}
			}
		}
	}
	
	
	
	//aniadir un clan
	
	public boolean addTheClans(Clan cla) throws MyException {
		boolean ad = false;
		if(repetitiveClan(cla) == true) {
			clan.add(cla);
			ad = true;
			
		}
		else {
			throw new MyException("no se ha podido aniadir el clan");
		}
		return ad;
	}
	
	
	public boolean updateClan( String changedName, Clan cla) throws MyException {
		boolean upda= false;
		if(repetitiveClan(cla)== true) {
			for(int i = 0; i < clan.size() && upda == false; i++) {
				if(clan.get(i).getName().equals(cla.getName())) {
					clan.get(i).setName(changedName);
					upda = true;
					
				}
			}
		}
		else {
			throw new MyException(" el nombre es el mismo");
		}
		return upda;
	}
	
	
	//responsabilidades Character
	
	public boolean addCharacter( String name, Charact charc) throws MyException  {
		boolean ad = false;
		for(int i = 0; i < clan.size() && ad == true; i++) {

			if(clan.get(i).getName().equals(name)) {
				clan.get(i).addCharacter(charc);
				ad = true;
			
			}
			else if(clan.get(i).repetitiveCharacter(charc)) {
				throw new MyException("no se puede aniadir");
				
			}
		}
		
		return ad;
	}
	
	
	
	public boolean deleteCharacter(Charact chara) throws MyException {
		boolean del = false;
		for(int i = 0; i < clan.size() && del == true; i++) {
			if(clan.get(i).repetitiveCharacter(chara)) {
				del = clan.get(i).deleteCharcter(chara);
			}
			else
				throw new MyException("no se puede borrar");
		}
		
		return del;
	}
	
	public boolean updateNameCharacter( Charact chara)throws MyException  {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updateCharacterName(chara)) {
				upda = true;
			}
			else
				throw new MyException("no se puede actualizar");
		}
		
		return upda;
	}
	
	
	public boolean updateCreationDate( Charact chara)throws MyException  {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updateCharacterCreationDate(chara)) {
				upda = true;
			}
			else
				throw new MyException("no se puede actualizar");
		}
		
		return upda;
	}
	
	public boolean updatePersonality( Charact chara)throws MyException  {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updateCharacterPersonality(chara)) {
				upda = true;
			}
			else
				throw new MyException("no se puede actualizar");
		}
		
		return upda;
	}
	public boolean updatePower( Charact chara)throws MyException  {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updatePower(chara)) {
				upda = true;
			}
			else
				throw new MyException("no se puede actualizar");
		}
		
		return upda;
	}
	
	
	
	
	
	//reponsabilidades tecnica
	
	public boolean addTechnique( String name , Technique tec, Charact charc) throws MyException {
		boolean added = false;
		for(int i = 0; i < clan.size() && !added; i++) {
			if(clan.get(i).repetitiveCharacter(charc)) {
				added = clan.get(i).addTechnique(tec, name);
				
			}
			else
				throw new MyException("no se puede aniadir");
		}
		return added;
	}
	
	
	public boolean deleteTechnique(Technique tec) throws MyException {
		boolean del = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).deleteTechnique(tec)) {
				del = true;
			}
		}
		
		return del;
	}
	
	public boolean updateTechniqueName(  Technique tec) throws MyException {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updateTechniqueName(tec)) {
				upda = true;
			}
			else
				throw new MyException("no se puede axtualizar");
		}
		
		return upda;
	}
	
	
	public boolean updateTechniqueFactor( Technique tec)throws MyException  {
		boolean upda = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).updateTechniqueFactor(tec)) {
				upda = true;
			}
			else
				throw new MyException("no se puede actualizar");
		}
		
		return upda;
	}
	
	
}
