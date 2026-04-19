package basic;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");
        String s1 = request.getParameter("sub1");
        String s2 = request.getParameter("sub2");
        String s3 = request.getParameter("sub3");
        String s4 = request.getParameter("sub4");
        String s5 = request.getParameter("sub5");

        String message = "";
        boolean error = false;

        int m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0;

        try {
            m1 = Integer.parseInt(s1);
            m2 = Integer.parseInt(s2);
            m3 = Integer.parseInt(s3);
            m4 = Integer.parseInt(s4);
            m5 = Integer.parseInt(s5);

            if (m1 < 0 || m2 < 0 || m3 < 0 || m4 < 0 || m5 < 0) {
                error = true;
                message = "Marks must be positive";
            }
        } catch (Exception e) {
            error = true;
            message = "Invalid input";
        }

        if (!error) {
            double avg = (m1 + m2 + m3 + m4 + m5) / 5.0;
            String result = (m1 > 40 && m2 > 40 && m3 > 40 && m4 > 40 && m5 > 40) ? "Pass" : "Fail";

            request.setAttribute("rollno", rollno);
            request.setAttribute("name", name);
            request.setAttribute("m1", m1);
            request.setAttribute("m2", m2);
            request.setAttribute("m3", m3);
            request.setAttribute("m4", m4);
            request.setAttribute("m5", m5);
            request.setAttribute("avg", avg);
            request.setAttribute("result", result);
        } else {
            request.setAttribute("error", message);
        }

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}