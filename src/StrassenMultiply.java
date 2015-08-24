import java.util.List;

public class StrassenMultiply extends DivideAndConquer {

	@Override
	int[][] multiplyMatrix(int[][] A, int[][] B) {
		int[][] C11, C12, C21, C22;
		int[][] P, Q, R, S, T, U, V;
		
		if(A.length == 2){
			int[][] C = new int[A.length][A.length];
			C[0][0] = (A[0][0] * B[0][0]) + (A[0][1] * B[1][0]);
			C[0][1] = (A[0][0] * B[0][1]) + (A[0][1] * B[1][1]);
			C[1][0] = (A[1][0] * B[0][0]) + (A[1][1] * B[1][0]);
			C[1][1] = (A[1][0] * B[0][1]) + (A[1][1] * B[1][1]);
			
			return C;
		}else{

			// List contains divided matrix: 00, 01, 10, 11
			// 						  index: 0   1   2   3
			List<int[][]> divA = divideMatrix(A);
			List<int[][]> divB = divideMatrix(B);
			
			//P = (A0+A3)(B0+B3)
			P = multiplyMatrix(addMatrix(divA.get(0), divA.get(3)), addMatrix(divB.get(0),divB.get(3)));
			
			//Q = (A2+A3)B0
			Q = multiplyMatrix(addMatrix(divA.get(2), divA.get(3)), divB.get(0));
			
			//R = A0(B1-B3)
			R = multiplyMatrix(divA.get(0), subMatrix(divB.get(1), divB.get(3)));
			
			//S = A3(B2-B0)
			S = multiplyMatrix(divA.get(3), subMatrix(divB.get(2), divB.get(0)));
			
			//T = (A0+A1)B3
			T = multiplyMatrix(addMatrix(divA.get(0), divA.get(1)), divB.get(3));
			
			//U = (A2-A0)(B0+B1)
			U = multiplyMatrix(subMatrix(divA.get(2),divA.get(0)),addMatrix(divB.get(0),divB.get(1)));
			
			//V = (A1-A3)(B2+B3)
			V = multiplyMatrix(subMatrix(divA.get(1),divA.get(3)),addMatrix(divB.get(2),divB.get(3)));
			
			C11 = subMatrix(addMatrix(P, S), addMatrix(T, V));
			C12 = addMatrix(R, T);
			C21 = addMatrix(Q, S);
			C22 = subMatrix(addMatrix(P, R), addMatrix(Q, U));

			return combineMatrices(C11, C12, C21, C22);
		}
	}

	// subtract matrices of equal dimensions
	private int[][] subMatrix(int[][] A, int[][] B) {
		int[][] C = new int[A.length][A.length];
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A.length; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		return C;
	}
}
