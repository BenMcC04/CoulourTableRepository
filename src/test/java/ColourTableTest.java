import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTest {

    @Test
    void sizeRightTest() {
        // Valid palette sizes (power of 2 and >1)
        assertDoesNotThrow(() -> new ColourTable(2));
        assertDoesNotThrow(() -> new ColourTable(4));
        assertDoesNotThrow(() -> new ColourTable(8));
    }

    @Test
    void sizeWrongTest() {
        // Invalid palette sizes
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5)); // Not a power of 2
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(7)); // Not a power of 2
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(12)); // Not a power of 2
    }

    @Test
    void validConstructorTest() {
        ColourTable table = new ColourTable(8);
        assertNotNull(table, "ColourTable object should be created.");
        assertEquals(8, table.getCapacity(), "Capacity should be set correctly.");
    }

    @Test
    void testAddRGBColour() {
        ColourTable table = new ColourTable(4);

        // Add valid colors
        table.add(156, 0, 0); // Add red
        table.add(0, 100, 0); // Add green
        assertEquals(2, table.getNumberOfColours(), "Two valid colors should be added.");

        // Add invalid colors
        assertThrows(IllegalArgumentException.class, () -> table.add(256, 0, 0), "Red value exceeds range.");
        assertThrows(IllegalArgumentException.class, () -> table.add(-1, 0, 0), "Negative red value.");
        assertThrows(IllegalArgumentException.class, () -> table.add(0, 0, 300), "Blue value exceeds range.");
    }

    @Test
    void paletteSizeTest() {
        ColourTable table = new ColourTable(16);
        assertEquals(16, table.getCapacity(), "Palette capacity should match the given size.");
    }

    @Test
    void capacityTest() {
        ColourTable table = new ColourTable(4);
        table.add(44, 0, 0); // Add red
        table.add(0, 100, 0); // Add green
        table.add(0, 0, 16); // Add blue
        table.add(255, 255, 255); // Add white

        // Test adding beyond capacity
        assertThrows(IllegalStateException.class, () -> table.add(128, 128, 128), "Should not allow adding beyond capacity.");
    }


    @Test
    void removeTest() {
        ColourTable table = new ColourTable(4);
        assertThrows(IllegalStateException.class, () -> table.remove(), "Removing from an empty palette should throw an exception.");
    }
}
