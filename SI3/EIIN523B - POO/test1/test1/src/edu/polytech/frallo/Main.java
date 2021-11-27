package edu.polytech.frallo;





/**
 * Pour le controle final
 * @author fred rallo
 * @version 2020-2021
 *
 */
public class Main {

	public static String NUM_ETUDIANT = "22107026";


	
	public static void main(String[] args) {
		Controle students = new Controle();
		
	    System.out.println(students.hello());
	    System.out.println();
	    System.out.println("==> Ton code secret est = " + students.createCode(NUM_ETUDIANT) );
	}
}
