import java.util.Arrays;

public class SaddlePoint {
    public static void main(String[] args) {
        int[][] matrix = {
                {6, 3, 1},
                {9, 7, 8},
                {2, 4, 5}
        };

        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            // Find the minimum element in the current row
            int rowMin = Arrays.stream(matrix[i]).min().getAsInt();
            int colIndex = -1;

            // Find column index of rowMin (first occurrence)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == rowMin) {
                    colIndex = j;
                    break;
                }
            }

            // Check if rowMin is the largest in its column
            int finalColIndex = colIndex;
            boolean isSaddle = true;

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][finalColIndex] > rowMin) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("Saddle point is: " + rowMin);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No saddle point found");
        }
    }
}