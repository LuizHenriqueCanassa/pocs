package br.com.luizcanassa.servlet.author;

import br.com.luizcanassa.RepositoryException;
import br.com.luizcanassa.repository.AuthorRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "DeleteAuthorServlet", urlPatterns = "/author/delete-author")
public class DeleteAuthorServlet extends HttpServlet {
    private final AuthorRepository authorRepository = new AuthorRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            authorRepository.delete(UUID.fromString(req.getParameter("id")));

            resp.sendRedirect(req.getContextPath() + "/author");
        }catch (RepositoryException | IOException e){
            e.printStackTrace();
        }
    }
}
