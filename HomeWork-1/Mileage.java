public class Mileage implements Comparable<Cars> {
    private int mile;

    public Mileage(int mile) {
        this.mile = mile;
    }

    @Override
    public int compareTo(Cars o) {

        return this.mile - o.getMile() ;
    }

}
