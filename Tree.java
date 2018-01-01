package Glenn_Noah_A4;

import java.util.ArrayList;
import Glenn_Noah_A4.Node;

public class Tree {
	
	int frequency = 0; // placeholder for frequency of letter
	String userInput; // Placeholder for user input
	ArrayList <Node> nodes = new ArrayList <Node> (); // Array list holding Nodes
	ArrayList <String> uniques = new ArrayList <String> (); // Array list holding individual letters
	
	Tree (String userIO){
		// creates an array of strings one of each character
		userInput = userIO;
		String [] token = userInput.split("");
		
		// checks each letter
		for (int i = 0; i < userInput.length(); i++){
			
			if(!uniques.contains(token[i])){
				uniques.add(token[i]);
			}
		}
		
		// creates a node for each unique character
		for (int i = 0; i < uniques.size(); i++) {
			nodes.add(new Node(uniques.get(i)));
		}

		// checks frequency of each character
		for (int i = 0; i < nodes.size(); i++){
			String test = nodes.get(i).getData();
			frequency = userInput.length()-userInput.replace(test, "").length();
			nodes.get(i).setWeight(frequency);
		}
	}
	
	
	// Purpose: To display current set of Nodes
	// Arguments: none
	// Return values: none
	public void display(){
		System.out.println("Character:\t\tCount:");
		
		for(int i = 0; i < nodes.size(); i++){
	
			if(nodes.get(i).getParent() == null){
				System.out.println(nodes.get(i).getData() + "\t\t\t" + nodes.get(i).getWeight());
			}
		}
	}
	
	// Purpose: To sort current set of Nodes
	// Arguments: none
	// Return values: none
	public void sortNodes(){
		
		boolean swap = true; // bool that determines if a swap occurred
		
		while (swap) {
			
			swap = false;
			
			for (int i = 1; i < nodes.size(); i++) {
				
				if (nodes.get(i-1).getWeight() > nodes.get(i).getWeight()) {
				
					Node temp = nodes.get(i-1);
					nodes.set(i-1, nodes.get(i));
					nodes.set(i, temp);
					swap = true;
				}
			}
		}
	}
	
	// Purpose: To combine two nodes to form a parent node
	// Arguments: int index of nodes to combine
	// Return values: none
	public void combineNodes(int index) {
		nodes.add(new Node(nodes.get(index), nodes.get(index+1)));
	}
	
	// Purpose: To check if a root has been created
	// Arguments: none
	// Return values: boolean root
	public boolean checkRoot() {
		
		boolean root = false;
		int count = 0;
		
		for(int i = 0; i < nodes.size(); i++){
			
			if (nodes.get(i).getParent() == null)
				count++;
		}
		
		if (count == 1)
			root = true;
		
		return root;
	}
}
