package lab14;

import java.util.*;

public class AmoebaFamily {

	private Amoeba myRoot = null;

	// A constructor that starts an Amoeba family with an amoeba
	// with the given name.
	public AmoebaFamily(String name) {
		myRoot = new Amoeba(name, null);
	}

	// Add a new amoeba named childName as the youngest child
	// of the amoeba named parentName.
	// Precondition: the amoeba family contains an amoeba named parentName.
	public void addChild(String parentName, String childName) {
		if (myRoot != null) {
			AmoebaFamily.addChildHelper(parentName, childName, myRoot);
		}
	}

	public static void addChildHelper(String parentName, String childName,
			Amoeba currentAmoeba) {
		if (currentAmoeba.myName.equals(parentName)) {
			currentAmoeba.addChild(childName);
		} else {
			Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
			while (iter.hasNext()) {
				AmoebaFamily.addChildHelper(parentName, childName, iter.next());
			}
			/*
			 * Here is another way to loop through all of the children 
			 * for (int i = 0; i< currentAmoeba.myChildren.size(); i++) {
			 *    AmoebaFamily.addChildHelper(parentName, childName,
			 *    currentAmoeba.myChildren.get(i)); 
			 * }
			 */
		}
	}

	// Makes all Amoeba names only lower case letters.
	public void makeNamesLowercase() {
		// Your goal is to make this as similar as possible to addChild
		if (myRoot != null) {
			AmoebaFamily.makeNamesLowercaseHelper(myRoot);
		}
	}

	// Static helper method for makeNamesLowercase
	public static void makeNamesLowercaseHelper(Amoeba currentAmoeba) {
		// Your goal is to make this as similar as possible to addChildHelper
		currentAmoeba.myName.toLowerCase();
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		while (iter.hasNext()) {
			makeNamesLowercaseHelper(iter.next());
		}
	}

	// Replaces the name of an amoeba named currentName with the name newName.
	// Precondition: the amoeba family contains an amoeba named currentName.
	public void replaceName(String currentName, String newName) {
		// Your goal is to make this as similar as possible to addChild
		if (myRoot != null) {
			AmoebaFamily.replaceNameHelper(currentName, newName, myRoot);
		}
	}

	// Static helper method for replaceName
	public static void replaceNameHelper(String currentName, String newName,
			Amoeba currentAmoeba) {
		// Your goal is to make this as similar as possible to addChildHelper
		if (currentAmoeba.myName.equals(currentName)) {
			currentAmoeba.myName = newName;
		} else {
			Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
			while (iter.hasNext()) {
				replaceNameHelper(currentName, newName, iter.next());
			}
		}
	}

	// Print the names of all amoebas in the family.
	// later you will write print() that has more interesting formatting
	public void printFlat() {
		// Your goal is to make this as similar as possible to addChild
		if (myRoot != null) {
			AmoebaFamily.printFlatHelper(myRoot);
		}
	}

	// Static helper method for printFlat
	public static void printFlatHelper(Amoeba currentAmoeba) {
		// Your goal is to make this as similar as possible to addChildHelper
		System.out.print(currentAmoeba.myName + " ");
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		while (iter.hasNext()) {
			printFlatHelper(iter.next());
		}
	}

	// Print the names of all amoebas in the family.
	// Names should appear in preorder, with children's names
	// printed oldest first.
	// Members of the family constructed with the main program above
	// should be printed in the following sequence:
	// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
	// Bill, Hilary, Fred, Wilma
	public void print() {
		if (myRoot != null) {
			AmoebaFamily.printHelper(myRoot, "");
		}
	}
	
	public static void printHelper(Amoeba currentAmoeba, String indentLevel) {
		System.out.println(indentLevel + currentAmoeba.myName);
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		indentLevel += "    ";
		while (iter.hasNext()) {
			printHelper(iter.next(), indentLevel);
		}
	}

	// returns the length of the longest name in the Amoeba Family
	public int longestNameLength() {
		if (myRoot != null) {
			return AmoebaFamily.longestNameLengthHelper(myRoot);
		}
		return 0;

	}

	// Static helper method for longestName
	public static int longestNameLengthHelper(Amoeba currentAmoeba) {
		int maxLengthSeen = currentAmoeba.myName.length();
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		while (iter.hasNext()) {
			int childMaxLengthSeen = AmoebaFamily.longestNameLengthHelper(iter
					.next());
			if (childMaxLengthSeen > maxLengthSeen) {
				maxLengthSeen = childMaxLengthSeen;
			}
		}
		return maxLengthSeen;
	}

	// instead of returning the length of the longest name, this method should
	// return the name that is longest.
	public String longestName() {
		// your goal is to make this look as similar as possible to
		// longestNameLength
		if (myRoot != null) {
			return AmoebaFamily.longestName(myRoot);
		}
		return "";
	}

	// Static helper method for longestName
	public static String longestName(Amoeba currentAmoeba) {
		// your goal is to make this look as similar as possible to
		// longestNameLengthHelper
		String longestAmoebaName = currentAmoeba.myName;
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		while (iter.hasNext()) {
			String childMaxLengthSeen = AmoebaFamily.longestName(iter.next());
			if (childMaxLengthSeen.length() > longestAmoebaName.length()) {
				longestAmoebaName = childMaxLengthSeen;
			}
		}
		return longestAmoebaName;
	}
	
	public void size() {
		if (myRoot != null) {
			AmoebaFamily.sizeHelper(myRoot);
		}
		return;
	}
	
	public static void sizeHelper(Amoeba currentAmoeba) {
		Iterator<Amoeba> iter = currentAmoeba.myChildren.iterator();
		while (iter.hasNext()) {
			sizeHelper(iter.next());
		
		}
	}

	// Return an iterator of the amoeba family.
	public Iterator<Amoeba> allAmoebas() {
		return new AmoebaIterator();
	}

	public static void main(String[] args) {
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.addChild("Marge", "Bill");
		family.addChild("Marge", "Hilary");
		System.out.println("Here's the family:");
		family.print();
		
		System.out.println (""); System.out.println ("Here it is again!");
		Iterator<Amoeba> iter = family.allAmoebas ( ); while (iter.hasNext (
		)) { System.out.println (iter.next ( )); }
		 
	}

	public class AmoebaIterator implements Iterator<Amoeba> {
		// Amoebas in the family are enumerated in preorder,
		// with children enumerated oldest first.
		// Members of the family constructed with the main program above
		// should be enumerated in the following sequence:
		// Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
		// Bill, Hilary, Fred, Wilma
		// Complete enumeration of a family of N amoebas should take
		// O(N) operations.

		// You will supply the details of this class in a future lab.
		
		private Queue fringe = new LinkedList();

		public AmoebaIterator() {
			if (myRoot != null) {
				fringe.add(myRoot);
			}
		}

		public boolean hasNext() {
			return !fringe.isEmpty();
		}

		public Amoeba next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements in the tree.");
			}
			Amoeba amoeba = (Amoeba) fringe.remove();
			
			if (amoeba.myChildren != null) {
				Iterator it = amoeba.myChildren.iterator();
				while (it.hasNext()) {
					fringe.add(it.next());
				}
			}
			return amoeba;
		}

		public void remove() {
			// not used
		}

	} // end of AmoebaIterator nested class

	private static class Amoeba {

		public String myName; // amoeba's name
		public Amoeba myParent; // amoeba's parent
		public ArrayList<Amoeba> myChildren; // amoeba's children

		public Amoeba(String name, Amoeba parent) {
			myName = name;
			myParent = parent;
			myChildren = new ArrayList<Amoeba>();
		}

		public String toString() {
			return myName;
		}

		public Amoeba parent() {
			return myParent;
		}

		// Add an amoeba with the given name as this amoeba's youngest child.
		public void addChild(String childName) {
			Amoeba child = new Amoeba(childName, this);
			myChildren.add(child);
		}
	}
} // closes definition of AmoebaFamily class