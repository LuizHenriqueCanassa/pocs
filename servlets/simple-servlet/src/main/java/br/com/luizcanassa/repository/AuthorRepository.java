package br.com.luizcanassa.repository;

import br.com.luizcanassa.RepositoryException;
import br.com.luizcanassa.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AuthorRepository implements Repository<Author, UUID>{
    @Override
    public Author findById(UUID id) throws RepositoryException {
        Optional<Author> author = Author.authors.stream().filter(a -> a.getId().equals(id)).findFirst();

        return author.orElseThrow(() -> new RepositoryException("Autor não encontrado!"));
    }

    @Override
    public List<Author> findAll() {
        return Author.authors;
    }

    @Override
    public void save(Author newAuthor) {
        Author.authors.add(newAuthor);
    }

    @Override
    public void delete(UUID id) throws RepositoryException{
        Author author = findById(id);

        Author.authors.remove(author);
    }

    @Override
    public void update(Author newAuthor, UUID id) throws RepositoryException {
        Author author = findById(id);

        author.updateAuthor(newAuthor);
    }
}
