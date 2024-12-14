public class TwoDimensionalArray {
    private int[][] array;

    // Constructor to initialize the array
    public TwoDimensionalArray(int rows, int cols) {
        array = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    // Method to insert a value into the array
    public void insert(int row, int col, int value) {
        try {
            if (array[row][col] == Integer.MIN_VALUE) {
                array[row][col] = value;
                System.out.println("Value inserted successfully at (" + row + ", " + col + ")");
            } else {
                System.out.println("Cell already occupied at (" + row + ", " + col + ")");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index (" + row + ", " + col + ")");
        }
    }

    // Method to traverse and print the array
    public void traverse() {
        for (int[] row : array) {
            for (int val : row) {
                System.out.print((val == Integer.MIN_VALUE ? "-" : val) + " ");
            }
            System.out.println();
        }
    }

    // Method to search for an element
    public void search(int value) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == value) {
                    System.out.println("Value " + value + " found at (" + row + ", " + col + ")");
                    return;
                }
            }
        }
        System.out.println("Value " + value + " not found in the array.");
    }

    // Method to delete an element from a specific index
    public void delete(int row, int col) {
        try {
            if (array[row][col] != Integer.MIN_VALUE) {
                array[row][col] = Integer.MIN_VALUE;
                System.out.println("Value deleted at (" + row + ", " + col + ")");
            } else {
                System.out.println("Cell already empty at (" + row + ", " + col + ")");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index (" + row + ", " + col + ")");
        }
    }

    // Driver program to test each method
    public static void main(String[] args) {
        TwoDimensionalArray tda = new TwoDimensionalArray(3, 3);

        System.out.println("Inserting values into the array:");
        tda.insert(0, 0, 10);
        tda.insert(1, 1, 20);
        tda.insert(2, 2, 30);

        System.out.println("\nTraversing the array:");
        tda.traverse();

        System.out.println("\nSearching for values:");
        tda.search(20); // Should be found
        tda.search(50); // Should not be found

        System.out.println("\nDeleting values from the array:");
        tda.delete(1, 1); // Valid deletion

        System.out.println("\nTraversing the array after deletions:");
        tda.traverse();
    }
}
