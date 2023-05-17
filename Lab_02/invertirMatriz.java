import java.util.Arrays;

public class invertirMatriz{
    public static void main (String args[]){
        int[] array =  {1, 2, 3};
        imprimirArray(invertirArray(array));
    }

    public static int[] invertirArray(int[] x){
        int i = 0;
        int j = x.length - 1;
        while(i < j){
            int k = x[i];
            x[i] = x[j];
            x[j] = k;
            i++;
            j--;
        }

        return x; 
    }

    public static void imprimirArray(int[]x){
        for(int i: x)
            System.out.println(i);
    }
}