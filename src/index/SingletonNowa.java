package index;


import java.util.ArrayList;
import java.util.List;

public class SingletonNowa {
	private static SingletonNowa instance = null;
	private List<Pracownik> pracownicy = null;
	
	
	
	private SingletonNowa(){}
	
	private static SingletonNowa getInstance() {
		if(instance == null) {
			instance = new SingletonNowa();
		}
		return instance;
	}
	private List<Pracownik> getPracownicy() {
		return this.pracownicy;
	}
	
	private void setPracownicy(List<Pracownik> pracownicy) {
		this.pracownicy = pracownicy;
	}
	
	private void addPracownik(Pracownik pracownik) {
		List<Pracownik> pracownicy= getPracownicy();
		if(pracownicy  == null) {
			pracownicy = new ArrayList<Pracownik>();
		}
		pracownicy.add(pracownik);
		setPracownicy(pracownicy);
	}
	
	public static void aggiungiPracownik(String imie, String nazwisko) {
		SingletonNowa instance = SingletonNowa.getInstance();
		instance.addPracownik(new Pracownik(imie, nazwisko));
	}
	
	public static List<Pracownik> leggiPracownicy() {
		SingletonNowa instance = SingletonNowa.getInstance();
		return instance.getPracownicy();
	}
	
}