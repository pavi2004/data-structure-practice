class Node
{
	int data;
	Node left;
	Node right;
	Node(int d){
		data=d;
	}
}
class LevelOrderInsertion{
	Node root;
	Node insertLevelOrder(int[] arr,Node root,int i)
	{
		if(i<arr.length)
		{
			Node temp=new Node(arr[i]);
			root=temp;
			root.left=insertLevelOrder(arr,root.left,i*2+1);
			root.right=insertLevelOrder(arr,root.right,i*2+2);
		}
		return root;
	}
	void inorder(Node root)
	{
		if(root!=null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	public static void main(String args[])
	{
		LevelOrderInsertion t=new LevelOrderInsertion();
		int arr[]={1,2,3,4,5,6,7,8,9};
		t.root=t.insertLevelOrder(arr,t.root,0);
		t.inorder(t.root);
	}
}