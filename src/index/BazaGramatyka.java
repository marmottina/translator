package index;

public class BazaGramatyka {
	
	public BazaGramatyka() {
	}
	
	public BazaGramatyka(Integer kategoria, String czasownik, String ja, String ty, String on, String my, String wy,
			String oni) {
		super();
		this.kategoria = kategoria;
		this.czasownik = czasownik;
		this.ja = ja;
		this.ty = ty;
		this.on = on;
		this.my = my;
		this.wy = wy;
		this.oni = oni;
	}
	public Integer kategoria;
	public String czasownik;
	public String ja;
	public String ty;
	public String on;
	public String my;
	public String wy;
	public String oni;
	public Integer getKategoria() {
		return kategoria;
	}
	public void setKategoria(Integer kategoria) {
		this.kategoria = kategoria;
	}
	public String getCzasownik() {
		return czasownik;
	}
	public void setCzasownik(String czasownik) {
		this.czasownik = czasownik;
	}
	public String getJa() {
		return ja;
	}
	public void setJa(String ja) {
		this.ja = ja;
	}
	public String getTy() {
		return ty;
	}
	public void setTy(String ty) {
		this.ty = ty;
	}
	public String getOn() {
		return on;
	}
	public void setOn(String on) {
		this.on = on;
	}
	public String getMy() {
		return my;
	}
	public void setMy(String my) {
		this.my = my;
	}
	public String getWy() {
		return wy;
	}
	public void setWy(String wy) {
		this.wy = wy;
	}
	public String getOni() {
		return oni;
	}
	public void setOni(String oni) {
		this.oni = oni;
	}
}
