package lab4;

import java.io.FileWriter;
import java.io.IOException;
import com.panayotis.gnuplot.JavaPlot;

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño del arreglo: ");
        tamano = teclado.nextInt();

        DobleList<Integer>[] array = new DobleList[tamano];
        for (int i = 0; i < tamano; i++) {
            array[i] = new DobleList<>();
            for (int y = 1; y <= i + 1; y++) {
                array[i].insertFinal(y);
            }
            array[i].generarPeoresCasos();
            // System.out.println(array[i]);
        }

        try {
            times(array, tamano);
        } catch (IOException ex) {

        }

        JavaPlot p = new JavaPlot();
        // plot 'D:\KARIM\Lab4/insercion.txt' with lines;
        p.addPlot(" 'D:/EDA_LAB_D/Lab_04/Ejercicio02/insercion.txt' with lines");
        p.plot();

    }

    public static void times(DobleList array[], int tamano) throws IOException {

        String archivoInsersion = "insercion.txt";
        FileWriter escritor = new FileWriter(archivoInsersion);
        // escritor.write("Numero\tTiempo\n");

        for (int i = 0; i < tamano; i++) {
            long nano_start = System.nanoTime();
            array[i].insertionSort();
            // System.out.println("uwu"+array[i]);
            long nano_end = System.nanoTime();
            long time = nano_end - nano_start;
            escritor.write(i + 1 + "\t" + time + "\n");
        }
        escritor.close();
    }

}
