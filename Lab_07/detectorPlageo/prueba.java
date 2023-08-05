import java.util.Scanner;
public class prueba {
    public static void main(String[] args){
        PlagiarismChecker noesCopiaesPlageo = new PlagiarismChecker();
        String[] archivos = {"enanitos.txt", "ositos.txt", "risitos.txt"};
        if(noesCopiaesPlageo.loadFiles(archivos)){
            System.out.println("Archivos cargados correctamente");
        }
        else
            System.out.println("no se cargo xd");
        ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese texto:");
        String entrada = sc.next();
        noesCopiaesPlageo.verifyPlagiarism(entrada);
    }
}
