public class LucasNumber {
    private int index;
    private long value;

    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    public boolean cubeCalc() {
        if (value < 1) return false;
        long w3 = Math.round(Math.cbrt(value - 1));
        return w3 * w3 * w3 + 1 == value;
    }

    @Override
    public String toString() {
        return "Luke numb: " + index + " = " + value;
    }
}
