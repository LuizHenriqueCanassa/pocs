package br.com.luizcanassa.servlet.author;

import br.com.luizcanassa.repository.AuthorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorServlet", urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {

    private final AuthorRepository repository = new AuthorRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("title", "Simple Servlet - Author");

        req.setAttribute("authors", repository.findAll());

        try {
            req.getRequestDispatcher("/author/index.jsp").forward(req, resp);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
