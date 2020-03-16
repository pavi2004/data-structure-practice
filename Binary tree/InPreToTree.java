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
class InPreToTree
{
	Node root;
	int preIn=0;
	Node buildTree(int[] in ,int[] pre ,int startIn, int endIn)
	{
		if(startIn>endIn)
			return null;
		Node temp = new Node(pre[preIn++]);
		if(startIn==endIn)
			return  temp;
		int inIn=search(in,startIn,endIn,temp.data);
		temp.left=buildTree(in,pre,startIn,inIn-1);
		temp.right=buildTree(in,pre,inIn+1,endIn);
		return temp;
	}
	int search(int[] in,int startIn,int endIn,int d)
	{
		for(int i=startIn;i<=endIn;i++)
		{
			if(d==in[i])
			{
				return i;
			}
		}
		return -1;
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
	public static void main(String[] arg)
	{
		Scanner sc = new Scanner(System.in);
		InPreToTree t = new InPreToTree();
		System.out.println("Enter no of nodes");
		int n=sc.nextInt();
		int in[]=new int[n];
		int pre[]=new int[n];
		System.out.println("Enter inorder:");
		for(int i=0;i<n;i++)
		{
			in[i]=sc.nextInt();
		}
		System.out.println("Enter preorder:");
		for(int i=0;i<n;i++)
		{
			pre[i]=sc.nextInt();
		}
		t.root=t.buildTree(in,pre,0,n-1);
		System.out.println("Resultant tree inorder:");
		t.inorder(t.root);
	}
}