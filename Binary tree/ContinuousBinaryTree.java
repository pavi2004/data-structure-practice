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
class ContinuousBinaryTree
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
	Boolean isContinuous(Node temp)
	{
		if(temp==null)
			return true;
		if(temp.left==null && temp.right==null)
			return true;
		if(temp.right==null)
			return Math.abs(temp.data-temp.left.data)==1 && isContinuous(temp.left);
		if(temp.left==null)
			return Math.abs(temp.data-temp.right.data)==1 && isContinuous(temp.right);
		
		return Math.abs(temp.data-temp.left.data)==1 && isContinuous(temp.left) && Math.abs(temp.data-temp.right.data)==1 && isContinuous(temp.right);
		
	}
	public static void main(String args[])
	{
		ContinuousBinaryTree t=new ContinuousBinaryTree();
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
		if(t.isContinuous(t.root))
		{
			System.out.println("it is continuous");
		}
		else
		{
			System.out.println("it is not continuous");
		}
	}
}