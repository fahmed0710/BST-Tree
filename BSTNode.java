public class BSTNode {
	private ItemData data;
	private BSTNode left, right;
		
	public BSTNode(ItemData data) {
		this.data = data;
	}
	
	public ItemData getData() {
		return this.data;
	}
	
	public void setData(ItemData data) {
		this.data = data;
	}
	
	public BSTNode getLeft() {
		if(this.left == null)
			return null;
		return this.left;
	}
	
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	
	public BSTNode getRight() {
		if(this.right == null)
			return null;
		return this.right;
	}
	
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	/*
	 * Adds a new node
	 * 
	 * @param newNode the new node
	 */
	public void addBSTNode(BSTNode newNode) {
		int comparison = newNode.data.compareTo(this.data);
		if(comparison < 0) {
			if(left == null) {
				left = newNode;
			}
			else
				left.addBSTNode(newNode);
		}
		else if(comparison > 0)
			if(right == null) {
				right = newNode;
			}
			else
				right.addBSTNode(newNode);		
	}
}