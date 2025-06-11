package it.akt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import it.akt.model.Fumetto;

@Service
public class FumettoService {
	
	private List<Fumetto> fumettiList = new ArrayList<>(Arrays.asList(
    		new Fumetto(1L, "Naruto", "Planet Manga", 01),
			new Fumetto(2L, "Full Metal Alchemist", "Planet Manga", 01),
			new Fumetto(3L, "My Hero Academia", "Edzioni Star Comics", 01)));
	
	public List<Fumetto> getFumettiList(){
		return fumettiList;
	}
	
	public boolean createFumetto(Fumetto fumetto) {
		if( !fumettiList.stream().anyMatch(p->p.getId() == fumetto.getId()) ) {
			fumettiList.add(fumetto);
			return true;
		} else {
			return false;
		}
	}

}
