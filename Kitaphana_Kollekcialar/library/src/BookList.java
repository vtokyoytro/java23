import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * List / ArrayList: кітаптардың негізгі тізбегі.
 * Қосу, алу, өзгерту, жою, өту, сұрыптау, іздеу және сүзгілеу.
 */
public class BookList {
    private final List<Book> books = new ArrayList<>();

    // ---------- Қосу, алу, өзгерту, жою ----------

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Кітап null болмауы керек!");
        }
        if (findById(book.getId()) != null) {
            System.out.println("  ! ID " + book.getId() + " бар, қосылмады.");
            return;
        }
        books.add(book);
    }

    public Book getByIndex(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("  ! Қате индекс: " + index);
            return null;
        }
        return books.get(index);
    }

    public void updateRating(int index, double newRating) {
        Book b = getByIndex(index);
        if (b != null) {
            b.setRating(newRating);
        }
    }

    public Book replaceByIndex(int index, Book newBook) {
        return books.set(index, newBook); // set() ескі элементті қайтарады
    }

    public boolean removeById(int id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Book removeByIndex(int index) {
        return books.remove(index);
    }

    public int size() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }

    // ---------- Өтудің үш тәсілі ----------

    public void printWithFor() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("  [" + i + "] " + books.get(i));
        }
    }

    public void printWithForEach() {
        for (Book b : books) {
            System.out.println("  - " + b);
        }
    }

    public void printWithIterator() {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println("  * " + it.next());
        }
    }

    // ---------- Сұрыптау ----------

    public void sortByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

    public void sortByRatingDesc() {
        books.sort(Comparator.comparingDouble(Book::getRating).reversed());
    }

    public void sortByYear() {
        // Comparator-ды қолмен жазу мысалы
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book a, Book b) {
                return Integer.compare(a.getYear(), b.getYear());
            }
        });
    }

    // ---------- Іздеу ----------

    public Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public List<Book> searchByTitle(String text) {
        List<Book> result = new ArrayList<>();
        if (text == null || text.trim().isEmpty()) {
            return result;
        }
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(text.trim().toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    // ---------- Сүзгілеу ----------

    public List<Book> filterByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> filterByYearRange(int from, int to) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getYear() >= from && b.getYear() <= to) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> filterAvailableWithMinRating(double minRating) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable() && b.getRating() >= minRating) {
                result.add(b);
            }
        }
        return result;
    }

    public static void printAll(List<Book> list) {
        if (list.isEmpty()) {
            System.out.println("  (ештеңе табылмады)");
            return;
        }
        for (Book b : list) {
            System.out.println("  " + b);
        }
    }
}
