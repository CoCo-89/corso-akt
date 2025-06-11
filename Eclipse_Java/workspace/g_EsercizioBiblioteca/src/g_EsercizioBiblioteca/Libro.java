package g_EsercizioBiblioteca;

public class Libro {
	
	private String nome;
	private String autore;
	private int annoPubblicazione;
	
	public Libro(String nome, String autore, int annoPubblicazione) {
		this.nome = nome;
		this.autore = autore;
		this.annoPubblicazione = annoPubblicazione;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome() {
			this.nome = nome;
		}
		
		public String getAutore() {
			return autore;
		}
		
		public void setAutore() {
			this.autore = autore;
		}
		
		public int getAnnoPubblicazione() {
			return annoPubblicazione;
		}
		public void setAnnoPubblicazione() {
			this.annoPubblicazione = annoPubblicazione;
		}
	}
