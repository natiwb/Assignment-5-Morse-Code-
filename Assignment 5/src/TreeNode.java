
public class TreeNode<T> 
{
	TreeNode<T> left;
	TreeNode<T> right;
	T data;
	/*
	 * TreeNode

		public TreeNode(T dataNode)
		Create a new TreeNode with left and right child set to null and data set to the dataNode
		Parameters:
		dataNode - the data to be stored in the TreeNode
	 */
	/**
	 * Constructer 1 public TreeNode(T dataNode)
	 * @param dataNode
	 */
	public TreeNode(T dataNode) 
	{
		TreeNode<T> n=new TreeNode<T>();
		n.left=null;
		n.right=null;

		n.data=dataNode;
	}

	//blank constructor for regular
	public TreeNode() 
	{
		left=null;
		right=null;
		data=null;
		// TODO Auto-generated constructor stub
	}

	/*
	 * 	TreeNode

		public TreeNode(TreeNode<T> node)
		used for making deep copies
		Parameters:
		node - node to make copy of
	 */

	public TreeNode(TreeNode<T> node) 
	{
		TreeNode<T> deepCopy=new TreeNode<T>();

		//copying
		deepCopy.data=node.data;
		deepCopy.left=node.left;
		deepCopy.right=node.right;
	}

	/**
	 * getData

	public T getData()
	Return the data within this TreeNode
	Returns:
	the data within the TreeNode
	 */

	public T getData() 
	{
		return this.data;
	}



}
