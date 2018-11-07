package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import rs.DAO;
import rs.Korisnik;


@WebServlet("/KorisnikLog")
public class KorisnikLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KorisnikLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String akcija = request.getParameter("akcija");
	if(akcija.equals("logout"))
	{
		response.sendRedirect("prijava.jsp");
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String akcija = request.getParameter("akcija");
		DAO dao = new DAO();
		if (akcija != null) {
			if (akcija.equals("Prijava")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				if (username != null && username.length() > 0 && password != null && password.length() > 0) {
					Korisnik k = dao.login(username, password);
					if(k!=null)
					{
						HttpSession sesija = request.getSession();
						sesija.setAttribute("ulogovan", k);
						request.getRequestDispatcher("pocetna.jsp").forward(request, response);
					} else {
						request.setAttribute("msg", "Pogresno ste uneli podatke!");
						request.getRequestDispatcher("prijava.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("msg", "Morate popuniti sva polja!");
					request.getRequestDispatcher("prijava.jsp").forward(request, response);
				}
			}
			else if(akcija.equals("Registracija"))
			{
				response.sendRedirect("registracija.jsp");
			}
			else if(akcija.equals("Registrujte se"))
			{
				String ime = request.getParameter("ime");
				String prezime = request.getParameter("prezime");
				String adresa = request.getParameter("adresa");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if(ime != null && ime.trim().length()>0 && prezime != null && prezime.trim().length()>0 && 
						adresa != null && adresa.trim().length()>0 && email != null && email.trim().length()>0 &&
								username != null && username.trim().length()>0 && password != null && password.trim().length()>0 )
				{
					DAO da = new DAO();
					dao.insertKorisnik(ime,prezime,adresa,email,username,password);
					
					ArrayList<Korisnik> la = da.selectKorisnik();
					
					HttpSession sesija = request.getSession();
					System.out.println(la.size());
					sesija.setAttribute("la", la);
					request.getRequestDispatcher("prijava.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Morate popuniti sva polja!!!");
					request.getRequestDispatcher("registracija.jsp").forward(request, response);
				}
				
			}
		}

	}
}
