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
class KDistantNode
{
	Node root;
	void insert(char[] s,int d)
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
	void printKDistantNode(Node temp,int k)
	{
		if(temp==null)
			return;
		if(k==0)
		{
			System.out.println(temp.data+" ");
			return;
		}
		printKDistantNode(temp.left,k-1);
		printKDistantNode(temp.right,k-1);
	}
	public static void main(String arg[])
	{
		Scanner sc= new Scanner(System.in);
		KDistantNode t=new KDistantNode();
		System.out.println("Enter no of nodes");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Enter distance:");
		int k=sc.nextInt();
		System.out.println("thr nodes are:");
		t.printKDistantNode(t.root,k);
	}
}