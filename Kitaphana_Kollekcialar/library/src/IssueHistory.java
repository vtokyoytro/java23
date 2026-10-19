import java.util.LinkedList;

/**
 * LinkedList: кітап беру тарихы (соңғы әрекеттер басында тұрады)
 * және оқу кезегі. addFirst, addLast, getFirst, removeFirst әдістері.
 */
public class IssueHistory {
    private final LinkedList<String> history = new LinkedList<>();

    // Жаңа әрекет тізімнің басына қосылады (ең жаңасы бірінші)
    public void addRecord(String record) {
        history.addFirst(record);
    }

    // Кезекке жазылу - соңына қосылады
    public void addToQueue(String reader) {
        history.addLast(reader);
    }

    public String getLatest() {
        return history.isEmpty() ? null : history.getFirst();
    }

    public String removeLatest() {
        return history.isEmpty() ? null : history.removeFirst();
    }

    public int size() {
        return history.size();
    }

    public void print() {
        if (history.isEmpty()) {
            System.out.println("  (тарих бос)");
            return;
        }
        int n = 1;
        for (String s : history) {
            System.out.println("  " + (n++) + ". " + s);
        }
    }
}
