import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Runner {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>(Arrays.asList(20,30,40,15,10,11,25,32,5));
		
		//1 Create binary search tree
		BSTTree tree = new BSTTree();
		
		//Add the array list values to the binary search tree
		for(Integer i : listOfNumbers) {
			ItemData id = new ItemData(i);
			tree.add(id);
		}
		
		//Search for the number 25 and print out:
		//A) the properties for its ItemData object
		BSTNode node = tree.search(new ItemData(25));
		System.out.println("Value: " + node.getData().getValue() + "; Encoded Value: " + node.getData().getEncodedValue());
		
		//B) the ItemData data of the left and right nodes
		BSTNode leftNode = node.getLeft();
		System.out.println("Left Node: " + leftNode);
		
		BSTNode rightNode = node.getRight();
		System.out.println("Right Node: " + rightNode);
		
		System.out.println("");
		
		//Search for an ItemData that doesn't exist, ex: 100
		if(tree.search(new ItemData(100)) == null)
			System.out.println("100 not found");
		
		System.out.println("");
		
		//Remove the BST node that contains the number 5
		tree.delete(tree.getRoot(), new ItemData(5));
		
		//Print out the current contents of the tree
		//The iterator is doing in-order traversal
		Iterator<ItemData> itr = tree.iterator();
		while(itr.hasNext()) {
			ItemData current = itr.next();
			System.out.println("Value: " + current.getValue() + "; Encoded Value: " + current.getEncodedValue());
		}
	}
}
