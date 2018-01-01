package Glenn_Noah_A4;

public class Node {
	
	private String data; // holds Nodes String
	private int weight = 0; // frequency of each character
	private Node parent; // parent of current node
	private Node [] children = new Node [2]; // children of current node
	
	// Purpose: To create a new node
	// Arguments: Individual character stored as a String
	Node(String input){
		data = input;
	}
	
	
	// Purpose: To create a parent Node
	// Arguments: Two children both Nodes
	Node(Node child1, Node child2){
		
		// sets data, weight and children of new parent Node
		data = child1.getData() + child2.getData();
		weight = child1.getWeight() + child2.getWeight();
		children[0] = child1;
		children[1] = child2;
		
		// Updates child Nodes parent
		child1.setParent(this);
		child2.setParent(this);
		
		// display changes 
		System.out.print("Combined node " + child1.getData() + " (weight: " + child1.getWeight() + ") with node " + child2.getData());
		System.out.println(" (weight: " + child2.getWeight() + ") to produce node " + data + " (weight: " + weight + ")");
	}
	
	// Purpose: To change String of Node
	// Arguments: String input
	// Return values: none
	public void setData(String input){
		data = input;
	}

	// Purpose: To change weight of Node
	// Arguments: int frequency
	// Return values: none
	public void setWeight(int frequency){
		weight = frequency;
	}
	
	// Purpose: To change Parent of Node
	// Arguments: Node input
	// Return values: none
	public void setParent(Node input){
		parent = input;
	}
	
	// Purpose: To return String of Node
	// Arguments: 
	// Return values: String data
	public String getData(){
		return data;
	}
	
	// Purpose: To return weight of Node
	// Arguments: none
	// Return values: int weight
	public int getWeight(){
		return weight;
	}
	
	// Purpose: To return parent of Node
	// Arguments: String input
	// Return values: none
	public Node getParent(){
		return parent;
	}
}
