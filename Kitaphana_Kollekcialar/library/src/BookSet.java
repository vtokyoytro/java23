import java.util.HashSet;
import java.util.Set;

/**
 * Set / HashSet: бірегей жанрлар (Set<String>) және бірегей авторлар (Set<Author>).
 * Author ішіндегі equals() және hashCode() қайталануды болдырмайды.
 */
public class BookSet {
    private final Set<String> genres = new HashSet<>();
    private final Set<Author> authors = new HashSet<>();

    public boolean addGenre(String genre) {
        return genres.add(genre.trim().toLowerCase()); // бар болса false қайтарады
    }

    public boolean removeGenre(String genre) {
        return genres.remove(genre.trim().toLowerCase());
    }

    public boolean containsGenre(String genre) {
        return genres.contains(genre.trim().toLowerCase());
    }

    public boolean addAuthor(Author author) {
        return authors.add(author);
    }

    public boolean containsAuthor(Author author) {
        return authors.contains(author);
    }

    public int genreCount() {
        return genres.size();
    }

    public int authorCount() {
        return authors.size();
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
