package rs;

public class Korisnik {
private int id;
private String ime, prezime, adresa, email, username,password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public String getAdresa() {
	return adresa;
}
public void setAdresa(String adresa) {
	this.adresa = adresa;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", email=" + email
			+ ", username=" + username + ", password=" + password + "]";
}
public Korisnik(int id, String ime, String prezime, String adresa, String email, String username, String password) {
	super();
	this.id = id;
	this.ime = ime;
	this.prezime = prezime;
	this.adresa = adresa;
	this.email = email;
	this.username = username;
	this.password = password;
}
public Korisnik() {
	super();
	// TODO Auto-generated constructor stub
}


}
