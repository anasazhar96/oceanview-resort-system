package com.oceanview.controller;

import com.oceanview.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();

        if(userDAO.validateUser(username, password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("jsp/dashboard.jsp");

        } else {

            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);

        }
    }
}