package it.akt.esempio1;

public class ClasseA {
	public String pubblico = "Publico";
	protected String protetto = "Protetto";
	String packagePrivate = "Package-private (nessun modificatore)"; //default o package-private
	private String privato = "Privato";

	public void stampa() {
		System.out.println("Dalla ClasseA:");
		System.out.println(pubblico);
		System.out.println(protetto);
		System.out.println(packagePrivate);
		System.out.println(privato);
	}
}
