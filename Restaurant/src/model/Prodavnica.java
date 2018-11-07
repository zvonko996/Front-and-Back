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
import rs.Proizvod;


@WebServlet("/Prodavnica")
public class Prodavnica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Prodavnica() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String akcija = request.getParameter("action");
		if(akcija != null && akcija.trim().length()>0)
		{
			if(akcija.equals("korpa"))
			{
				String id = request.getParameter("id");
				String naziv = request.getParameter("naziv");
				String cena = request.getParameter("cena");
				if(id != null && id.trim().length()>0 && naziv != null && naziv.trim().length()>0 && cena != null && cena.trim().length()>0)
				{
					try {
						int i = Integer.parseInt(id);
						DAO dao = new DAO();
						
						
						
						ArrayList<Proizvod> la = dao.selectProizvod(i);
						HttpSession sesija  = request.getSession();
						request.setAttribute("la", la);
						request.getRequestDispatcher("prikaz.jsp").forward(request, response);
						
						}
					
					catch(Exception e)
					{
						request.setAttribute("msg", "Cena mora biti ceo broj!!!");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
				else 
				{
					request.setAttribute("msg", "Morate popuniti sva polja!!!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if(akcija.equals("dodaj"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				DAO dao = new DAO();
				HttpSession sesija  = request.getSession();
				ArrayList<Proizvod> lk = (ArrayList<Proizvod>) sesija.getAttribute("lk");
				
				if(lk == null)
				
					lk = new ArrayList<Proizvod>();
					Proizvod a = dao.getProizvod(id);
					lk.add(a);
					sesija.setAttribute("lk", lk);
					request.getRequestDispatcher("proizvodi.jsp").forward(request, response);
				
			}
			else if(akcija.equals("potvrdi"))
			{
				
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
