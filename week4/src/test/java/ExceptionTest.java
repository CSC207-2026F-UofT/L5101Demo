import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    public void testIndexOutOfBoundsException() {
        ArrayList<String> emptyList = new ArrayList<>();
        // emptyList.add("hello");

        assertThrows(
                IndexOutOfBoundsException.class,
                // ArithmeticException.class,
                () -> emptyList.get(0)
        );
    }
}