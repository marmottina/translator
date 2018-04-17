package index;

public class Licz {
	public Licz(Integer ktorePytanie, Integer ileDobrze, Integer ileZle) {
		super();
		this.ktorePytanie = ktorePytanie;
		this.ileDobrze = ileDobrze;
		this.ileZle = ileZle;
	}
	public Integer ktorePytanie;
	public Integer ileDobrze;
	public Integer ileZle;
	public Integer getKtorePytanie() {
		return ktorePytanie;
	}
	public void setKtorePytanie(Integer ktorePytanie) {
		this.ktorePytanie = ktorePytanie;
	}
	public Integer getIleDobrze() {
		return ileDobrze;
	}
	public void setIleDobrze(Integer ileDobrze) {
		this.ileDobrze = ileDobrze;
	}
	public Integer getIleZle() {
		return ileZle;
	}
	public void setIleZle(Integer ileZle) {
		this.ileZle = ileZle;
	}
}
