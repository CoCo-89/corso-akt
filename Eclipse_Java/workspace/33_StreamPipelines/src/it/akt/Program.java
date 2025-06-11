package it.akt;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		List<String> nomi = new ArrayList<String>(Arrays.asList("Alessandro", "Alessio", "Davide"));
		
		nomi.add("Federico");
		nomi.add(0, "Francesco");
		
		nomi.add(1, "Edoardo");
		System.out.println(nomi.get(3));
	
		System.out.println(nomi.toString());
		
		String nom;	//Estraggo il primo elemento che inzia per F
		for (String nome : nomi) {
			if (nome.startsWith("F")) {
				System.out.println(nom = nome);
				break;
			}
		}
		
		System.out.println("============Lambda===========");
		String nome = nomi.stream()								// Operazione iniziale
		                  .filter(n -> n.startsWith("F"))       // Pipeline (1° metodo)
		                  .findFirst()                          // Pipeline (2° metodo)
		                  .get();                               // Operazione terminale
		
		//Voglio estrarre il primo in ordine alfabetico ad iniziare con F
		String nome2 = nomi.stream()
				           .sorted((n1, n2) -> n1.compareTo(n2)) //Se scambio n1 con n2 nel compareTo, cambio la sequenza di orindamento da ascendente in discendente
                           .filter(n -> n.startsWith("F"))
                           .findFirst()
                           .get(); 
		
		System.out.println(nome);
		System.out.println(nome2);
		
		//Mi serve per catturare in una nuova lista tutti gli elementi che corrispondono alla ricerca
		List<String> nomiCheTerminanoConLaO = nomi.stream()
				                                  .filter(n -> n.endsWith("o"))
				                                  .collect(Collectors.toList());//trasforma tutti gli elementi in una lista
		
		System.out.println(nomiCheTerminanoConLaO);

		System.out.println("===============ifPresent()===============");
		nomi.stream()
            .filter(n -> n.startsWith("z")) 
            .findFirst() 
            .ifPresent(System.out::println);
		System.out.println("===============ifPresent()===============");
		
		Optional<String> nome3 = nomi.stream()
				                     .filter(n -> n.startsWith("F")) 
                                     .findFirst();
		
		if (nome3.isPresent()) {
			System.out.println(nome3.get());
		}
		
		//Uso della classe Stream
		Stream
			.of("Tanita", "Stefano", "Simone", "Patrizio", "Maria", "Amelio", "Jason", "Riccardo")//collezione immutabile
			.sorted((nomeA, nomeB) -> nomeB.compareTo(nomeA))
			.filter(nomeX -> nomeX.length() <= 6)
			.collect(Collectors.toList())
				.stream()
				.filter(nomeY -> !nomeY.endsWith("o"))
				.forEach(System.out::println);
				//.forEach(n -> System.out.print(n + " "));  //per stampare uno a fianco all'altro
    /*
     * NOTA: Method Reference (::)
     * - È una scorciatoia per riferirsi a metodi esistenti senza invocarli direttamente.
     * - Esempio: System.out::println è equivalente a n -> System.out.println(n)
     *
     * Tipi comuni di method reference:
     * - Classe::metodoStatico         -> Math::sqrt
     * - oggetto::metodoIstanza        -> System.out::println
     * - Classe::metodoIstanza         -> String::toLowerCase (quando usato su oggetti)
     */

	}

}