import java.util.List;

/**
 * Кітапхана жүйесі: List, LinkedList, Set, Map коллекцияларын көрсету.
 */
public class Main {
    public static void main(String[] args) {
        Author abai = new Author("Абай Құнанбайұлы", "Қазақстан");
        Author auezov = new Author("Мұхтар Әуезов", "Қазақстан");
        Author orwell = new Author("Джордж Оруэлл", "Ұлыбритания");
        Author tolkien = new Author("Дж. Р. Р. Толкин", "Ұлыбритания");
        Author dostoevsky = new Author("Фёдор Достоевский", "Ресей");

        // ============ 1. List / ArrayList ============
        header("1. List / ArrayList");
        BookList library = new BookList();
        library.addBook(new Book(1, "Абай жолы", auezov, "Роман", 1942, 4.9));
        library.addBook(new Book(2, "Қара сөздер", abai, "Философия", 1890, 4.8));
        library.addBook(new Book(3, "1984", orwell, "Антиутопия", 1949, 4.7));
        library.addBook(new Book(4, "Хоббит", tolkien, "Фэнтези", 1937, 4.6));
        library.addBook(new Book(5, "Қылмыс пен жаза", dostoevsky, "Роман", 1866, 4.5));
        library.addBook(new Book(3, "Қайталанған ID", orwell, "Роман", 1950, 3.0)); // қайталанады
        System.out.println("Кітаптар саны: " + library.size());

        System.out.println("\nИндекс бойынша алу (index 2):");
        System.out.println("  " + library.getByIndex(2));
        library.getByIndex(10); // қате индекс

        System.out.println("\nӨту: кәдімгі for");
        library.printWithFor();
        System.out.println("Өту: for-each");
        library.printWithForEach();
        System.out.println("Өту: Iterator");
        library.printWithIterator();

        System.out.println("\nӨзгерту: index 1 кітабының рейтингі 4.8 -> 5.0");
        library.updateRating(1, 5.0);
        System.out.println("  " + library.getByIndex(1));

        System.out.println("\nЖою: ID=5 кітабы");
        System.out.println("  Жойылды ма? " + library.removeById(5));
        System.out.println("  Қалған кітап саны: " + library.size());

        System.out.println("\nҚате деректі тексеру:");
        try {
            new Book(10, "Қате кітап", abai, "Роман", 3000, 4.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Қате ұсталды: " + e.getMessage());
        }
        try {
            new Book(11, "  ", abai, "Роман", 2000, 4.0);
        } catch (IllegalArgumentException e) {
            System.out.println("  Қате ұсталды: " + e.getMessage());
        }
        try {
            new Book(12, "Рейтинг қате", abai, "Роман", 2000, 7.5);
        } catch (IllegalArgumentException e) {
            System.out.println("  Қате ұсталды: " + e.getMessage());
        }

        // ============ 2. LinkedList ============
        header("2. LinkedList (кітап беру тарихы)");
        IssueHistory history = new IssueHistory();
        history.addRecord("Айдос \"Хоббит\" кітабын алды");
        history.addRecord("Дана \"1984\" кітабын қайтарды");
        history.addRecord("Мұрат \"Абай жолы\" кітабын алды");
        history.addToQueue("Кезекте: Әлия (Қара сөздер)");
        System.out.println("Тарих (ең жаңасы бірінші):");
        history.print();
        System.out.println("getFirst(): " + history.getLatest());
        System.out.println("removeFirst(): " + history.removeLatest());
        System.out.println("Жазба саны: " + history.size());

        // ============ 3. Set / HashSet ============
        header("3. Set / HashSet");
        BookSet sets = new BookSet();
        System.out.println("Жанрлар қосу:");
        for (Book b : library.getBooks()) {
            boolean added = sets.addGenre(b.getGenre());
            System.out.println("  add(\"" + b.getGenre() + "\") -> " + added);
        }
        System.out.println("Бірегей жанрлар: " + sets.getGenres());
        System.out.println("contains(\"фэнтези\"): " + sets.containsGenre("фэнтези"));
        System.out.println("remove(\"философия\"): " + sets.removeGenre("философия"));
        System.out.println("Жанрлар қалды: " + sets.getGenres());

        System.out.println("\nequals() және hashCode() көрсету:");
        Author abai2 = new Author("абай құнанбайұлы", "қазақстан"); // жаңа объект, бірақ мәні бірдей
        System.out.println("  abai == abai2 (сілтеме): " + (abai == abai2));
        System.out.println("  abai.equals(abai2): " + abai.equals(abai2));
        System.out.println("  hashCode тең ме: " + (abai.hashCode() == abai2.hashCode()));
        System.out.println("  addAuthor(abai): " + sets.addAuthor(abai));
        System.out.println("  addAuthor(abai2): " + sets.addAuthor(abai2) + "  <- қайталанбады");
        sets.addAuthor(auezov);
        sets.addAuthor(orwell);
        System.out.println("  Бірегей авторлар саны: " + sets.authorCount());
        for (Author a : sets.getAuthors()) {
            System.out.println("    " + a);
        }

        // ============ 4. Map / HashMap ============
        header("4. Map / HashMap");
        BookMap map = new BookMap();
        for (Book b : library.getBooks()) {
            map.put(b);
        }
        System.out.println("Map өлшемі: " + map.size());
        System.out.println("get(3): " + map.get(3));
        System.out.println("containsKey(4): " + map.containsKey(4));
        System.out.println("containsKey(99): " + map.containsKey(99));

        System.out.println("\nБар кілтті қайта қосу (ID=3):");
        Book old = map.put(new Book(3, "1984 (жаңа басылым)", orwell, "Антиутопия", 2020, 4.9));
        System.out.println("  Ескі мән: " + old.getTitle());
        System.out.println("  Жаңа мән: " + map.get(3).getTitle());
        System.out.println("  Map өлшемі өзгерген жоқ: " + map.size());

        System.out.println("\nentrySet() арқылы өту:");
        map.printWithEntrySet();

        System.out.println("\nremove(2): " + map.remove(2).getTitle());
        System.out.println("Map өлшемі: " + map.size());

        // ============ 5. Сұрыптау ============
        header("5. Сұрыптау (Comparator)");
        System.out.println("Атауы бойынша:");
        library.sortByTitle();
        library.printWithForEach();
        System.out.println("Рейтинг бойынша (кему ретімен):");
        library.sortByRatingDesc();
        library.printWithForEach();
        System.out.println("Жыл бойынша (өсу ретімен):");
        library.sortByYear();
        library.printWithForEach();

        // ============ 6. Іздеу және сүзгілеу ============
        header("6. Іздеу және сүзгілеу");
        System.out.println("ID бойынша іздеу (4): " + library.findById(4));
        System.out.println("ID бойынша іздеу (99): " + library.findById(99));

        System.out.println("\nАтауында \"абай\" сөзі бар кітаптар:");
        BookList.printAll(library.searchByTitle("абай"));

        System.out.println("\nЖанр бойынша сүзгі (Роман):");
        BookList.printAll(library.filterByGenre("Роман"));

        System.out.println("\nЖыл аралығы бойынша сүзгі (1900-1950):");
        BookList.printAll(library.filterByYearRange(1900, 1950));

        System.out.println("\nҚолжетімді және рейтингі >= 4.7:");
        library.getByIndex(0).setAvailable(false); // бір кітап қолда
        List<Book> good = library.filterAvailableWithMinRating(4.7);
        BookList.printAll(good);

        // ============ 7. Қорытынды ============
        header("7. Коллекцияны таңдау себебі");
        System.out.println("List (ArrayList): кітаптар реті маңызды, индекс бойынша жылдам алынады, қайталануы мүмкін, сұрыптауға ыңғайлы.");
        System.out.println("LinkedList: тарих пен кезекте басына/соңына қосу мен алу жылдам (addFirst, removeFirst).");
        System.out.println("Set (HashSet): жанрлар мен авторлар бірегей болуы керек, contains() жылдам жұмыс істейді.");
        System.out.println("Map (HashMap): кітапты ID кілті бойынша бірден табу үшін, тізімді толық аралаудың қажеті жоқ.");
    }

    private static void header(String text) {
        System.out.println("\n==================================================");
        System.out.println(text);
        System.out.println("==================================================");
    }
}
