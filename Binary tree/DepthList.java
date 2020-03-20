import java.util.*;
class node
{
	int data;
	node left,right;
	node(int d)
	{
		data=d;
	}
}
class DepthList
{
	node root;
	int arr[];
	void insert(char[] s,int d)
	{
	node newnode= new node(d);
		node temp=this.root;
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
	void printLinkedList()
	{
		int k=0;
		int c=1;
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(arr[0]);
		System.out.println(l);
		
		l.clear();
		while(c<arr.length)
		{  
			for(int i=k*2+1;i<=k*2+2 ;i++)
			{
				if(i>arr.length)
					break;
				l.add(arr[i]);
				c+=1;
			}
			System.out.println();
			System.out.println(l);
			
		l.clear();
			k++;
		}
	}
	void printLevelOrder(int n)  
    { 
	    
        Queue<node> queue = new LinkedList<node>(); 
		arr = new int[n];
        queue.add(root); 
		int i=0;
        while (!queue.isEmpty())  
        { 
            node temp = queue.poll(); 
            arr[i]=temp.data;
			i+=1;
            if (temp.left != null) { 
                queue.add(temp.left); 
            } 
            if (temp.right != null) { 
                queue.add(temp.right); 
            } 
        } 
    } 
	public static void main(String args[])
	{
		DepthList t = new DepthList();
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
		t.printLevelOrder(n);
		t.printLinkedList();
		
	}
		
}