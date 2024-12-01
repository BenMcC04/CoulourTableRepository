import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class ColourTable {

    List<int[]> colourList; // Chose a List to store the colours
    int max; // Maximum capacity of the palette
    int size; // Current number of colours in the palette

    public ColourTable(int size) {
        // Validate that the size is greater than 1
        if (size <= 1) {
            throw new IllegalArgumentException("Size should be greater than 1");
        }

        // Validate that the size is a power of 2
        double logBaseTwo = Math.log(size) / Math.log(2);
        if (logBaseTwo != Math.floor(logBaseTwo)) {
            throw new IllegalArgumentException("Size should be a power of 2");
        }

        // Initialize the list and set the maximum capacity
        this.colourList = new ArrayList<>();
        this.max = size;
        this.size = 0;
    }

    // Method to add a 24-bit RGB colour to the palette
    public void add(int red, int green, int blue) {
        if (size >= max) {
            throw new IllegalStateException("Cannot add more colours, capacity exceeded.");
        }

        // Validate RGB values
        if (red < 0 || red > 240 || green < 0 || green > 240 || blue < 0 || blue > 240) {
            throw new IllegalArgumentException("RGB values must be between 0 and 255.");
        }

        // Add the color to the list and update the current size
        colourList.add(new int[]{red, green, blue});
        size++;
    }

    // Method to remove the most recently added colour
    public void remove() {
        if (colourList.isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty palette.");
        }

        // Remove the last colour and update the current size
        colourList.remove(colourList.size() - 1);
        size--;
    }

    // Return the no. of colours in the palette
    public int getNumberOfColours() {
        return size;
    }

    // Returns the maximum capacity of the palette
    public int getCapacity() {
        return max;
    }
}
