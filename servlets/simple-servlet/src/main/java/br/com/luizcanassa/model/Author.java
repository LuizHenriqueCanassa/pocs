package br.com.luizcanassa.model;

import lombok.*;

import java.util.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Author {

    public static List<Author> authors = new ArrayList<>();

    @NonNull
    private UUID id;

    @NonNull
    private String name;

    private List<Book> books = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void updateAuthor(Author newAuthor){
        this.setId(newAuthor.getId());
        this.setName(newAuthor.getName());
    }
}
