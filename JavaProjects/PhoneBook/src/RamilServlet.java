import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "RamilServlet")
public class RamilServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        request.setCharacterEncoding("UTF-8");

        String fio = request.getParameter("fio");
        String pnumber = request.getParameter("pnumber");
        String email = request.getParameter("email");
        String bday = request.getParameter("bday");
        String job = request.getParameter("job");
        String comment = request.getParameter("comment");


        if (request.getSession().getAttribute("list") == null) {
            ArrayList<Human> list = new ArrayList<Human>();
            list.add(new Human(fio, pnumber, email, bday, job, comment));
            Collections.sort(list, new Comparator<Human>() {
                public int compare(Human h1, Human h2) {
                    return h1.getFIO().compareTo(h2.getFIO());
                }
            });
            httpSession.setAttribute("list", list);
        } else {
            ArrayList<Human> list = (ArrayList<Human>) request.getSession().getAttribute("list");
            list.add(new Human(fio, pnumber, email, bday, job, comment));
            Collections.sort(list, new Comparator<Human>() {
                public int compare(Human h1, Human h2) {
                    return h1.getFIO().compareTo(h2.getFIO());
                }
            });
            httpSession.setAttribute("list", list);
        }

        response.sendRedirect("/ramil-super-puper-servlet-build-572");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        ArrayList<Human> list = (ArrayList<Human>) request.getSession().getAttribute("list");

        if ((request.getParameter("fio") != null) && (list != null)) {
            for (Human h : list) {
                if (h.getFIO().equals(request.getParameter("fio"))) {
                    response.getWriter().print("Name : " + h.getFIO() + "<br>");
                    response.getWriter().print("Job : " + h.getJOB() + "<br>");
                    response.getWriter().print("Phone number : " + h.getPNUMBER() + "<br>");
                    response.getWriter().print("Birthday : " + h.getBDAY() + "<br>");
                    response.getWriter().print("email : " + h.getEMAIL() + "<br>");
                    response.getWriter().print("Comment : " + h.getCOMMENT() + "<br>");
                    response.getWriter().print("<br>");
                    response.getWriter().print("<a href=\"/ramil-super-puper-servlet-build-572\">BACK<a/>");

                }
            }
        } else {


            response.getWriter().println("<form action=\"/ramil-super-puper-servlet-build-572\" method=\"POST\"><br>");
            response.getWriter().println("<input type=\"text\" size=\"40\" name=\"fio\" placeholder=\"Name\"/><br>");
            response.getWriter().println("<input type=\"text\" size=\"40\" name=\"pnumber\" placeholder=\"Phone Number\"/><br>");
            response.getWriter().println("<input type=\"text\" size=\"40\" name=\"email\" placeholder=\"E-mail\"/><br>");
            response.getWriter().println("<input type=\"text\" size=\"40\" name=\"bday\" placeholder=\"Birthday\"/><br>");
            response.getWriter().println("<input type=\"text\" size=\"40\" name=\"job\" placeholder=\"Job\"/><br>");
            response.getWriter().println("<input type=\"text\" size=\"100\" name=\"comment\" placeholder=\"Comment\"/><br>");
            response.getWriter().println("<input type=\"submit\" value=\"Add\"/>");

            response.getWriter().print("<br>");
            response.getWriter().print("<br>");

            if (list != null) {
                for (Human h : list) {
                    response.getWriter().print(h + "<br>");
                }
            }
        }

    }
}

