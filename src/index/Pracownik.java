package index;

public class Pracownik {
	public Pracownik(String imie, String nazwisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	public String imie;
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String nazwisko;
	
	@Override
	public String toString() {
		return  imie +" "+ nazwisko;
	}

	
}
