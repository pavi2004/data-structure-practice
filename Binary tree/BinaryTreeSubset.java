import java.util.*;
class Node
{
	int data;
	Node left,right;
	Node(int d)
	{
		data=d;
	}
}
class BinaryTreeSubset
{
	Node root;
	void insert(char[] s, int d)
	{
		Node temp=root;
		Node newnode = new Node(d);
		if(temp==null && s[0]=='N')
		{
			root=newnode;
			return;
		}
		int i=0;
		while(i<s.length-1)
		{
			if(s[i]=='L' && temp.left!=null)
			{
				temp=temp.left;
				i++;
			}
			else if(s[i]=='R' && temp.right!=null)
			{
				temp=temp.right;
				i++;
			}
		}
		if(s[i]=='L')
		{
			temp.left=newnode;
		}
		else if(s[i]=='R')
		{
			temp.right=newnode;
		}
	}
	Boolean areIdentical(Node root1,Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		return root1.data==root2.data && areIdentical(root1.left,root2.left) && areIdentical(root1.right,root2.right);
	}
	Boolean isSubset(Node root1, Node root2)
	{
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(areIdentical(root1,root2))
			return true;
		return(isSubset(root1.left,root2) || isSubset(root1.right,root2));
	}
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		BinaryTreeSubset t1=new BinaryTreeSubset();
		BinaryTreeSubset t2=new BinaryTreeSubset();
		System.out.println("Enter no of nodes of tree1");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t1.insert(s,d);
		}
		System.out.println("Enter no of nodes of tree2");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t2.insert(s,d);
		}
		if(t1.isSubset(t1.root,t2.root))
		{
			System.out.println("tree2 is subset of tree1");
		}
		else
		{
			System.out.println("tree2 is subset of tree1");
		}
	}
}