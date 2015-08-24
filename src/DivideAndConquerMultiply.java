import java.util.List;

public class DivideAndConquerMultiply extends DivideAndConquer{

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
			//                        index:  0   1   2   3
			List<int[][]> divA = divideMatrix(A);
			List<int[][]> divB = divideMatrix(B);
			
			int[][] C00 = addMatrix(multiplyMatrix(divA.get(0), divB.get(0)),multiplyMatrix(divA.get(1),divB.get(2)));
			int[][] C01 = addMatrix(multiplyMatrix(divA.get(0), divB.get(1)),multiplyMatrix(divA.get(1),divB.get(3)));
			int[][] C10 = addMatrix(multiplyMatrix(divA.get(2), divB.get(0)),multiplyMatrix(divA.get(3),divB.get(2)));
			int[][] C11 = addMatrix(multiplyMatrix(divA.get(2), divB.get(1)),multiplyMatrix(divA.get(3),divB.get(3)));					
			
			return combineMatrices(C00, C01, C10, C11);
		}
	}
	
}
