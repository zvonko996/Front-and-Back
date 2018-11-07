package rs;

//vazni importi 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
public class DAO {
   private DataSource ds;

//DEFINICIJA KONEKCIONIH STRINGOVA
   	private static String SelectKorisnik = "select * from korisnik";
   	private static String Ispitivanje = "select * from korisnik where username = ?";
	private static String LOGIN = "SELECT  korisnik.* from korisnik where username=? and password=?";
	private static String InsertKorisnik = "INSERT INTO korisnik(ime, prezime, adresa, email, username, password) VALUES (?,?,?,?,?,?)";

	private static String SelectProizvod = "SELECT * from  proizvod where id = ?";
	private static String SelectProizvodAll = "SELECT * from proizvod ";
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public DAO(){
	try {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) { 
		} 
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	// DEFINICIJA METODE 
	public Korisnik login(String username, String password){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Korisnik> lo = new ArrayList<Korisnik>();
		Korisnik korisnik = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(LOGIN);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				korisnik = new Korisnik();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				
				korisnik.setUsername(rs.getString("username"));
				korisnik.setPassword(rs.getString("password"));
				korisnik.setIme(rs.getString("ime"));
				korisnik.setPrezime(rs.getString("prezime"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(korisnik);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
			return korisnik;
		
	}

	
	public void  insertKorisnik(String ime,String prezime,String adresa, String email,String username,String password){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(InsertKorisnik);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1,ime);
			pstm.setString(2,prezime);
			pstm.setString(3,adresa);
			pstm.setString(4,email);
			pstm.setString(5,username);
			pstm.setString(6,password);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
	}
	// DEFINICIJA OSTALIH METODA ... 
	public ArrayList<Korisnik> selectKorisnik(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Korisnik> lo = new ArrayList<Korisnik>();
		Korisnik korisnik = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SelectKorisnik);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				korisnik = new Korisnik();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				korisnik.setId(rs.getInt("id"));
				korisnik.setIme(rs.getString("ime"));
				korisnik.setPrezime(rs.getString("prezime"));
				korisnik.setAdresa(rs.getString("adresa"));
				korisnik.setEmail(rs.getString("email"));
				korisnik.setUsername(rs.getString("username"));
				korisnik.setPassword(rs.getString("password"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(korisnik);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lo; 
	}
	
	public ArrayList<Proizvod> selectProizvod(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
		Proizvod proizvod = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SelectProizvod);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1, id);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				proizvod = new Proizvod();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				proizvod.setId(rs.getInt("id"));
				proizvod.setNaziv(rs.getString("naziv"));
				proizvod.setCena(rs.getInt("cena"));
				proizvod.setKolicina(rs.getString("kolicina"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(proizvod);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lo; 
	}
	
	public boolean IspitivanjeUser(String username)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				boolean ima = false;
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(Ispitivanje);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, username);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				ima = true;
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return true;
	}
	public ArrayList<Proizvod> selectAllProizvod(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Proizvod> lo = new ArrayList<Proizvod>();
		Proizvod proizvod = null;
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SelectProizvodAll);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				proizvod = new Proizvod();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				proizvod.setId(rs.getInt("id"));
				proizvod.setNaziv(rs.getString("naziv"));
				proizvod.setCena(rs.getInt("cena"));
				proizvod.setKolicina(rs.getString("kolicina"));
				proizvod.setSlika(rs.getString("slika"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(proizvod);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return lo; 
	}
	
	public Proizvod  getProizvod(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			Proizvod proizvod = null;
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SelectProizvod);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setInt(1,id);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				proizvod = new Proizvod();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				proizvod.setId(rs.getInt("id"));
				proizvod.setNaziv(rs.getString("naziv"));
				proizvod.setCena(rs.getInt("cena"));
				proizvod.setKolicina(rs.getString("kolicina"));
				proizvod.setSlika(rs.getString("slika"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return proizvod;
	}
	
}
