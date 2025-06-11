package it.akt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.akt.model.Spesa;

@Service
public class SpesaService {
	//campo contenente la lista delle spese inserite
	private List<Spesa> listaSpese = new ArrayList<>();

	//metodi:
	//aggiunta di una spesa alla List
	public void aggiungiSpesa(Spesa spesa) {
		listaSpese.add(spesa);
	}
	
	//lettura di tutta la List
	public List<Spesa> ritornaListaSpese(){
		return listaSpese;
	}
}
