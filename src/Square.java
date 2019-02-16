public class Square {

    private int number;
    private int x;
    private int y;

    public int getNumber() {
        return number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Square(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s  -> (%s, %s)", number,x,y);
    }
}
