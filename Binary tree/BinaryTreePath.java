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
class BinaryTreePath
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
		if(s[i]=='L')
			temp.left=newnode;
		else
			temp.right=newnode;
	}
	Vector<Integer> path = new Vector<Integer>(); 
	int count=0;
	void printKPathCount(Node root, int k) 
	{ 
		if (root == null) 
			return; 
		path.add(root.data); 
		printKPathCount(root.left, k); 

		printKPathCount(root.right, k); 
		int f = 0; 
		for (int i = path.size() - 1; i >= 0; i--) 
		{ 
			f += path.get(i); 
			if (f == k) 
				count++; 
		}  
		path.remove(path.size() - 1); 
	} 

	public static void main(String args[])
	{
		BinaryTreePath t = new BinaryTreePath();
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
		System.out.println("Enter sum:");
		int k=sc.nextInt();
		t.printKPathCount(t.root, k);
		System.out.println(t.count);
	}
}
