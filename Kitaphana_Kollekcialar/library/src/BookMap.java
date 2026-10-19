import java.util.HashMap;
import java.util.Map;

/**
 * Map / HashMap: кітаптарды бірегей ID кілті бойынша сақтау.
 */
public class BookMap {
    private final Map<Integer, Book> map = new HashMap<>();

    // put() кілт бұрыннан бар болса, ескі мәнді қайтарады және жаңасымен ауыстырады
    public Book put(Book book) {
        return map.put(book.getId(), book);
    }

    public Book get(int id) {
        return map.get(id);
    }

    public Book remove(int id) {
        return map.remove(id);
    }

    public boolean containsKey(int id) {
        return map.containsKey(id);
    }

    public int size() {
        return map.size();
    }

    public void printWithEntrySet() {
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            System.out.println("  ID=" + entry.getKey() + " -> " + entry.getValue().getTitle()
                    + " (" + entry.getValue().getAuthor().getName() + ")");
        }
    }
}
