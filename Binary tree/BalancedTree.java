import java.util.*;
class Node { 

	int data; 
	Node left, right; 

	Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class Height { 
	int height = 0; 
} 

class BalancedTree { 

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
	
	boolean isBalanced(Node root, Height height) 
	{ 

		if (root == null) { 
			height.height = 0; 
			return true; 
		} 

		Height lheight = new Height(), rheight = new Height(); 
		boolean l = isBalanced(root.left, lheight); 
		boolean r = isBalanced(root.right, rheight); 
		int lh = lheight.height, rh = rheight.height; 

		height.height = (lh > rh ? lh : rh) + 1; 

		if ((lh - rh >= 2) || (rh - lh >= 2)) 
			return false; 

		else
			return l && r; 
	} 

	public static void main(String args[]) 
	{ 
		Height height = new Height(); 

		BalancedTree t = new BalancedTree(); 
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

		if (t.isBalanced(t.root, height)) 
			System.out.println("Tree is balanced"); 
		else
			System.out.println("Tree is not balanced"); 
	} 
} 
