package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	Model m ; 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextArea txtCorrect;

    @FXML
    private TextArea txtUncorrect;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {

    	String word = txtWord.getText();
    	
    	word = word.toLowerCase();
    	
    	if(!word.matches("[a-z]*")){
    	
	    	Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Errore");
	    	alert.setHeaderText("Inserisci una parola con solo caratteri");
	    	//alert.setContentText("");
	    	alert.showAndWait();
	    	return ;
	    	
    	}
    	m.findAnagrams(word);
    	
    	List<String> aR = m.getAnagrammiR() ;
    	List<String> aW = m.getAnagrammiW() ;
    	
    	for (String s : aR){
    		txtCorrect.appendText(s+"\n");
    	}
    	
    	for (String s : aW){
    		txtUncorrect.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtWord.clear();
    	txtCorrect.clear();
    	txtUncorrect.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtUncorrect != null : "fx:id=\"txtUncorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }


	public void setModel(Model m2) {
		// TODO Auto-generated method stub
		this.m = m2 ; 
		
	}
}
