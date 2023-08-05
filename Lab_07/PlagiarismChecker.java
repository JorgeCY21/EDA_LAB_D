import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class PlagiarismChecker {
    static Trie docs = new Trie();


    public boolean loadFiles(String[] paths ){
        //lenar las estructuras
        //lectura del archivos
        for(String path : paths){
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String linea;
                // Leer el archivo línea por línea
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    docs.insert(linea);
                    docs.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /*
     * 
     */
    public ResultChecker verifyPlagiarism(String path){
        ResultChecker result = null;
        return result;
    }
}
