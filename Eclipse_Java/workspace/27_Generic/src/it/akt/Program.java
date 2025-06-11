package it.akt;

public class Program {

	public static void main(String[] args) {
		// GENERIC
		//serve per rappresentare un contenitore di oggetti misto

		//1° step: vedi classe Scatola
	
		Scatola scatola = new Scatola();
		scatola.contenuto="Ciao";
		scatola.contenuto=true;
		scatola.contenuto=1;	
		//1 in questo caso diventa un oggetto invece di rimanere di tipo 
		//int perchè contenitore creato come Object
		
		//System.out.println(5 + scatola.contenuto); 1 è un oggetto!
		Object[] arrayNonOmogeneo = new Object[6];
		arrayNonOmogeneo[0] = 123;
		arrayNonOmogeneo[1] = 4.55;
		arrayNonOmogeneo[2] = scatola.contenuto;
		arrayNonOmogeneo[3] = "Mario";
		
		//2° step: rendiamo la scatola una scatola generica: classe ScatolaGenerica
		ScatolaGenerica<Integer> scatolaDiInteri = new ScatolaGenerica<Integer>();
		ScatolaGenerica<Integer> scatolaDiInteri1 = new ScatolaGenerica<Integer>(22	, "ciao", 1);
		
		ScatolaGenerica<String> scatolaDiStringhe = new ScatolaGenerica<String>("Mario", "Ciaociao"	, 10);
		//Quando istanzio una classe con Generic, devo SPACIALIZZARE il tipo di dato che verrà inserito al posto del placeholder.  Per specializzare la classe DEVO usare tipi DERIVATI/REFERENCE
	
	
		//3° step posso estendere una classe con generic: vedi ScatolettaBatterie
		
		ScatolettaBatterie scatolettaBatterie = new ScatolettaBatterie();
		scatolettaBatterie.setContenuto(new Batteria());
		scatolettaBatterie.getContenuto();
	
	
		//4° step posso avere più tipi generici nella stessa classe: ScatolaDoppia
		ScatolaDoppia<String, Integer> scatolaDoppia = new ScatolaDoppia<String, Integer>();
		scatolaDoppia.primoScomparto = "Lazio";
		scatolaDoppia.secondoScomparto = 5632713;
		
		
		//5° step posso limitare i tipi di dato dichiarti nel generic: ScatoladiNumeri
		ScatolaDiNumeri<Integer> scInt = new ScatolaDiNumeri<Integer>();
		ScatolaDiNumeri<Float> scFl = new ScatolaDiNumeri<>();
		ScatolaDiNumeri<Double> scDb = new ScatolaDiNumeri<>();
		//ScatolaDiNumeri<String> scStr = new ScatolaDiNumeri<String>();
		//ScatolaDiNumeri<Batteria> scBatt = new ScatolaDiNumeri<Batteria>();
	
	
	
	
	}

}
