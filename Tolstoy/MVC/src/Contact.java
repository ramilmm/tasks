import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ��������� on 31.10.2015.
 */
@WebServlet(name = "Contact",urlPatterns = "/contacts")
public class Contact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("place","Contact");
        session.setAttribute("author","");
        session.setAttribute("head","Contacts");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
        rd.include(request, response);
    }
}
