import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Горендьже on 31.10.2015.
 */
@WebServlet(name = "Menu",urlPatterns = "/meun")
public class Menu extends HttpServlet {
    private ArrayList<String> buf;
    @Override
    public void init() throws ServletException {
        buf =new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String action=request.getParameter("action");
        if(action!=null&&!action.isEmpty()) {
            if (action.equals("liter")&& buf.size()<5) {
                buf.add("Pushkin");
                buf.add("Tolstoy");
                buf.add("Gete");
                buf.add("Gogol");
                buf.add("Esenin");
                request.setAttribute("names", buf);
                session.setAttribute("names", buf);
            }
            if (action.equals("movie")){
                String movie="Movies";
                buf.clear();
                session.setAttribute("head",movie);
                session.setAttribute("author","");
            }
            if (action.equals("music")){
                String music="Music";
                buf.clear();
                session.setAttribute("head",music);
                session.setAttribute("author","");
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
        rd.include(request, response);

    }
}
