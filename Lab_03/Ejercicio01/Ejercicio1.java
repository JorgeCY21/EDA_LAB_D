public class Ejercicio01 {

	public static void main(String[] args) {

		int [] pila1 = {1, 1, 1, 2, 3};
		int [] pila2 = {2, 3, 4};
		int [] pila3 = {1, 4, 1, 1};
		
		int num = sacarPilas(pila1, pila2, pila3);
		
		System.out.println(num);
		
	}

	public static int sacarPilas(int[] pila1, int[] pila2, int[] pila3) {

		int menor = sumMenor(pila1, pila2, pila3);

		while(!esTodosExactos(pila1, pila2, pila3, menor)) {
			menor--;
		}
		
		return menor;
		
	}

	public static boolean esQuitarExacto(int[] pila, int menor) {
		int suma = 0;
		for (int i = 0; i <pila.length; i++) {

			suma += pila[i];

			if (suma == menor)
				return true;
		}

		return false;
	}

	public static boolean esTodosExactos(int[] pila1, int[] pila2, int[] pila3, int menor) {
		return esQuitarExacto(pila1, menor) && esQuitarExacto(pila2, menor) && esQuitarExacto(pila3, menor);
	}

	public static int sumMenor(int[] pila1, int[] pila2, int[] pila3) {

		int suma1 = 0, suma2 = 0, suma3 = 0;

		for (int i = 0; i < pila1.length; i++)
			suma1 += pila1[i];

		for (int i = 0; i < pila2.length; i++)
			suma2 += pila2[i];

		for (int i = 0; i < pila3.length; i++)
			suma3 += pila3[i];

		int menor = suma1;

		if (menor > suma2)
			menor = suma2;

		if (menor > suma3)
			menor = suma3;

		return menor;
	}
}