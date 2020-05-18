public class Length implements Comparable<Cars> {
    private int length;

    public Length(int length) {
        this.length = length;
    }



    @Override
    public int compareTo(Cars o) {
        return this.length - o.getLength();
    }
}
