import java.util.ArrayList;
import java.util.Iterator;

public class IteratorOfMap<K> implements Iterator<K> {
    ArrayList<K> key;
    int cursor;

    public IteratorOfMap(ArrayList<K> key) {
        this.key = key;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if (key.get(cursor + 1) != null) return true;
        return false;
    }
    @Override
    public K next() {
        cursor++;
        return key.get(cursor - 1);
    }
    public K remove() {
        if (key.get(cursor) == null) throw new IllegalStateException("error");
        K k = key.get(cursor);
        key.set(cursor, null);
        return k;
    }
}