public class MatrixDriver {

	public static void main(String[] args) {
		
		final int MATRIX_SIZE = 3; // Size of N, NxN matrices

		int[][] A = generateMatrix(MATRIX_SIZE);
		//printMatrix(A);
		int[][] B = generateMatrix(MATRIX_SIZE);
		//System.out.println();
		//printMatrix(B);
		int[][] C;
		
		MultiplyMatrix m1 = new ClassicMultiply();
		m1.setStartTime();
		C = m1.multiplyMatrix(A, B);
		m1.setFinalTime();
		System.out.println("m1 final time: " + m1.getFinalTime() + " ms");
		printMatrix(C);
	}

	// generate matrix nxn
	private static int[][] generateMatrix(int n) {
		int[][] A = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = (int)( Math.random() * 10);
			}
		}

		return A;
	}
	
	private static void printMatrix(int[][] m){
	    try{
	        int rows = m.length;
	        int columns = m[0].length;
	        String str = "|\t";

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                str += m[i][j] + "\t";
	            }

	            System.out.println(str + "|");
	            str = "|\t";
	        }

	    }catch(Exception e){System.out.println("Matrix is empty!!");}
	}

}
