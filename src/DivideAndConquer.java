import java.util.ArrayList;
import java.util.List;


public abstract class DivideAndConquer extends MultiplyMatrix {

	//Divide matrix into 4 equal parts
	public List<int[][]> divideMatrix(int[][] A){
		int n = A.length/2;
		int[][] A00, A01, A10, A11;
		A00 = new int[n][n];
		A01 = new int[n][n];
		A10 = new int[n][n];
		A11 = new int[n][n];
		
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
	
	//Combine matrices into one matrix
	//c00 top left, c01 top right, c10 bottom left, c11 bottom right
	public int[][] combineMatrices(int[][] c00, int[][] c01, int[][] c10, int[][] c11) {
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
	
	//Add matrices of equal dimensions
	public int[][] addMatrix(int[][] A, int[][] B){
		int[][]C = new int[A.length][A.length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A.length; j ++){
				C[i][j] = A[i][j]+B[i][j];
			}
		}
		
		return C;
	}
	
}
