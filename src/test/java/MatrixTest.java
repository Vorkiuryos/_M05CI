import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatrixTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,20", "9384,12384"})
    void getWidth_OK(int width, int height) {
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(width, m.getWidth());
    }

    @org.junit.jupiter.api.Test
    void getWidth_NEGATIVE() {
        int width = -1;
        int height = 5;
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            new Matrix(width, height);
        });
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @ParameterizedTest
    @CsvSource({"1,5,5", "2,10,20", "3,9384,12384"})
    void fill(int num, int width, int height) {
        Matrix m = new Matrix(width, height);
        m.Fill(num);
        Assertions.assertEquals(width*height, m.Count(num));
    }

    @ParameterizedTest
    @CsvSource({"1,5,5", "2,10,20", "3,9384,12384"})
    void count(int num, int width, int height) {
        Matrix m = new Matrix(width, height);
        m.Fill(num);
        Assertions.assertEquals(width*height, m.Count(num));
    }

    @ParameterizedTest
    @CsvSource({"1,5,4", "2,10,20", "3,9384,12384"})
    void found_OK(int num, int width, int height) {
        Matrix m = new Matrix(width, height);
        m.Fill(num);
        Assertions.assertTrue(m.Found(num));
    }

    @ParameterizedTest
    @CsvSource({"1,5,5", "2,10,20", "3,9384,12384"})
    void found_KO(int num, int width, int height) {
        Matrix m = new Matrix(width, height);
        m.Fill(num);
        Assertions.assertFalse(m.Found(num+1));
    }

    @ParameterizedTest
    @CsvSource({"1,5,5", "2,10,20", "3,75,132"})
    void _toString(int num, int width, int height) {
        Matrix m = new Matrix(width, height);
        m.Fill(num);

        String expected = "";
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                expected += " [" + String.valueOf(num) + "]";
            }
            expected += "\r\n";
        }
        Assertions.assertEquals(expected, m.toString());
    }
}