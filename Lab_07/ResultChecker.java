
public class ResultChecker {

	private boolean[] result;

	public ResultChecker(int num) {
		result = new boolean[num];
	}

	public void setPlagio(int index, boolean isPlagio) {
		result[index] = isPlagio;

	}

	public boolean[] getResults() {
		return result;
	}

}
