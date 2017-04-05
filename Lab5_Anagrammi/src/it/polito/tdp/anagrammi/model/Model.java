package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> anagrammi = null;
	private String parola; 
	private List<String> anagrammiR = null ;
	private List<String> anagrammiW = null ;
	
	/**
	 * @param anagrammi
	 * @param parola
	 * @param anagrammiR giusti
	 * @param anagrammiW sbagliati
	 */
	public Model() {
		super();
		this.anagrammi = null ; 
		this.parola = null ; 
		this.anagrammiR = null ; 
		this.anagrammiW = null ; 
	}

	public List<String> getAnagrammiR() {
		return anagrammiR;
	}

	public List<String> getAnagrammiW() {
		return anagrammiW;
	}
	
	/**
	 * metodo che voglio che chiami il controller
	 * @return
	 */
	public void findAnagrams(String parola) {

		anagrammi = new ArrayList<String>();
		this.parola = parola ;
		
		// Creo un oggetto Square
		
		String anagramma = new String();

		anagramma="";
		
		// Chiamo la funzione ricorsiva
		int step = 0;
		
		 recursive (anagramma, step);

		 correggi();		
		 
	}
	/**
	 * correggi chiama il BD
	 */
	private void correggi() {

		AnagrammaDAO chiamaDB = new AnagrammaDAO();
		
		anagrammiR = new ArrayList<String>();
		anagrammiW = new ArrayList<String>();

		
		for(String s : anagrammi){
			
			if(chiamaDB.isCorrect(s)) {
				anagrammiR.add(s);
			}
			else{
				anagrammiW.add(s);
			}
		}
		
	}

	// Struttura di un algoritmo ricorsivo generico
	
	private void recursive(String anagramma, int step) {
		char x ;
		
		// A : condizione di terminazione  - fai qualcosa
		if (this.parola.length() == step) {	
			//System.out.println(anagramma);
			if(!anagrammi.contains(anagramma))
				anagrammi.add(anagramma) ;
			return;
		}
		
		// cicliamo su tutte le lettere

		for (int i = 0; i < this.parola.length(); i++) {
			
			x = this.parola.charAt(i);
			
			 if (contaLettera(anagramma,x)) {
				
				anagramma += x ;
				
				recursive(anagramma, step + 1);
				
				/**
				 *  potevo fare anche 		recursive(anagramma + x , step + 1);
				 */
				
				anagramma = anagramma.substring(0, step) ;

			}
			
		}
		
	}

	private boolean contaLettera (String anagramma, char x) {
		
		int cAnagramma= 0, cParola = 0 ; 
		
		for(int i = 0 ; i< anagramma.length() ; i++)
			if(anagramma.charAt(i) == x )
				cAnagramma ++ ;

		for(int i = 0 ; i< this.parola.length() ; i++)
			if(this.parola.charAt(i) == x )
				cParola ++ ;
		
		if(cAnagramma<cParola)
			return true;
		
		return false ;
	}
		
}	
	/**
	 * 	private void recursive(Square square, int step) {
		
		if (step >= square.getN2()) {
			if (square.checkMagicConst()) {
				solutions.add(new Square(square));
			}
			return;
		}

		for (int i = 1; i <= square.getN2(); i++) {
			if (!square.contains(i)) {
				square.add(i);
				recursive(square, step + 1);
				square.remove(step);
			}
		}
	}
	
	// Struttura di un algoritmo ricorsivo generico
	void recursive (... , level) {
	// E -- sequenza di istruzioni che vengono eseguite sempre
	// Da usare solo in casi rari (es. Ruzzle)
	doAlways();
	// A
	if (condizione di terminazione) {
	doSomething;
	return;
	}
	// Potrebbe essere anche un while ()
	for () {
	// B
	generaNuovaSoluzioneParziale;
	if (filtro) { // C
	recursive (..., level + 1);
	}
	// D
	backtracking;
	}
	}
	
	 */

