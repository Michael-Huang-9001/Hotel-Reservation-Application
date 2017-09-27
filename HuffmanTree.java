
// Code based off of Harry Rybacki's implementation.

import java.util.*;

public class HuffmanTree {

	class HuffNode implements Comparable<HuffNode> {
		public int value;
		public int weight;
		public HuffNode leftTree;
		public HuffNode rightTree;
		public HuffNode parent;

		public HuffNode() {
			parent = null;
		}

		public HuffNode(int v, int w, HuffNode lTree, HuffNode rTree, HuffNode par) {
			value = v;
			weight = w;
			leftTree = lTree;
			rightTree = rTree;
			parent = par;
		}

		/**
		 * Compares nodes.
		 * 
		 * @return -1 is less than, 1 if greater than, 0 if equal.
		 */
		@Override
		public int compareTo(HuffNode rhs) {
			return weight - rhs.weight;
		}

		/**
		 * toString method for a node.
		 */
		@Override
		public String toString() {
			String str = "";
			str += this.value;
			return str;
		}
	}

	private int size = 0;
	private HuffNode root = new HuffNode();
	private PriorityQueue<HuffNode> huffQueue = new PriorityQueue();
	public ArrayList<String> pathTable = new ArrayList();
	public ArrayList<Character> valueTable = new ArrayList();

	public HuffmanTree(int[] freq, char[] code) {
		this.size = freq.length;

		if (freq.length != code.length) {
			throw new UnsupportedOperationException("Error: Character and code length mismatch.");
		}

		for (int i = 0; i < this.size; i++) {
			huffQueue.offer(new HuffNode(code[i], freq[i], null, null, null));
		}
		createTree();

		createTable(this.root, "");
	}

	/**
	 * Creates a HuffmanTree from frequencies and values
	 */
	private void createTree() {
		while (huffQueue.size() > 1) {
			HuffNode tempL = huffQueue.poll();
			HuffNode tempR = huffQueue.poll();

			HuffNode parent = new HuffNode(0, tempL.weight + tempR.weight, tempL, tempR, null);
			tempL.parent = parent;
			tempR.parent = parent;

			huffQueue.offer(parent);
			this.size++;
		}

		this.root = huffQueue.peek();
	}

	/**
	 * Creates a code table for a HuffmanTree.
	 * 
	 * @param HuffNode
	 *            root for tree, string for building paths
	 */
	private void createTable(HuffNode curr, String str) {
		if (curr == null)
			return;
		if (curr.leftTree == null && curr.rightTree == null) {
			char tempChar;
			if (curr.value == 32)
				tempChar = ' ';

			if (curr.value == 10)
				tempChar = 'n';

			else
				tempChar = (char) curr.value;
			// add value and path to code tables
			this.valueTable.add(tempChar);
			this.pathTable.add(str);
		}

		// add 0 if before moving to left child
		str += "0";
		// recursively call in pre-order
		createTable(curr.leftTree, str);

		// adjust path and add 1 before moving to right child
		str = str.substring(0, str.length() - 1);
		str += "1";
		createTable(curr.rightTree, str);
	}

	/**
	 * display given Huffman tree using preorder traversal
	 * 
	 * @param HuffNode
	 *            root of tree
	 */
	String tacks = "";

	public void getTree(HuffNode curr) {
		if (curr == null)
			return;

		if (curr.leftTree == null && curr.rightTree == null) {
			switch (curr.value) {
			case 32:
				System.out.println(tacks + curr.weight + ": sp");
				break;
			case 10:
				System.out.println(tacks + curr.weight + ": nl");
				break;
			default:
				System.out.println(tacks + curr.weight + ": " + (char) curr.value);
				break;
			}
		} else
			System.out.println(tacks + curr.weight);
		tacks += "- ";
		getTree(curr.leftTree);
		getTree(curr.rightTree);
		tacks = tacks.substring(0, tacks.length() - 2);
	}

	/**
	 * returns size of a given Huffman tree
	 * 
	 * @param HuffmanTree
	 *            the tree to measure
	 * @return int size of tree
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * returns encoded bits for a given string
	 * 
	 * @param String
	 *            to be encoded
	 * @return String encoded version of original string
	 */
	public String encode(String input) {
		String str = "";
		for (int x = 0; x < input.length(); x++) {
			for (int i = 0; i < valueTable.size(); i++) {
				if (valueTable.get(i) == input.charAt(x))
					str += pathTable.get(i);
			}
		}
		return str;
	}

	/**
	 * Used internally to get the frequency and code arrays.
	 * 
	 * @param password
	 *            the password to compress.
	 * @return a Map containing the frequencies and char array.
	 */
	public static HashMap<Character, Integer> getFreq(String password) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		char[] chars = password.toCharArray();
		for (char ch : chars) {
			if (freq.containsKey(ch)) {
				freq.put(ch, freq.get(ch) + 1);
			} else {
				freq.put(ch, 1);
			}
		}
		freq = sortByValue(freq);
		return (HashMap<Character, Integer>) freq;
	}

	/**
	 * Used internally to sort the character to frequency mappings, sort is
	 * based on frequency.
	 * 
	 * @param map
	 *            the map to sort.
	 * @return the sorted map.
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * Gets the char array from the map.
	 * 
	 * @param map
	 *            the map to get from.
	 * @return the char array.
	 */
	public static char[] getCharArray(Map<Character, Integer> map) {
		Set<Character> set = map.keySet();
		char[] chars = new char[set.size()];
		int i = 0;
		for (char ch : set) {
			chars[i++] = ch;
		}
		return chars;
	}

	/**
	 * Gets the frequency array from the map.
	 * 
	 * @param map
	 *            the map to get from.
	 * @return the frequency array.
	 */
	public static int[] getFreqArray(Map<Character, Integer> map) {
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		int[] freq = new int[set.size()];
		int i = 0;
		for (Map.Entry<Character, Integer> ch : set) {
			freq[i++] = ch.getValue();
		}
		return freq;
	}

	/**
	 * Method to encrypt a password using a HuffmanTree
	 * 
	 * @param pass
	 *            the password to encrypt.
	 * @return the encrypted binary string.
	 */
	public static String huff(String pass) {
		char[] chars = HuffmanTree.getCharArray(HuffmanTree.getFreq(pass));
		int[] freq = HuffmanTree.getFreqArray(HuffmanTree.getFreq(pass));
		HuffmanTree tree = new HuffmanTree(freq, chars);
		return tree.encode(pass);
	}

	/**
	 * A test program for the tree.
	 */
	public static void main(String[] args) {
		String pass = "Stacks are better than queues.";
		System.out.println("Password: " + pass);
		HashMap<Character, Integer> map = getFreq(pass);
		int[] freq = getFreqArray(map);
		char[] chars = getCharArray(map);
		String repass = "";
		for (char ch : chars) {
			repass += ch;
		}
		System.out.println(repass);
		for (int a : freq) {
			System.out.print(a);
		}
		System.out.println();
		System.out.println("Encode " + pass + ":\n" + huff(pass));
	}
}