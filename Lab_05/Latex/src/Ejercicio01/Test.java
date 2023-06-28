import java.util.Scanner;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		TreeAVL<Integer> treeAvl = new TreeAVL<>();
		String input = scan.next();		
				
		for(char c: input.toCharArray()) {
			int asciiValue = (int)c;
			treeAvl.insert(asciiValue);
		}
		
		System.out.println("dibujando...");
		
		Graph graph = new SingleGraph("Tree AVL");
        graph.setAttribute("ui.stylesheet", "node { size: 20px; text-size: 15px; }");
        graph.setStrict(false);
        System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing.SwingGraphRenderer");
        
        visualizeTree(treeAvl.getRoot(), graph);

        graph.display();
                
		System.out.println("Minimum value: " + treeAvl.getMin()); // Valor mínimo: 10
		System.out.println("Maximum value: " + treeAvl.getMax()); // Valor máximo: 50

		System.out.println("Buscar 30: " + treeAvl.search(30)); // Búsqueda de 30: true
		System.out.println("Buscar 60: " + treeAvl.search(60)); // Búsqueda de 60: false

		treeAvl.remove(30);

		System.out.println("Buscar 30 después de eliminarlo: " + treeAvl.search(30)); // Búsqueda de 30 después de
																					// eliminarlo: false
		
		
		
	}
	
	private static void visualizeTree(NodeAvl<Integer> node, Graph graph) {
		if (node != null) {
            graph.addNode(String.valueOf(node.getData())).setAttribute("ui.label", node.getData());
            if (node.getLeft() != null) {
                visualizeTree(node.getLeft(), graph);
                graph.addEdge(node.getData() + "-" + node.getLeft().getData(), String.valueOf(node.getData()), String.valueOf(node.getLeft().getData()));
            }
            if (node.getRight() != null) {
                visualizeTree(node.getRight(), graph);
                graph.addEdge(node.getData() + "-" + node.getRight().getData(), String.valueOf(node.getData()), String.valueOf(node.getRight().getData()));
            }
        }
		
	}

}
