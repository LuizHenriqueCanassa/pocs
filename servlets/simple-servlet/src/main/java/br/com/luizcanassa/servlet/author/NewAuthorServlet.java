package br.com.luizcanassa.servlet.author;

import br.com.luizcanassa.model.Author;
import br.com.luizcanassa.repository.AuthorRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "NewAuthorServlet", urlPatterns = "/author/new-author")
public class NewAuthorServlet extends HttpServlet {

    private final AuthorRepository authorRepository = new AuthorRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("title", "Simple Servlet - Novo Autor");

        try {
            req.getRequestDispatcher("/author/author.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Author author = new Author(UUID.randomUUID(), req.getParameter("name"));

        authorRepository.save(author);

        try {
            resp.sendRedirect(req.getContextPath() + "/author");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
