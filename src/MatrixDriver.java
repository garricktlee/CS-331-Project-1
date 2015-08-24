import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MatrixDriver {

	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {
		
		int size, matrixSize;
		final int NUM_TEST = 3;
		int nSize = 5;
		
		for (int x = 1; x <= nSize; x++) {
			PrintWriter writer = new PrintWriter("Matrix Data "+x+".txt", "UTF-8");
			size = nSize;// Size of nxn matrix, n = 2^SIZE
			matrixSize = (int) Math.pow(2, x);

			System.out.println("n = 2^" + x);
			writer.println("n = 2^" + x);

			int[][] A = generateMatrix(matrixSize);
			// printMatrix(A);
			int[][] B = generateMatrix(matrixSize);
			// System.out.println();
			// printMatrix(B);
			int[][] C;
			MultiplyMatrix m1 = new ClassicMultiply();
			MultiplyMatrix m2 = new DivideAndConquerMultiply();
			MultiplyMatrix m3 = new StrassenMultiply();

			// CLASSIC TEST
			double averageTime = 0;
			for (int i = 0; i < NUM_TEST; i++) {
				m1.setStartTime();
				C = m1.multiplyMatrix(A, B);
				m1.setFinalTime();
				// System.out.println("m1 final time: " + m1.getFinalTime() + " ms");
				// printMatrix(C);
				averageTime += m1.getFinalTime();
			}
			averageTime /= NUM_TEST;
			System.out.println("Average time for Classic : " + averageTime
					+ " ms");
			writer.println("Average time for Classic : " + averageTime + " ms");

			// DIVIDE AND CONQUER TEST
			averageTime = 0;
			for (int i = 0; i < NUM_TEST; i++) {
				m2.setStartTime();
				C = m2.multiplyMatrix(A, B);
				m2.setFinalTime();
				// System.out.println("m1 final time: " + m2.getFinalTime() + " ms");
				// printMatrix(C);
				averageTime += m2.getFinalTime();
			}
			averageTime /= NUM_TEST;
			System.out.println("Average time for Divide and Conquer : "
					+ averageTime + " ms");
			writer.println("Average time for Divide and Conquer : "
					+ averageTime + " ms");

			// STRASSEN TEST
			averageTime = 0;
			for (int i = 0; i < NUM_TEST; i++) {
				m3.setStartTime();
				C = m3.multiplyMatrix(A, B);
				m3.setFinalTime();
				// System.out.println("m1 final time: " + m3.getFinalTime() + " ms");
				// printMatrix(C);
				averageTime += m3.getFinalTime();
			}
			averageTime /= NUM_TEST;
			System.out.println("Average time for Strassen : " + averageTime
					+ " ms");
			writer.println("Average time for Strassen : " + averageTime + " ms");
		System.out.println();
		writer.close();
		}
	}

	// generate matrix nxn
	private static int[][] generateMatrix(int n) {
		int[][] A = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = (int) (Math.random() * 10);
			}
		}

		return A;
	}

	private static void printMatrix(int[][] m) {
		try {
			int rows = m.length;
			int columns = m[0].length;
			String str = "|\t";

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					str += m[i][j] + "\t";
				}

				System.out.println(str + "|");
				str = "|\t";
			}
		} catch (Exception e) {
			System.out.println("Error: Matrix is empty.");
		}
	}

}
