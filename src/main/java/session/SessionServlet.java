package session;


import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession(true);

        // Set session timeout = 60 seconds
        session.setMaxInactiveInterval(60);

        String username = request.getParameter("username");

        // Store username if first time
        if (session.getAttribute("user") == null && username != null) {
            session.setAttribute("user", username);
            session.setAttribute("count", 1);
        } else {
            int count = (int) session.getAttribute("count");
            session.setAttribute("count", count + 1);
        }

        String name = (String) session.getAttribute("user");
        int visitCount = (int) session.getAttribute("count");

        // Session info
        String sessionID = session.getId();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        // Output
        out.println("<html><body>");

        out.println("<h2>Session Tracking Information</h2>");

        if (name != null) {
            out.println("<h3>Welcome " + name + "</h3>");
        }

        out.println("<p><b>Session ID:</b> " + sessionID + "</p>");
        out.println("<p><b>Creation Time:</b> " + creationTime + "</p>");
        out.println("<p><b>Last Access Time:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Visit Count:</b> " + visitCount + "</p>");
        out.println("<p><b>Session Timeout:</b> 60 seconds</p>");

        out.println("<br><a href='SessionServlet'>Refresh</a>");
        out.println("<br><a href='index.html'>Start New Session</a>");

        out.println("</body></html>");
    }
}