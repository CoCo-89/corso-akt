//RIFERIMENTO: Java - Maggi ed 2024 - pagg. 376-379

package it.akt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeAnObject {

	public static void main(String[] args) {

		//Iniziamo creando una classe Persona serializzabile
		
		//Posso serializzare sia oggetti che Strutture complesse come List, Set e Map
		
		
// 		Serializzazione di oggetti		
//		Persona person = new Persona ("Mario", "Rossi", 26 );
		
//		Serializzazione di liste		
		List<Persona> lista = new ArrayList<>();
		
		lista.add(new Persona("Dino", "Zoff", 40));
		lista.add(new Persona("Antonio", "Cabrini", 28));
		lista.add(new Persona("Fulvio", "Collovati", 25));
		lista.add(new Persona("Gaetano", "Scirea", 30));
		lista.add(new Persona("Claudio", "Gentile", 30));
		lista.add(new Persona("Giuseppe", "Bergomi", 19));
		lista.add(new Persona("Gabriele", "Oriali", 30));
		lista.add(new Persona("Marco", "Tardelli", 28));
		lista.add(new Persona("Bruno", "Conti", 27));
		lista.add(new Persona("Francesco", "Graziani", 30));
		lista.add(new Persona("Paolo", "Rossi", 26));
			
		
		File file = new File ("italia.ser");
		try (ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream(file))){
			//ObjectOutputStream questa classe permette di serializzare l'oggetto
			
			//objOutStr.writeObject(person);  	//serializzazione di un oggetto semplice
			
			objOutStr.writeObject(lista);		//serializzazione di una lista

			
			System.out.println("object serialized in " + file.getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}

}
