import java.util.*;

public class MyMap<K, V> extends AbstractMap<K, V> implements java.util.Map<K, V> {

    private ArrayList<K> key;
    private ArrayList<V> value;
    private int size;
    private Set<Entry<K,V>> entrySet;

    public MyMap() {
        key = new ArrayList<>();
        value = new ArrayList<>();
        size = 0;
    }
    public Iterator<K> iterator() {
        return new IteratorOfMap<>(key);
    }
    public boolean containsKey(Object k) {
        if (size == 0) throw new NoSuchElementException("error");
        if(k == null) throw new NullPointerException("error");
        try {
            K checkKey = (K) k;
            return  key.contains(k);
        } catch (ClassCastException ex){
            throw new ClassCastException("error");
        }
    }

    public boolean containsValue(Object v) {
        if (size == 0) throw new NoSuchElementException("error");
        if(v == null) throw new NullPointerException("error");
        try {
            V checkValue = (V) v;
            return  value.contains(v);
        } catch (ClassCastException ex){
            throw new ClassCastException("error");
        }
    }

    public void clear() {

    }
    public V get(Object k) {
        if(k == null) throw new NullPointerException("error");
        if (size == 0) throw new NoSuchElementException("error");
        try {
            K checkKey = (K) k;
            return value.get(key.indexOf(k));
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }

    }
    public Set<K> keySet() {
        Set<K> k = new HashSet<K>();
        for (K x : key) {
            k.add(x);
        }
        return k;
    }
    public Collection<V> valueSet() {
        Collection<V> val = new ArrayList<V>();
        for (V x : value) {
            val.add(x);
        }
        return val;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
    public V remove(Object k) {
        if (key == null) throw new NullPointerException("error");
        try {
            K keyPop = (K) k;
            int index = key.indexOf(k);
            V valPop = value.remove(index);
            key.remove(index);
            return valPop;
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        Entry<K, V> entry = null;
        for (K k : key) {
            entry.setValue(value.get(key.indexOf(k)));
            entrySet.add(entry);
        }
        return entrySet;
    }
    public V put(K k, V v) {
        if (k == null  | v == null) throw new NullPointerException("error");
        try {
            K keyPop = (K) k;
            V valPop = (V) v;
            valPop = value.get(key.indexOf(k));
            value.set(key.indexOf(k), v);
            return valPop;
        } catch (ClassCastException ex) {
            throw new ClassCastException("error");
        } catch (IndexOutOfBoundsException ex) {
            value.set(key.indexOf(k), v);
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyMap<?, ?> myMap = (MyMap<?, ?>) o;
        return size == myMap.size &&
                Objects.equals(key, myMap.key) &&
                Objects.equals(value, myMap.value) &&
                Objects.equals(entrySet, myMap.entrySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, value, size, entrySet);
    }

    @Override
    public String toString() {
        return "MyMap{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
