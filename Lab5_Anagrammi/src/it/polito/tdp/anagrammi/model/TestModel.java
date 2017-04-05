package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.model.Model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model model = new Model(); 
		 //array: matrice con tutte le righe una di fianco all'altro.
		/**
		 * mi interessa una lista di oggetti quadrato.
		 */
		
		model.findAnagrams("casa") ;
	
		List<String> anagrammiR = model.getAnagrammiR() ;
		List<String> anagrammiW = model.getAnagrammiW() ;
		
		if(anagrammiR != null ){
			System.out.println("Anagrammi giusti");
			
			for(String s : anagrammiR) {
				System.out.println(s.toString());
			}
			
		}else{
			System.out.println("Nessun anagramma giusto");
		}
		
		if(anagrammiW != null ){
			System.out.println("Anagrammi sbagliati");
			
			for(String s : anagrammiW) {
				System.out.println(s.toString());
			}
			
		}else{
			System.out.println("Nessun anagramma sbagliato");
		}
		
	}

}
