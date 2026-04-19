package cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        Cookie[] cookies = request.getCookies();

        String name = null;
        int count = 0;

        // Read existing cookies
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

        // First visit
        if (name == null && username != null) {
            name = username;
            count = 1;
        } else {
            count++;
        }

        // Create cookies
        Cookie nameCookie = new Cookie("user", name);
        Cookie countCookie = new Cookie("visit", String.valueOf(count));

        // Set expiry time (e.g., 20 seconds for demo)
        nameCookie.setMaxAge(20);
        countCookie.setMaxAge(20);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output HTML
        out.println("<html><body>");

        out.println("<h2 style='color:blue;'>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + count + " times</h3>");

        // Display cookies
        out.println("<h3>Cookie List:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>");
                out.println("Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br>");
                out.println("Max Age: " + c.getMaxAge() + "<br>");
                out.println("----------------------</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
