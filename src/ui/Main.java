package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Main {
	
	private NarutoGame juego;
	private Scanner reader;

	
	public Main(){
		  init();
		  reader = new Scanner(System.in);
		}


		public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
		}

		public void init(){
		  
		}


		public void showMenu(){
			System.out.println("********************************************************************");
			System.out.println("1.agregar un clan");
			System.out.println("2.Agregar un personaje");
			System.out.println("3.Agregar tecnica");
			System.out.println("4.Agregar encuestas a una empresa");
			System.out.println("5.Agregar un edificio a una empresa");
			System.out.println("6.Agregar un empleado a un cubiculo");
			System.out.println("7.Buscar al empleado en la empresa en forma de L");
			System.out.println("8.Buscar al empleado en la empresa en forma de E");
			System.out.println("9.Buscar al empleado en la empresa en forma de Espiral");
			System.out.println("10.Buscar al empleado en la empresa en forma de O");
			System.out.println("11.Buscar al empleado en la empresa en forma de X");
			System.out.println("12.Salir");
			System.out.println("********************************************************************");
			
		
			while(userImput !=12 ){
				userImput = reader.nextInt();
			
				reader.nextLine();
				
				
				
				if(userImput == 1){
					System.out.println("A continuacion digite el nombre del clan  ");
					System.out.println("name");
					String name = reader.nextLine();
					

					
					Clan cla = new Clan(name);
					
			}
				

			else if(userImput == 2){
				System.out.println("A continuacion digite el nombre del personaje  ");
				System.out.println("name");
				String name = reader.nextLine();
				
				System.out.println("A continuacion digite la personalidad del personaje  ");
				System.out.println("personality");
				String  personality = reader.nextLine();
				
				
				System.out.println("A continuacion digite la fecha de nacimiento  ");
				System.out.println("creationDate");
				String creationDate = reader.nextLine();
				
				
				System.out.println("A continuacion digite el poder del personaje  ");
				System.out.println("power");
				
				double power = reader.nextDouble();
				Charact charct = new Charact(name,personality,creationDate,power);
				charct.addTechnique();
				
		 	}
				
			
			else if(userImput == 3){
					System.out.println("A continuacion digite el nombre de la tecnica  ");
					System.out.println("name");
					String name = reader.nextLine();
					
					System.out.println("A continuacion digite el factor de la tecnica  ");
					System.out.println("factor");
					double factor = reader.nextDouble();
					
					Technique tec = new Technique(name,factor);
					charct.addTechnique(tec);
					
					
					
			 }
			else if(userImput == 4) {
				System.out.println(cha.add(e));
			}

		}
	}
}
