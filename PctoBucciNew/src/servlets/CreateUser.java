package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.User;
import database.DbConnection;

public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String paese = request.getParameter("paese");
		DbConnection dbConnection = new DbConnection();
		dbConnection.insert(nome, cognome, paese);
		dbConnection.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Useradd.jsp");
		dispatcher.forward(request, response);
	}

}
