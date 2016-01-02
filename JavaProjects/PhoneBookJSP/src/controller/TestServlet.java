package controller;

import model.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    List<Note> list;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        if ((name == null || name.isEmpty()) || (age == null || age.isEmpty()) || (phone == null || phone.isEmpty())) {
            request.setAttribute("error", true);
        } else {
            list.add(new Note(name,phone,Integer.parseInt(age)));
        }
        Collections.sort(list, new Comparator<Note>() {
            public int compare(Note n1, Note h2) {
                return n1.getFio().compareTo(h2.getFio());
            }
        });
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/test.jsp");
        rd.include(request, response);
    }

    @Override
    public void destroy() {
        list = null;
        super.destroy();
    }
}
