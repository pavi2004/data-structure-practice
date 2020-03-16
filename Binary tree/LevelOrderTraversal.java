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
class LevelOrderTraversal
{
	Node root;
	int maxSize=0;
	void insert(char[] s,int d)
	{
		Node temp=root;
		Node newnode=new Node(d);
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
	void inorder(Node temp)
	{
		if(temp!=null)
		{
			inorder(temp.left);
			System.out.println(temp.data+" ");
			inorder(temp.right);
		}
	}
	void printLevelOrder(Node temp)
	{
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty())
		{
			int count=queue.size();
			maxSize=Math.max(count,maxSize);
			while(count-->0)
			{
				Node tempNode=queue.poll();
				System.out.println(tempNode.data+" ");
				if(tempNode.left!=null)
					queue.add(tempNode.left);
				if(tempNode.right!=null)
					queue.add(tempNode.right);
			}
		}
	}
	public static void main(String arg[])
	{
		Scanner sc =new Scanner(System.in);
		LevelOrderTraversal t= new LevelOrderTraversal();
		System.out.println("Enter no of nodes:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.next();
			char[] s=s1.toCharArray();
			int d=sc.nextInt();
			t.insert(s,d);
		}
		System.out.println("Inorder:");
		t.inorder(t.root);
		System.out.println("\n level order traversal:");
		t.printLevelOrder(t.root);
		System.out.println("\n max width: "+t.maxSize);
	}
}