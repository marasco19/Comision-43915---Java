public class Counter {
    private int count;

    public int add() {
        count++;
        return count;
    }
    public int decrement() {
        count--;
        return count;
    }
    public void print() {
        System.out.println("Counter " + count);
    }
}
