public class ItemData {
	private int val, encodedValue;
	
	/*
	 * Constructs an ItemData object
	 * 
	 * @param data the value of the object
	 */
	public ItemData(int data) {
		this.val = data;
		this.encodedValue = val + 65;
	}
	
	/*
	 * Returns the value
	 * 
	 * @return the value
	 */
	public int getValue() {
		return this.val;
	}
	
	/*
	 * Returns the encoded value
	 * 
	 * @return the encoded value
	 */
	public int getEncodedValue() {
		return this.encodedValue;
	}

	/*
	 * Overrides the compareTo method
	 * 
	 * @param data the data of the object to compare to
	 * @return the comparison value
	 */
	public int compareTo(ItemData data) {
		Integer a = this.val;
		Integer b = data.val;
		return a.compareTo(b);
	}
}