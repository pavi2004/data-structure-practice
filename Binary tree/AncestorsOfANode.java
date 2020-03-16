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
class AncestorsOfANode
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
		else if(s[i]=='R')
			temp.right=newnode;
	}
	Boolean printAncestors(Node temp,int x)
	{
		if(temp == null)
			return false;
		if(temp.data == x)
			return true;
		if(printAncestors(temp.left,x)||printAncestors(temp.right,x))
		{
			System.out.println(temp.data);
			return true;
		}
		return false;
		
	}
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		AncestorsOfANode t=new AncestorsOfANode();
		System.out.println("Enter no of nodes");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Enter node to find ancestor:");
		int x=sc.nextInt();
		t.printAncestors(t.root,x);
	}
}