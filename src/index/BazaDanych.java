package index;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BazaDanych {
	public int dopiszDoTabeli(MojSlownik dopisz){
		Connection connection = null;
		PreparedStatement statement = null;
		int result = -1;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("insert into Slowa (slowoIT, slowoPL, kategoria) values (?,?,?)");
			statement.setString(1, dopisz.getWloskieSlowo());
			statement.setString(2, dopisz.getPolskieSlowo());
			statement.setInt(3, dopisz.getKategoria());
			result = statement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Integer> idslowa(Integer kategoria) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idslowa = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			if(kategoria == null) {
				statement = connection.prepareStatement("select idslowa from slowa");
			} else {
				statement = connection.prepareStatement("select idslowa from slowa where kategoria = ?");
				statement.setInt(1, kategoria);
			}
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idslowa.add(resultSet.getInt("idslowa"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idslowa;
	}

	
	public MojSlownik wylosujSlowo(Integer kategoria){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		MojSlownik resultWylosuj = null;
		
		List<Integer> list = idslowa(kategoria);
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from slowa where idslowa = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultWylosuj = mapper(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultWylosuj;
	}
	
	public List<MojSlownik> slowaKategoria(Integer kategoria){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<MojSlownik> resultWylosuj = new ArrayList<MojSlownik>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from slowa where kategoria = ?  order by slowoPL ASC");
			statement.setInt(1, kategoria);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				resultWylosuj.add(mapper(resultSet));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultWylosuj;
	}
	
	
	public List<Integer> idcwiczenia(Integer kategoria) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idcwiczenia = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			if(kategoria == null) {
				statement = connection.prepareStatement("select idcwiczenia from cwiczenia");
			} else {
				statement = connection.prepareStatement("select idcwiczenia from cwiczenia where kategoria = ?");
				statement.setInt(1, kategoria);

			}
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idcwiczenia.add(resultSet.getInt("idcwiczenia"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idcwiczenia;
	}
	
	public BazaCwiczen wylosujZdanie(Integer kategoria){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaCwiczen resultCwiczenia = null;
		
		List<Integer> list = idcwiczenia(kategoria);
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from cwiczenia where idcwiczenia = ? and kategoria= ?");
			statement.setInt(1, a);
			statement.setInt(2, kategoria);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultCwiczenia = mapper2(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultCwiczenia;
	}
	
	public List<Integer> idquiz() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idquiz = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idquiz from quiz");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idquiz.add(resultSet.getInt("idquiz"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idquiz;
	}
	
	public BazaQuiz wylosujQuiz(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaQuiz resultQuiz = null;
		
		List<Integer> list = idquiz();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from quiz where idquiz = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultQuiz = mapper3(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultQuiz;
	}
	
	public List<Integer> idwybor() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idwybor = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idwybor from wybor");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idwybor.add(resultSet.getInt("idwybor"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idwybor;
	}
	
	public BazaWybor wylosujWybor(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaWybor resultWybor = null;
		
		List<Integer> list = idwybor();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from wybor where idwybor = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultWybor = mapper4(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultWybor;
	}
	
	public List<Integer> idteksty() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idteksty = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idteksty from teksty");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idteksty.add(resultSet.getInt("idteksty"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idteksty;
	}
	
	public BazaTeksty wylosujTeksty(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaTeksty resultTeksty = null;
		
		List<Integer> list = idteksty();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from teksty where idteksty = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultTeksty = mapper5(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultTeksty;
	}
	
	public List<Integer> idczytanie() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idczytanie = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idczytanie from czytanie");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idczytanie.add(resultSet.getInt("idczytanie"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idczytanie;
	}
	
	public BazaCzytanie wylosujCzytanie(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaCzytanie resultCzytanie = null;
		
		List<Integer> list = idczytanie();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from czytanie where idczytanie = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultCzytanie = mapper6(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultCzytanie;
	}
	
	
	public List<Integer> idprawda() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idprawda = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idprawda from prawda");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idprawda.add(resultSet.getInt("idprawda"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idprawda;
	}
	
	public BazaPrawda wylosujPrawda(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaPrawda resultPrawda = null;
		
		List<Integer> list = idprawda();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from prawda where idprawda = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultPrawda = mapper7(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultPrawda;
	}
	
	
	public List<Integer> ididiomy() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> ididiomy = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select ididiomy from idiomy");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				ididiomy.add(resultSet.getInt("ididiomy"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return ididiomy;
	}
	
	public List<BazaIdiomy> Idiomy(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BazaIdiomy> resultIdiomy = new ArrayList<BazaIdiomy>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from idiomy");
		
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				resultIdiomy.add(mapper8(resultSet));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultIdiomy;
	}
	
	
	
	public List<Integer> idgramatyka(Integer kategoria) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idgramatyka = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			if(kategoria == null) {
				statement = connection.prepareStatement("select idgramatyka from gramatyka");
			} else {
				statement = connection.prepareStatement("select idgramatyka from gramatyka where kategoria = ?");
				statement.setInt(1, kategoria);

			}
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idgramatyka.add(resultSet.getInt("idgramatyka"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idgramatyka;
	}
	
	public List<BazaGramatyka> Gramatyka(Integer kategoria){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BazaGramatyka> resultGramatyka = new ArrayList<BazaGramatyka>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from gramatyka where kategoria= ?");
			statement.setInt(1, kategoria);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				resultGramatyka.add(mapper9(resultSet));
			}
		
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultGramatyka;
	}
	
	
	public List<Integer> idmapy() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Integer> idmapy = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			
			statement = connection.prepareStatement("select idmapy from mapy");
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				idmapy.add(resultSet.getInt("idmapy"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return idmapy;
	}
	
	public BazaMapy wylosujMapy(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BazaMapy resultMapy = null;
		
		List<Integer> list = idmapy();
		
		Random rand = new Random();
		int idx = rand.nextInt(list.size());
		int a = list.get(idx);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kurs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "riccio123");
			statement = connection.prepareStatement("select * from mapy where idmapy = ?");
			statement.setInt(1, a);
			resultSet = statement.executeQuery();
			resultSet.next();
			resultMapy = mapper10(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				connection.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return resultMapy;
	}
	
	private MojSlownik mapper(ResultSet resultSet){
		
		MojSlownik result = new MojSlownik();
		try {
			result.setPolskieSlowo(resultSet.getString("slowoPL"));
			result.setWloskieSlowo(resultSet.getString("slowoIT"));
			result.setKategoria(resultSet.getInt("kategoria"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	private BazaCwiczen mapper2(ResultSet resultSet){
			
			BazaCwiczen resultCwiczenia = new BazaCwiczen();
			try {
				resultCwiczenia.setZdanie(resultSet.getString("zdanie"));
				resultCwiczenia.setOdpowiedz(resultSet.getString("odpowiedz"));
				resultCwiczenia.setKategoria(resultSet.getInt("kategoria"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return resultCwiczenia;
			
		}
	private BazaQuiz mapper3(ResultSet resultSet){
		
		BazaQuiz resultQuiz = new BazaQuiz();
		try {
			resultQuiz.setPytanie(resultSet.getString("pytanie"));
			resultQuiz.setOdpA(resultSet.getString("odpA"));
			resultQuiz.setFlagaA(resultSet.getBoolean("flagaA"));
			resultQuiz.setOdpB(resultSet.getString("odpB"));
			resultQuiz.setFlagaB(resultSet.getBoolean("flagaB"));
			resultQuiz.setOdpC(resultSet.getString("odpC"));
			resultQuiz.setFlagaC(resultSet.getBoolean("flagaC"));
			resultQuiz.setOdpD(resultSet.getString("odpD"));
			resultQuiz.setFlagaD(resultSet.getBoolean("flagaD"));
			resultQuiz.setOdpE(resultSet.getString("odpE"));
			resultQuiz.setFlagaE(resultSet.getBoolean("flagaE"));
			resultQuiz.setOdpF(resultSet.getString("odpF"));
			resultQuiz.setFlagaF(resultSet.getBoolean("flagaF"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultQuiz;
		
	}
	
private BazaWybor mapper4(ResultSet resultSet){
		
		BazaWybor resultWybor = new BazaWybor();
		try {
			resultWybor.setCzescA(resultSet.getString("czescA"));
			resultWybor.setCzescB(resultSet.getString("czescB"));
			resultWybor.setLuka1(resultSet.getString("luka1"));
			resultWybor.setFlaga1(resultSet.getBoolean("flaga1"));
			resultWybor.setLuka2(resultSet.getString("luka2"));
			resultWybor.setFlaga2(resultSet.getBoolean("flaga2"));
			resultWybor.setLuka3(resultSet.getString("luka3"));
			resultWybor.setFlaga3(resultSet.getBoolean("flaga3"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultWybor;
		
	}

private BazaTeksty mapper5(ResultSet resultSet){
	
	BazaTeksty resultTeksty = new BazaTeksty();
	try {
		resultTeksty.setTekst(resultSet.getString("tekst"));
		resultTeksty.setTekstA(resultSet.getString("tekstA"));
		resultTeksty.setTekstB(resultSet.getString("tekstB"));
		resultTeksty.setTekstC(resultSet.getString("tekstC"));
		resultTeksty.setTekstD(resultSet.getString("tekstD"));
		resultTeksty.setTekstE(resultSet.getString("tekstE"));
		resultTeksty.setPole1(resultSet.getString("pole1"));
		resultTeksty.setPole2(resultSet.getString("pole2"));
		resultTeksty.setPole3(resultSet.getString("pole3"));
		resultTeksty.setPole4(resultSet.getString("pole4"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultTeksty;
	
}

private BazaCzytanie mapper6(ResultSet resultSet){
	
	BazaCzytanie resultCzytanie = new BazaCzytanie();
	try {
		resultCzytanie.setTekst(resultSet.getString("tekst"));
		resultCzytanie.setPytanieA(resultSet.getString("pytanieA"));
		resultCzytanie.setOpcja1A(resultSet.getString("opcja1A"));
		resultCzytanie.setFlaga1A(resultSet.getBoolean("flaga1A"));
		resultCzytanie.setOpcja2A(resultSet.getString("opcja2A"));
		resultCzytanie.setFlaga2A(resultSet.getBoolean("flaga2A"));
		resultCzytanie.setOpcja3A(resultSet.getString("opcja3A"));
		resultCzytanie.setFlaga3A(resultSet.getBoolean("flaga3A"));
		resultCzytanie.setPytanieB(resultSet.getString("pytanieB"));
		resultCzytanie.setOpcja1B(resultSet.getString("opcja1B"));
		resultCzytanie.setFlaga1B(resultSet.getBoolean("flaga1B"));
		resultCzytanie.setOpcja2B(resultSet.getString("opcja2B"));
		resultCzytanie.setFlaga2B(resultSet.getBoolean("flaga2B"));
		resultCzytanie.setOpcja3B(resultSet.getString("opcja3B"));
		resultCzytanie.setFlaga3B(resultSet.getBoolean("flaga3B"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultCzytanie;
	
}

private BazaPrawda mapper7(ResultSet resultSet){
	
	BazaPrawda resultPrawda = new BazaPrawda();
	try {
		resultPrawda.setTekst(resultSet.getString("tekst"));
		resultPrawda.setPytanieA(resultSet.getString("pytanieA"));
		resultPrawda.setPrawdaA(resultSet.getBoolean("prawdaA"));
		resultPrawda.setFalszA(resultSet.getBoolean("falszA"));
		resultPrawda.setPytanieB(resultSet.getString("pytanieB"));
		resultPrawda.setPrawdaB(resultSet.getBoolean("prawdaB"));
		resultPrawda.setFalszB(resultSet.getBoolean("falszB"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultPrawda;
	
}

private BazaIdiomy mapper8(ResultSet resultSet){
	
	BazaIdiomy resultIdiomy = new BazaIdiomy();
	try {
		resultIdiomy.setIdiom(resultSet.getString("idiom"));
		resultIdiomy.setZnaczenie(resultSet.getString("znaczenie"));
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultIdiomy;
	
}

private BazaGramatyka mapper9(ResultSet resultSet){
	
	BazaGramatyka resultGramatyka = new BazaGramatyka();
	try {
		resultGramatyka.setKategoria(resultSet.getInt("kategoria"));
		resultGramatyka.setCzasownik(resultSet.getString("czasownik"));
		resultGramatyka.setJa(resultSet.getString("ja"));
		resultGramatyka.setTy(resultSet.getString("ty"));
		resultGramatyka.setOn(resultSet.getString("on"));
		resultGramatyka.setMy(resultSet.getString("my"));
		resultGramatyka.setWy(resultSet.getString("wy"));
		resultGramatyka.setOni(resultSet.getString("oni"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultGramatyka;
	
}

private BazaMapy mapper10(ResultSet resultSet){
	
	BazaMapy resultMapy = new BazaMapy();
	try {
		resultMapy.setNazwa(resultSet.getString("nazwa"));
		resultMapy.setTekst(resultSet.getString("tekst"));
		resultMapy.setPytanie(resultSet.getString("pytanie"));
		resultMapy.setOdpA(resultSet.getString("odpA"));
		resultMapy.setFlagaA(resultSet.getBoolean("flagaA"));
		resultMapy.setOdpB(resultSet.getString("odpB"));
		resultMapy.setFlagaB(resultSet.getBoolean("flagaB"));
		resultMapy.setOdpC(resultSet.getString("odpC"));
		resultMapy.setFlagaC(resultSet.getBoolean("flagaC"));
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return resultMapy;
	
}
}

