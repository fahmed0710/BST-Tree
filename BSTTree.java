import java.util.ArrayList;
import java.util.Iterator;

public class BSTTree implements Iterable<ItemData> {
	BSTNode root;
	
	public BSTNode getRoot() {
		return this.root;
	}
	/*
	 * Adds a new node to the tree
	 * 
	 * @param value the value of the new node to be added
	 */
	public void add(ItemData value) {
		BSTNode newNode = new BSTNode(value);
		newNode.setLeft(null);
		newNode.setRight(null);
		if(root == null) {
			root = newNode;
		}
		else {
			root.addBSTNode(newNode);
		}
	}
		
	/*
	 * Searches for the node with the specified data
	 * Referenced from: 
	 * https://www.tutorialspoint.com/data_structures_algorithms/binary_search_tree.htm
	 * 
	 * @param value the value of the node to be searched for
	 */
	public BSTNode search(ItemData value) {
		BSTNode current = root;
		while(current.getData().getValue() != value.getValue()) {
			if(current != null) {
				if(current.getData().getValue() > value.getValue()) 
					current = current.getLeft();
				else 
					current = current.getRight();
				if(current == null)
					return null;
			}
		}
		return current;
	}
	
	/*
	 * Deletes a node from the tree
	 * Referenced from:
	 * https://www.geeksforgeeks.org/delete-leaf-nodes-value-x/
	 * 
	 * @param root the root to search from
	 * @param value the value of the node to be deleted
	 * @return the root
	 */
	public BSTNode delete(BSTNode root, ItemData value) {
		if(root == null)
			return null;
		root.setLeft(delete(root.getLeft(),value));
		root.setRight(delete(root.getRight(),value));
		
		if(root.getData().getValue() == value.getValue() &&
		   root.getLeft() == null && root.getRight() == null)
			return null;
		
		return root;
	}
	
	/*
	 * Traverses through the tree with in-order traversal
	 * 
	 * @return an iterator
	 */
	public Iterator<ItemData> iterator() {
		ArrayList<ItemData> list = new ArrayList<>();
		collectRecurse(root,list);
		return list.iterator();
	}
	
	private void collectRecurse(BSTNode node, ArrayList<ItemData> list) {
		if(node == null)
			return;
		collectRecurse(node.getLeft(),list);
		list.add(node.getData());
		collectRecurse(node.getRight(),list);
	}
}
