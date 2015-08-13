import java.util.ArrayList;
import java.util.List;

public class DivideAndConquerMultiply extends MultiplyMatrix{

	@Override
	int[][] multiplyMatrix(int[][] A, int[][] B) {
		
		if(A.length == 2){
			int[][] C = new int[A.length][A.length];
			C[0][0] = (A[0][0] * B[0][0]) + (A[0][1] * B[1][0]);
			C[0][1] = (A[0][0] * B[0][1]) + (A[0][1] * B[1][1]);
			C[1][0] = (A[1][0] * B[0][0]) + (A[1][1] * B[1][0]);
			C[1][1] = (A[1][0] * B[0][1]) + (A[1][1] * B[1][1]);
			
			return C;
		
		} else {
			// List contains divided matrix: 00, 01, 10, 11
			//						  index:  0   1   2   3
			List<int[][]> divA = divideMatrix(A);
			List<int[][]> divB = divideMatrix(B);
			
			int[][] C00 = addMatrix(multiplyMatrix(divA.get(0), divB.get(0)),multiplyMatrix(divA.get(1),divB.get(2)));
			int[][] C01 = addMatrix(multiplyMatrix(divA.get(0), divB.get(1)),multiplyMatrix(divA.get(1),divB.get(3)));
			int[][] C10 = addMatrix(multiplyMatrix(divA.get(2), divB.get(0)),multiplyMatrix(divA.get(3),divB.get(2)));
			int[][] C11 = addMatrix(multiplyMatrix(divA.get(2), divB.get(1)),multiplyMatrix(divA.get(3),divB.get(3)));					
			
			return combineMatrices(C00, C01, C10, C11);
		}
	}
	
	//
	private int[][] combineMatrices(int[][] c00, int[][] c01, int[][] c10, int[][] c11) {
		int n = c00.length;
		int[][] C = new int[n*2][n*2];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				C[i][j] = c00[i][j];
				C[i][j+n] = c01[i][j];
				C[i+n][j] = c10[i][j];
				C[i+n][j+n] = c11[i][j];
			}
		}
		return C;
	}

	//Divide matrix into 4 equal parts
	private List<int[][]> divideMatrix(int[][] A){
		int n = A.length/2;
		int[][] A00 = new int[n][n];
		int[][] A01 = new int[n][n];
		int[][] A10 = new int[n][n];
		int[][] A11 = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j<n; j++){
				A00[i][j] = A[i][j];
				A01[i][j] = A[i][j+n];
				A10[i][j] = A[i+n][j];
				A11[i][j] = A[i+n][j+n];
			}
		}
		
		List<int[][]> matrices = new ArrayList<int[][]>();
		matrices.add(A00);
		matrices.add(A01);
		matrices.add(A10);
		matrices.add(A11);
		
		return matrices;
	}
	
	//Add matrix of equal dimensions
	private int[][] addMatrix(int[][] A, int[][] B){
		int[][]C = new int[A.length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A.length; j ++){
				C[i][j] = A[i][j]+B[i][j];
			}
		}
		
		return C;
	}
}
