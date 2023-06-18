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

        DobleList<Integer>[] array = new DobleList[tamano];  // Arreglo de listas doblemente enlazadas
        for (int i = 0; i < tamano; i++) {
            array[i] = new DobleList<>();  // Crear una nueva lista doblemente enlazada
            for (int y = 1; y <= i + 1; y++) {
                array[i].insertFinal(y);  // Insertar elementos en la lista actual
            }
            array[i].generarPeoresCasos();  // Generar peores casos para la lista actual
        }

        try {
            times(array, tamano);  // Calcular los tiempos de ejecución y escribir en un archivo
        } catch (IOException ex) {
            // Manejo de excepciones en caso de error de escritura en archivo
        }

        JavaPlot p = new JavaPlot();
        p.addPlot(" 'D:/EDA_LAB_D/Lab_04/Ejercicio02/insercion.txt' with lines");  // Agregar un gráfico desde un archivo de datos
        p.plot();  // Mostrar el gráfico

    }

    public static void times(DobleList array[], int tamano) throws IOException {

        String archivoInsersion = "insercion.txt";  // Nombre del archivo de salida
        FileWriter escritor = new FileWriter(archivoInsersion);  // Crear un escritor de archivos
        // escritor.write("Numero\tTiempo\n");

        for (int i = 0; i < tamano; i++) {
            long nano_start = System.nanoTime();  // Tiempo inicial en nanosegundos
            array[i].insertionSort();  // Ordenar la lista actual
            long nano_end = System.nanoTime();  // Tiempo final en nanosegundos
            long time = nano_end - nano_start;  // Calcular el tiempo de ejecución
            escritor.write(i + 1 + "\t" + time + "\n");  // Escribir el número de elementos y el tiempo en el archivo
        }
        escritor.close();  // Cerrar el escritor de archivos
    }

}
