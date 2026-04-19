package basics;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieVisitServlet")
public class CookieVisitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        Cookie[] cookies = request.getCookies();

        String name = null;
        int count = 0;

        // Read cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    name = c.getValue();
                }
                if (c.getName().equals("visit")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        // If first time
        if (name == null && username != null) {
            name = username;
            count = 1;
        } else {
            count++;
        }

        // Create cookies
        Cookie nameCookie = new Cookie("user", name);
        Cookie countCookie = new Cookie("visit", String.valueOf(count));

        // Expiry time (30 seconds for demo)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2 style='color:blue;'>Welcome back " + name + "!</h2>");
        out.println("<h3 style='color:green;'>You have visited this page " + count + " times</h3>");

        // Show all cookies
        out.println("<h3>Cookie List:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>");
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br>");
                out.println("Max Age: " + c.getMaxAge() + "<br>");
                out.println("--------------------</p>");
            }
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
