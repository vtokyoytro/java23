import java.time.Year;

/**
 * Кітап класы - жобаның негізгі нысаны.
 */
public class Book {
    private final int id;
    private String title;
    private Author author;
    private String genre;
    private int year;
    private double rating;
    private boolean available;

    public Book(int id, String title, Author author, String genre, int year, double rating) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID оң сан болуы керек: " + id);
        }
        this.id = id;
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setYear(year);
        setRating(rating);
        this.available = true; // жаңа кітап әрқашан кітапханада
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    // Сеттерлер енгізілген мәндерді тексереді
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Кітап атауы бос болмауы керек!");
        }
        this.title = title.trim();
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Автор көрсетілмеген!");
        }
        this.author = author;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Жанр бос болмауы керек!");
        }
        this.genre = genre.trim();
    }

    public void setYear(int year) {
        int current = Year.now().getValue();
        if (year < 1000 || year > current) {
            throw new IllegalArgumentException("Жарияланған жыл 1000 мен " + current + " аралығында болуы керек: " + year);
        }
        this.year = year;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Рейтинг 0 мен 5 аралығында болуы керек: " + rating);
        }
        this.rating = rating;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", \"" + title + "\", автор=" + author
                + ", жанр=" + genre + ", жыл=" + year
                + ", рейтинг=" + rating + ", қолжетімді=" + (available ? "иә" : "жоқ") + "}";
    }
}
