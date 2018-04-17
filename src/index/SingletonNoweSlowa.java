package index;

import java.util.ArrayList;
import java.util.List;

public class SingletonNoweSlowa {
	
		private static SingletonNoweSlowa  instance = null;
		private List<MojSlownik> mojSlowniki = null;
		
		
		
		private SingletonNoweSlowa (){}
		
		private static SingletonNoweSlowa  getInstance() {
			if(instance == null) {
				instance = new SingletonNoweSlowa ();
			}
			return instance;
		}
		private List<MojSlownik> getMojSlowniki() {
			return this.mojSlowniki;
		}
		
		private void setMojSlowniki(List<MojSlownik> mojSlowniki) {
			this.mojSlowniki = mojSlowniki;
		}
		
		private void addMojSlownik(MojSlownik mojSlownik) {
			List<MojSlownik> mojSlowniki= getMojSlowniki();
			if(mojSlowniki  == null) {
				mojSlowniki = new ArrayList<MojSlownik>();
			}
			mojSlowniki.add(mojSlownik);
			setMojSlowniki(mojSlowniki);
		}
		
		public static void aggiungiMojSlownik(String polskieSlowo, String wloskieSlowo, int kategoria) {
			SingletonNoweSlowa  instance = SingletonNoweSlowa .getInstance();
			instance.addMojSlownik(new MojSlownik(polskieSlowo, wloskieSlowo, kategoria));
		}
		
		public static List<MojSlownik> leggiMojSlowniki() {
			SingletonNoweSlowa  instance = SingletonNoweSlowa .getInstance();
			return instance.getMojSlowniki();
		}
		

}
