package index;

public class BazaIdiomy {
	public BazaIdiomy(String idiom, String znaczenie) {
		super();
		this.idiom = idiom;
		this.znaczenie = znaczenie;
	}
	public BazaIdiomy() {
	}
	
	public String idiom;
	public String znaczenie;
	public String getIdiom() {
		return idiom;
	}
	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}
	public String getZnaczenie() {
		return znaczenie;
	}
	public void setZnaczenie(String znaczenie) {
		this.znaczenie = znaczenie;
	}
}
