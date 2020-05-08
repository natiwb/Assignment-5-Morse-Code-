import java.util.ArrayList;

public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String> 
{
	/**
	 * MorseCodeTree() 
          Constructor - calls the buildTree method
	 */
	TreeNode<String> root;

	public MorseCodeTree() 
	{
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() 
	{
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		root=newNode;
	}
	/**
	 * public MorseCodeTree insert(java.lang.String code,
                            java.lang.String letter)
Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
Specified by:
insert in interface LinkedConverterTreeInterface<java.lang.String>
Parameters:
@param code - the code for the new node to be added, example ".-."
letter - the letter for the corresponding code, example "r"
Returns:
@return the MorseCodeTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) 
	{
		this.addNode(root,code,result);

		return this;
	}

	/**
	 * public void addNode(TreeNode<java.lang.String> root,
                    java.lang.String code,
                    java.lang.String letter)
	This is a recursive method that adds element to the correct position in the tree based on the code.
 	A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
 	The code ".-" would be stored as the right child of the left child of the root Algorithm for the
 	 recursive method:
	1. if there is only one character
	a. if the character is '.' (dot) store to the left of the current root
	b. if the character is "-" (dash) store to the right of the current root
	c. return
	2. if there is more than one character
	a. if the first character is "." (dot) new root becomes the left child
	b. if the first character is "-" (dash) new root becomes the right child
	c. new code becomes all the remaining charcters in the code (beyond the first character)
	d. call addNode(new root, new code, letter)
	Specified by:
	addNode in interface LinkedConverterTreeInterface<java.lang.String>
	Parameters:
	@param root - the root of the tree for this particular recursive instance of addNode
	@param code - the code for this particular recursive instance of addNode
	@param letter - the data of the new TreeNode to be added
	 */

	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.length()<=1) 
		{
			if(code.equals(".")) 
			{
				root.left=new TreeNode<String>(letter);
			}

			else if(code.equals("-")) 
			{
				root.right=new TreeNode<String>(letter);
			}
		}
		else
		{
			if(code.charAt(0)=='.') 
			{
				addNode(root.left,code.substring(1),letter);
			}

			else if(code.charAt(0)=='-') 
			{
				addNode(root.right,code.substring(1),letter);
			}

		}

	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
Specified by:
fetch in interface LinkedConverterTreeInterface<java.lang.String>
Parameters:
@param code - the code that describes the traversals to retrieve the string (letter)
Returns:
@return letter- the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) 
	{
		String letter=fetchNode(this.root,code);
		return letter;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
Specified by:
fetchNode in interface LinkedConverterTreeInterface<java.lang.String>
Parameters:
@param root - the root of the tree for this particular recursive instance of addNode
@param code - the code for this particular recursive instance of addNode
Returns:
@return the string (letter) corresponding to the code

	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{
		String letter=null;

		if(code.length()<=1) 
		{
			if(code.equals(".")) 
			{
				letter=root.left.getData();
				return letter;
			}

			else if(code.equals("-")) 
			{
				letter=root.right.getData();
				return letter;
			}
		}
		else
		{
			if(code.charAt(0)=='.') 
			{
				return fetchNode(root.left,code.substring(1));
			}

			else if(code.charAt(0)=='-') 
			{
				return fetchNode(root.right,code.substring(1));
			}
		}
		return letter;

	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException 
	{
		return null;
	}


	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 *  The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t");
	 *   level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc.
	 *    Look at the tree and the table of codes to letters in the assignment description.
Specified by:
buildTree in interface LinkedConverterTreeInterface<java.lang.String>
	 */
	@Override
	public void buildTree() 
	{
		root=new TreeNode<String>(""); //root
		insert(".","e");//lvl1
		insert("-", "t");

		insert("..", "i");//lvl2
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");//lvl3
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");//lvl4
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
Specified by:
toArrayList in interface LinkedConverterTreeInterface<java.lang.String>
Returns:
an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> toArrayList=new ArrayList<String>();
		LNRoutputTraversal(root,toArrayList);
		return toArrayList;
	}

	/**
	 * public void LNRoutputTraversal(TreeNode<java.lang.String> root,
                               java.util.ArrayList<java.lang.String> list)
The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
Specified by:
LNRoutputTraversal in interface LinkedConverterTreeInterface<java.lang.String>
Parameters:
root - the root of the tree for this particular recursive instance
list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		//Inorder (Left, Root, Right)
		if(root!=null) 
		{
			LNRoutputTraversal(root.left,list);
		}
		else
			list.add(root.getData());

	}
}
