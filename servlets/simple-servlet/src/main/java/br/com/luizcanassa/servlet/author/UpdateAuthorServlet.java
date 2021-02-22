package br.com.luizcanassa.servlet.author;

import br.com.luizcanassa.RepositoryException;
import br.com.luizcanassa.model.Author;
import br.com.luizcanassa.repository.AuthorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "UpdateAuthorServlet", urlPatterns = "/author/edit-author")
public class UpdateAuthorServlet extends HttpServlet {
    private final AuthorRepository repository = new AuthorRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Author author = repository.findById(UUID.fromString(req.getParameter("id")));

            req.setAttribute("author", author);

            req.getRequestDispatcher("/author/author.jsp").forward(req, resp);
        }catch (RepositoryException | ServletException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Author author = new Author(UUID.fromString(req.getParameter("id")), req.getParameter("name"));

        try {
            repository.update(author, UUID.fromString(req.getParameter("id")));

            resp.sendRedirect(req.getContextPath() + "/author");
        }catch (RepositoryException | IOException e){
            e.printStackTrace();
        }
    }
}
