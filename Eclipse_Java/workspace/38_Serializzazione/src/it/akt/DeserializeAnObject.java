package it.akt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeAnObject {

	public static void main(String[] args) {

		List<Persona> lista = new ArrayList<Persona>();

		File file = new File("italia.ser");
		try (ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(file))) {

			// Persona person = (Persona) objInStr.readObject();
			// readObject ritorna Object - l'oggetto subisce BOXING quando vengono covertiti
			// dalla classe di appartenenza a Object e l'UNBOXING richiede un operazione di
			// cast

			// La deserializzazione di liste è un po' più complicata...
			try {
				lista = (List<Persona>) objInStr.readObject(); // anche col try catch è un cast che crea un warning!
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (Persona p : lista)
			System.out.println(p);
	}

}
