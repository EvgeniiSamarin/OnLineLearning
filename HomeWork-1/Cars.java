public class Cars {
    public int price;
    private int length;
    private int mile;

    public Cars(int price, int length, int mile) {
        this.price = price;
        this.length = length;
        this.mile = mile;
    }

    public int getMile() {
        return mile;
    }

    public int getLength() {
        return this.length;
    }

    public int getPrice() {
        return price;
    }
}
