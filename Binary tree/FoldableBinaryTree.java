import java.util.*;
class Node
{
	int data;
	Node left,right;
	Node (int d)
	{
		data=d;
	}
}
class FoldableBinaryTree
{
	Node root;
	void insert(char[] s,int d)
	{
		Node temp=root;
		Node newnode= new Node(d);
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
			temp.left=newnode;
		else
			temp.right=newnode;
	}
	Boolean isFoldable(Node temp)
	{
		Boolean res;
		if(temp==null)
			return true;
		mirror(temp.left);
		res=isStructured(temp.left,temp.right);
		mirror(temp.left);
		return res;
	}
	void mirror(Node temp)
	{
		if(temp==null)
			return;
		else
		{
			Node temp1;
			mirror(temp.left);
			mirror(temp.right);
			temp1=temp.left;
			temp.left=temp.right;
			temp.right=temp1;
			
		}
	}
	Boolean isStructured(Node l,Node r)
	{
		if(l==null && r==null)
			return true;
		if(l!=null && r!=null && isStructured(l.left,r.left) && isStructured(l.right,r.right))
			return true;
		return false;
	}
	public static void main(String args[])
	{
		FoldableBinaryTree t=new FoldableBinaryTree();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char [] s=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		if(t.isFoldable(t.root))
		{
			System.out.println("it is Foldable");
		}
		else
		{
			System.out.println("it is not Foldable");
		}
	}
}
