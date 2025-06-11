package d_EsercizioBancomat;

import java.time.LocalDateTime;

public class Operazione {
	
	//Campi
	private LocalDateTime dataOra;
	private String tipo;
	private double importo;
	
	//Costruttore parametrico
	public Operazione(String tipo, double importo) {
		this.tipo = tipo;
		this.importo = importo;
	}
		
	//Metodi
		public LocalDateTime getDataOra() {
			return dataOra;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		public double getImporto() {
			return importo;
	}

		@Override
		public String toString() {
			return "Operazione [dataOra=" + dataOra + ", tipo=" + tipo + ", importo=" + importo + "]";
		}

}
