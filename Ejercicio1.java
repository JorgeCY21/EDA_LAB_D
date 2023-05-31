public class Ejercicio1{
    public void sacarPilas (int [] pila1, int [] pila2, int [] pila3) {

        int menor = sumMenor(pila1, pila2, pila3);
        
    }
        
        
    public int sumMenor(int[] pila1, int[] pila2, int[] pila3) {
        
        int suma1 = 0, suma2 = 0, suma3 = 0;
        
        for(int i = 0 ; i < pila1.length; i++)
        suma1 += pila1[i];
        
        for(int i = 0 ; i < pila2.length; i++)
        suma2 += pila2[i];
        
        for(int i = 0 ; i < pila3.length; i++)
        suma3 += pila3[i];
        
        int menor = suma1;
        
        if(menor > suma2)
        menor = suma2;
        
        if(menor > suma3)
        menor = suma3;
        
        return menor;
    }
}