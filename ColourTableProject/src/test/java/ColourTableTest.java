import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ColourTableTest {

    //class tests whether number of colours in the palette is a power of 2 >1
    void sizeRightTest(){
        assertDoesNotThrow(()->new ColourTable(2));
        assertDoesNotThrow(()->new ColourTable(4));
        assertDoesNotThrow(()->new ColourTable(8));
    }
    void sizeWrongTest(){
        assertThrows(IllegalArgumentException.class,()->new ColourTable(5));
        assertThrows(IllegalArgumentException.class,()->new ColourTable(7));
        assertThrows(IllegalArgumentException.class,()->new ColourTable(12));
    }
}
