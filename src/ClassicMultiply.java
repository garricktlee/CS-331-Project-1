
public class ClassicMultiply extends MultiplyMatrix {

	@Override
	int[][] multiplyMatrix(int[][] A, int[][] B) {
		int n = A.length;	//Assume nxn matrix
		int[][] C = new int[n][n];
		
		for(int i = 0; i< n; i++){
			for(int j= 0; j < n; j++){
				for (int k =0; k<n; k++){
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		
		return C;
	}

}
