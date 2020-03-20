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
class BinaryTreeLCA
{
	Node root;
	void insert(char[] s,int d)
	{
		Node newnode= new Node(d);
		Node temp=this.root;
		int i=0;
		if(temp==null && s[i]=='n')
		{
			this.root=newnode;
			return;
		}
		while(i<s.length-1)
		{
			if(s[i]=='L' && temp.left!=null)
			{
				temp=temp.left;
			}
			else if(s[i]=='R' && temp.right!=null)
			{
				temp=temp.right;
			}
			i++;
		}
		if(s[s.length-1]=='L')
			temp.left=newnode;
		else
			temp.right=newnode;
	}
	static boolean v1 = false, v2 = false; 
	Node findLCAUtil(Node node, int n1, int n2) 
	{ 
		if (node == null) 
			return null; 
		
		Node temp=null; 

		if (node.data == n1) 
		{ 
			v1 = true; 
			temp = node; 
		} 
		if (node.data == n2) 
		{ 
			v2 = true; 
			temp = node; 
		} 

		Node leftLca = findLCAUtil(node.left, n1, n2); 
		Node rightLca = findLCAUtil(node.right, n1, n2); 

		if (temp != null) 
			return temp; 

		if (leftLca != null && rightLca != null) 
			return node; 

		return (leftLca != null) ? leftLca : rightLca; 
	} 

	Node findLCA(int n1, int n2) 
	{ 
		v1 = false; 
		v2 = false; 

		Node lca = findLCAUtil(root, n1, n2); 

		if (v1 && v2) 
			return lca; 

		return null; 
	} 
	public static void main(String args[])
	{
		BinaryTreeLCA t = new BinaryTreeLCA();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes:");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char s[]=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Enter no of lCA:");
		int m=sc.nextInt();
		for(int i=0;i<m;i++)
		{
			int d1=sc.nextInt();
			int d2=sc.nextInt();
			Node lca = t.findLCA(d1, d2); 
			if (lca != null) 
				System.out.println("LCA = " + lca.data); 
			else
				System.out.println("Keys are not present"); 
		}
	}
		
}