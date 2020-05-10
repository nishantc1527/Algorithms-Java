package Matrices;

import com.nishant.algorithms.Matrices.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix mat1, mat2;

    @Test
    public void creationTest() {
        mat1 = new Matrix(new int[][]{
                {-1, 0, 1},
                {0, 1, 1},
                {-1, -1, 1}
        });
        System.out.println(mat1);
    }

    @Test
    public void addTest() {
        mat1 = new Matrix(new int[][]{
                {0, 1, 2},
                {3, 4, 5},
        });
        mat2 = new Matrix(new int[][]{
                {0, 3, 6},
                {9, 12, 15},
        });

        Matrix res = mat1.add(mat2);
        assertEquals(new Matrix(new int[][]{
                {0, 4, 8},
                {12, 16, 20},
        }), res);
        System.out.println(res);
    }

    @Test
    public void equalsTest() {
        mat1 = new Matrix(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        mat2 = new Matrix(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(mat1, mat2);
    }

    @Test
    public void scalarMultTest() {
        mat1 = new Matrix(new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        });
        Matrix res = mat1.multiply(3);
        assertEquals(new Matrix(new int[][]{
                {0, 3, 6},
                {9, 12, 15},
                {18, 21, 24}
        }), res);
        System.out.println(res);
    }

    @Test
    public void matrixMultTest() {
        mat1 = new Matrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        mat2 = new Matrix(new int[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });
        Matrix res = mat1.multiply(mat2);
        assertEquals(new Matrix(new int[][]{
                {58, 64},
                {139, 154}
        }), res);
    }
}
