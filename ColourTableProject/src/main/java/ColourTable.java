import java.lang.Math;

public class ColourTable {

    int size;

    public ColourTable(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Size should be greater than 1");
        }
        double logBaseTwo = Math.log(size) / Math.log(2);
        if (logBaseTwo != Math.floor(logBaseTwo)) {
            throw new IllegalArgumentException("Size should be a power of 2");
        }
    }
}
