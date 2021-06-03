import java.util.Random;

public class Matrix {
    private int width;
    private int height;
    private int[][] data;

    /**
     * Matrix's width getter
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Matrix's height getter
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Instantiates an empty Matrix using the given data
     * @param width The Matrix's width
     * @param height The Matrix's height
     */
    public Matrix(int width, int height){
        this.width = width;
        this.height = height;
        this.data = new int[width][height];
    }

    /**
     * Fills the Matrix with random data.
     * @param min The minimum value allowed for the random data (inclusive).
     * @param max The maximum value allowed for the random data (inclusive).
     */
    public void Fill(int min, int max){
        Random r = new Random();

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                data[i][j] = r.nextInt(max-min+1) + min;
            }
        }
    }

    /**
     * Fills the Matrix with the given data.
     * @param num The minimum value that will be used to fill the Matrix.
     */
    public void Fill(int num){
        Fill(num, num);
    }

    /**
     * Fills the Matrix with random data.
     */
    public void Fill(){
        Fill(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Counts how many Matrix's values matches with the given one.
     * @param num The value to count.
     * @return The amount of matches found within the Matrix.
     */
    public int Count(int num){
        int c = 0;

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                if(data[i][j] == num) c++;
            }
        }

        return  c;
    }

    /**
     * Checks if the Matrix contains the given value.
     * @param num The value to find.
     * @return If the value has been found within the Matrix.
     */
    public boolean Found(int num){
        return Count(num) > 0;
    }

    /**
     * Returns the Matrix representation as text.
     * @return The Matrix as a string.
     */
    public String toString(){
        String s = "";

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                s += String.format(" [%s]", data[i][j]);
            }
            s += "\r\n";
        }

        return  s;
    }
}