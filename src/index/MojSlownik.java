package index;

public class MojSlownik {
	public MojSlownik() {
	}
	
	public MojSlownik(String polskieSlowo, String wloskieSlowo, Integer kategoria) {
		super();
		this.polskieSlowo = polskieSlowo;
		this.wloskieSlowo = wloskieSlowo;
		this.kategoria = kategoria;
		
	}

	public Integer kategoria;
	public Integer getKategoria() {
		return kategoria;
	}
	public void setKategoria(Integer kategoria) {
		this.kategoria = kategoria;
	}


	public String polskieSlowo;
	public String getPolskieSlowo() {
		return polskieSlowo;
	}
	public void setPolskieSlowo(String polskieSlowo) {
		this.polskieSlowo = polskieSlowo;
	}
	public String getWloskieSlowo() {
		return wloskieSlowo;
	}
	public void setWloskieSlowo(String wloskieSlowo) {
		this.wloskieSlowo = wloskieSlowo;
	}
	public String wloskieSlowo;
	@Override
	public String toString() {
		return  polskieSlowo +" "+ wloskieSlowo +" "+kategoria;
	}

}
