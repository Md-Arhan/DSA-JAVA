public class Gaussian_Elimination {

import java.util.*;

public class GaussianElimination {
    static final int N = 3;

    public static void main(String[] args) {
        double[][] mat = {
                { 3.0, 2.0, -4.0, 3.0 },
                { 2.0, 3.0, 3.0, 15.0 },
                { 5.0, -3.0, 1.0, 14.0 }
        };
        gaussianElimination(mat);
    }

    static void gaussianElimination(double[][] mat) {
        int singularFlag = forwardElimination(mat);
        if (singularFlag != -1) {
            System.out.println("Singular Matrix.");
            if (mat[singularFlag][N] != 0)
                System.out.println("Inconsistent System.");
            else
                System.out.println("May have infinitely many solutions.");
            return;
        }
        backSubstitution(mat);
    }

    static void swapRows(double[][] mat, int i, int j) {
        for (int k = 0; k <= N; k++) {
            double temp = mat[i][k];
            mat[i][k] = mat[j][k];
            mat[j][k] = temp;
        }
    }

    static int forwardElimination(double[][] mat) {
        for (int k = 0; k < N; k++) {
            int pivotRow = k;
            double pivotVal = mat[k][k];

            for (int i = k + 1; i < N; i++) {
                if (Math.abs(mat[i][k]) > Math.abs(pivotVal)) {
                    pivotVal = mat[i][k];
                    pivotRow = i;
                }
            }

            if (pivotVal == 0)
                return k;

            if (pivotRow != k)
                swapRows(mat, k, pivotRow);

            for (int i = k + 1; i < N; i++) {
                double factor = mat[i][k] / mat[k][k];
                for (int j = k; j <= N; j++)
                    mat[i][j] -= mat[k][j] * factor;
            }
        }
        return -1;
    }

    static void backSubstitution(double[][] mat) {
        double[] x = new double[N];

        for (int i = N - 1; i >= 0; i--) {
            x[i] = mat[i][N];
            for (int j = i + 1; j < N; j++)
                x[i] -= mat[i][j] * x[j];
            x[i] /= mat[i][i];
        }

        System.out.println("Solution:");
        for (int i = 0; i < N; i++)
            System.out.printf("x[%d] = %.4f%n", i + 1, x[i]);
    }
}}


/*

Genera; method: Replace a Row (Most Important)

Replace one row using another row.

General formula:

R2​→R2​−R1​
R3​→R3​−2R1
R3​→3R3​+R2​

All are valid.


After that what ever is left in the matrix solve using equeation

*/