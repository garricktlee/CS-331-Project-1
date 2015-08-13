
public abstract class MultiplyMatrix {

	private double startTime = 0;
	private double finalTime = 0;

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime() {
		this.startTime = System.nanoTime();
	}

	public double getFinalTime() {
		return finalTime;
	}

	public void setFinalTime() {
		this.finalTime = (System.nanoTime() - startTime)/1000000;
	}


	abstract int[][] multiplyMatrix(int[][] A, int[][] B);

}
