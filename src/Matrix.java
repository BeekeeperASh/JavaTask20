public class Matrix<T> {
    private T[][] data;
    private int rows;
    private int columns;

    public Matrix(T[][] data) {
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }


    public T get(int row, int column) {
        checkBounds(row, column);
        return data[row][column];
    }

    public void set(int row, int column, T value) {
        checkBounds(row, column);
        data[row][column] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix<T> add(Matrix<T> other) {
        checkDimensions(other);
        Matrix<T> result = new Matrix<>((T[][]) new Object[rows][other.columns]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.set(i, j, (T) (Double) (((Number) data[i][j]).doubleValue() + ((Number) other.get(i, j)).doubleValue()));
            }
        }
        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (columns != other.getRows()) {
            throw new IllegalArgumentException("Cannot multiply matrices with incompatible dimensions");
        }
        Matrix<T> result = new Matrix<>((T[][]) new Object[rows][other.columns]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                double value = 0;
                for (int k = 0; k < columns; k++) {
                    value += ((Number) data[i][k]).doubleValue() * ((Number) other.get(k, j)).doubleValue();
                }
                result.set(i, j, (T) (Double) value);
            }
        }
        return result;
    }

    private void checkBounds(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid matrix index");
        }
    }

    private void checkDimensions(Matrix<T> other) {
        if (rows != other.getRows() || columns != other.getColumns()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
    }

    public static void main(String[] args) {
        Integer[][] data1 = {{1, 2}, {3, 4}};
        Matrix<Integer> matrix1 = new Matrix<>(data1);

        Matrix<Integer> matrix2 = new Matrix<>(new Integer[][]{{0, 0}, {0, 0}});
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        Matrix<Integer> sumMatrix = matrix1.add(matrix2);

        Matrix<Integer> productMatrix = matrix1.multiply(matrix2);

        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        System.out.println("Sum Matrix:");
        printMatrix(sumMatrix);
        System.out.println("Product Matrix:");
        printMatrix(productMatrix);
    }

    public static void printMatrix(Matrix<?> matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(matrix.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
