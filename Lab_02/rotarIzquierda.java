public class rotarIzquierda {
	public static void main(String args[]) {

		int array[] = { 1, 2, 3, 4, 5, 6 };
		int aux[] = rotarIzquierdaArray(array, 3);

		for (int i = 0; i < aux.length; i++) {
			System.out.print(aux[i] + " ");
		}
	}

	public static int[] rotarIzquierdaArray(int[] array, int idx) {
	    int[] aux = new int[array.length];

	    for (int i = 0; i < aux.length; i++) {
	        aux[i] = array[(i + idx) % array.length];
	    }

	    return aux;
	}
}