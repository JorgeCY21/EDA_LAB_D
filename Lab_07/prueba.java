import java.util.Scanner;
public class prueba {
    public static void main(String[] args){
        PlagiarismChecker noesCopiaesPlageo = new PlagiarismChecker();
        String[] archivos = {"enanitos.txt", "ositos.txt", "risitos.txt"};
        noesCopiaesPlageo.loadFiles(archivos);
        Scanner sc = new Scanner(System.in);
        String entrada = sc.next();
        noesCopiaesPlageo.verifyPlagiarism(entrada);
    }
}
