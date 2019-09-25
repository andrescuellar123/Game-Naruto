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
	/**
	 * @param nameClan a new name of the Clan
	 * return boolean finded
	 */
	
	public boolean searchClan(String nameClan) {
	
		boolean finded = false;
	
		for (int i =0;i<clan.size() && !finded ; i++) {
			if (clan.get(i).getName().equals(nameClan)) {
				
				
				finded =true;
			}
		}
	 return finded;
	}
	/**
	 * @param name a new name of the clan
	 * return del
	 */
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
	/**
	 * @param cla a new Clan
	 * return repetitive
	 */
	public boolean repetitiveClan(Clan cla) {
		boolean repetitive = false;
		for(int i = 0; i < clan.size() && repetitive == true; i++) {
			if(clan.get(i).getName().equals(cla.getName())) {
				repetitive = true;
			}
		}
		return repetitive;
	}
	
	/**este metodo organiza al clan por su nombre
	 */
	
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
	/**
	 * @param cla a new Clan
	 * return ad
	 */
	
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
	/**
	 * @param cla a new Clan
	 * @param changedName a new name
	 * return upda
	 */
	
	
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
	/**
	 * @param charc a new Charact
	 * @param name a new name
	 * return ad
	 */
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
	
	/**
	 * @param chara a new Charact
	 * return del
	 */
	
	public boolean deleteCharacter(Charact chara) throws MyException {
		boolean del = false;
		for(int i = 0; i < clan.size() && del == true; i++) {
			if(clan.get(i).repetitiveCharacter(chara)) {
				 clan.get(i).deleteCharcter(chara);
				 del = true;
			}
			else
				throw new MyException("no se puede borrar");
		}
		
		return del;
	}
	/**
	 * @param chara a new Charact
	 * return upda
	 */
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
	/**
	 * @param chara a new Charact
	 * return upda
	 */
	
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
	/**
	 * @param chara a new Charact
	 * return upda
	 */
	
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
	/**
	 * @param tec a new Technique
	 * @param name a new name
	 * *@param charc a new Charact
	 * return ad
	 */
	
	public boolean addTechnique( String name , Technique tec, Charact charc) throws MyException {
		boolean ad = false;
		for(int i = 0; i < clan.size() && ad == true; i++) {
			if(clan.get(i).repetitiveCharacter(charc)) {
				 clan.get(i).addTechnique(tec, name);
				 ad= true;
			}
			else
				throw new MyException("no se puede aniadir");
		}
		return ad;
	}
	

	/**
	 * @param tec a new Technique
	 * return upda
	 */
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
	
	/**
	 * @param tec a new Technique
	 * return upda
	 */
	
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
	/**
	 * @param tec a new Technique
	 * return del
	 */
	
	public boolean deleteTechnique(Technique tec) throws MyException {
		boolean del = false;
		for(int i = 0; i < clan.size(); i++) {
			if(clan.get(i).deleteTechnique(tec)) {
				del = true;
			}			else
				throw new MyException("no se puede borrar	");
		}
		
		return del;
	}
	
	
	
}
