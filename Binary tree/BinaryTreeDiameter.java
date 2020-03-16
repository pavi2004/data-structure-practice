import java.util.*;
import java.lang.Math;
class Node
{
	Node left,right;
	int data;
	Node(int d)
	{
		this.data=d;
		this.left=this.right=null;
	}
}
class BinaryTreeDiameter
{
	Node root;
	int diameter=0;
	void insert( char[] s,int d)
	{
		Node newnode=new Node(d);
		Node temp=root;
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
			if(s[i]=='R' && temp.right!=null)
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
	int height(Node temp)
	{
		if(temp==null)
		{
			return 0;
		}
		int lh=height(temp.left);
		int rh=height(temp.right);
		diameter=Math.max(diameter,lh+rh+1);
		return Math.max(lh,rh)+1;
		
	}
	void inorder(Node temp)
	{
		if(temp!=null)
		{
			inorder(temp.left);
			System.out.print(temp.data+" ");
			inorder(temp.right);
		}
	}
	public static void main(String rpd[])
	{
		BinaryTreeDiameter t=new BinaryTreeDiameter();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes :");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Inorder :");
		t.inorder(t.root);
		System.out.println("Max depth or height of a tree: "+t.height(t.root));
		System.out.println("Diameter of the tree :"+t.diameter);
		
	}
}