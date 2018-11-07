package rs;

public class Proizvod {
private int id;
private String naziv;
private int cena;
private String kolicina;
private String slika;

public Proizvod(String slika) {
	super();
	this.slika = slika;
}
public String getSlika() {
	return slika;
}
public void setSlika(String slika) {
	this.slika = slika;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
public int getCena() {
	return cena;
}
public void setCena(int cena) {
	this.cena = cena;
}
public String getKolicina() {
	return kolicina;
}
public void setKolicina(String kolicina) {
	this.kolicina = kolicina;
}

@Override
public String toString() {
	return  "<td>"+naziv +"</td>" +"<td>" +  kolicina + "</td>"+ "<td>"+ cena+ "din" + "</td>"  ;
}
public Proizvod(int id, String naziv, int cena, String kolicina) {
	super();
	this.id = id;
	this.naziv = naziv;
	this.cena = cena;
	this.kolicina = kolicina;
}
public Proizvod() {
	super();
	// TODO Auto-generated constructor stub
}

}
