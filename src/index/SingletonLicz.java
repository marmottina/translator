package index;
import java.util.ArrayList;
import java.util.List;
public class SingletonLicz {
	private static SingletonLicz instance = null;
	private List<Licz> liczy = null;
	
	private SingletonLicz(){}
	
	private static SingletonLicz getInstance() {
		if(instance == null) {
			instance = new SingletonLicz();
		}
		return instance;
	}
	private List<Licz> getLiczy() {
		return this.liczy;
	}
	
	private void setLiczy(List<Licz> liczy) {
		this.liczy = liczy;
	}
	
	private void addLicz(Licz licz) {
		List<Licz> liczy= getLiczy();
		if(liczy  == null) {
			liczy = new ArrayList<Licz>();
		}
		liczy.add(licz);
		setLiczy(liczy);
	}
	
	public static void aggiungiLicz(Integer ktorePytanie, Integer ileDobrze, Integer ileZle) {
		SingletonLicz instance = SingletonLicz.getInstance();
		instance.addLicz(new Licz(ktorePytanie, ileDobrze, ileZle));
	}
	
	public static List<Licz> leggiLiczy() {
		SingletonLicz instance = SingletonLicz.getInstance();
		return instance.getLiczy();
	}
}
