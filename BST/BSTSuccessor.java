import java.util.*;
class Node { 

	int data; 
	Node left, right, parent; 

	Node(int d) 
	{ 
		data = d; 
		left = right = parent= null; 
	} 
} 


class BSTSuccessor { 

	Node root; 

	Node insert(Node root, int key) { 
  
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
		Node temp;
        if (key < root.data) 
		{
            temp = insert(root.left, key);
			root.left=temp;
			temp.parent=root;
		}
        else if (key > root.data) 
		{
            temp = insert(root.right, key);
			root.right=temp;
			temp.parent=root;
			
		}

        return root; 
    } 
	Node search(Node root,int n)
	{
		if (root == null)
			return null;
		if(root.data==n)
			return root;
		if (n < root.data) 
		{
           Node temp= search(root.left, n);
		   if(temp!=null)
			   return temp;
		   
		}
        
            Node temp=search(root.right, n);			
		
		return temp;
	}
	Node inorderSucessor(Node root,int n)
	{
		Node node=search(root,n);
		System.out.println(node.data);
		if(node.right!=null){
			return minvalue(node.right);
		}
		 Node p = node.parent; 
        while (p != null && node == p.right) { 
            node = p; 
            p = p.parent; 
        } 
        return p;  
	}
	Node minvalue(Node node)
	{
		Node current = node; 
        while (current.left != null) { 
            current = current.left; 
        } 
        return current; 
	}
	public static void main(String args[]) 
	{ 
		

		BSTSuccessor t = new BSTSuccessor(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of nodes:");
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			int key=sc.nextInt();
			t.root = t.insert(t.root,key);
		}
		System.out.println("find successor of:");
		int s=sc.nextInt();
		Node suc=t.inorderSucessor(t.root,s);
		if(suc!=null)
			System.out.println("Inordersuccessor of "+s+" is "+suc.data);
		else
			System.out.println("Inordersuccessor does not exists");
	} 
} 
