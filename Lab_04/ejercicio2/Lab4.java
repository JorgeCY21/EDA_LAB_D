package lab4;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        int tamano;
        Scanner teclado = new Scanner( System.in );
        System.out.print( "Introduzca el tamaño del arreglo: " );
       // tamano = teclado.nextInt();
        //int arreglo[] = generarPeorCaso(ta|mano);
        
        DobleList <Integer> listDoble = new DobleList<>();
        for(int i=0;i<=100;i++){
            listDoble.insertFinal(i);
        }
        System.out.println(listDoble.toString());
        listDoble.generarPeoresCasos();
        System.out.println(listDoble.toString());
        
        long nano_start = System.nanoTime();
        listDoble.selecctionSort();
        long nano_end = System.nanoTime();
        System.out.println(nano_end-nano_start);
    }
    
        
        
        
}

