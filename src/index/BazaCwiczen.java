package index;

public class BazaCwiczen {
	public BazaCwiczen() {
	}
	
		public BazaCwiczen(int idcwiczenia, String zdanie, String odpowiedz, int kategoria) {
		super();
		this.idcwiczenia = idcwiczenia;
		this.zdanie = zdanie;
		this.odpowiedz = odpowiedz;
		this.kategoria = kategoria;
	}
		public int idcwiczenia;
		public int getIdcwiczenia() {
			return idcwiczenia;
		}
		public void setIdcwiczenia(int idcwiczenia) {
			this.idcwiczenia = idcwiczenia;
		}
		public String getZdanie() {
			return zdanie;
		}
		public void setZdanie(String zdanie) {
			this.zdanie = zdanie;
		}
		public String getOdpowiedz() {
			return odpowiedz;
		}
		public void setOdpowiedz(String odpowiedz) {
			this.odpowiedz = odpowiedz;
		}
		public int getKategoria() {
			return kategoria;
		}
		public void setKategoria(int kategoria) {
			this.kategoria = kategoria;
		}
		public String zdanie;
		public String odpowiedz;
		public int kategoria;
		
	

}
