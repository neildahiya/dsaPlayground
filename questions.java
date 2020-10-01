// Remove loop from LL

public static void removeLoop(Node head){
    if(head==null || head.next==null) return;
    Node slow = head;
    Node fast = head.next;
    while(slow!=fast){
        if(fast==null || fast.next==null || slow==null) return;
        slow = slow.next;
        fast = fast.next.next;
    }
    fast = head;
    while(slow.next!=fast){
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = null;
}

// Stock buy and sell 

public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    int tt = s.nextInt();
    while(tt-->0){
        int n = s.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = s.nextInt();
        int st = 0;
        int i = 1;
        while(i<n){
            if(st==n-1) break;
            int curr = i;
            while(i<n && arr[i]>=arr[st] && arr[i]>arr[i-1]){
                curr = i;
                i++;
            }
            if(arr[st]<arr[curr]){
                ans.add(st);
                ans.add(curr);
            }
            st = i;
            i = st+1;
        }
        for(i=0; i<ans.size(); i+=2){
            System.out.print("(" + ans.get(i) + " "+ ans.get(i+1) +") ");
        }
        if(ans.size()==0){
            System.out.print("No Profit");
        }
        System.out.println();
    }
}

// Check for BST

public class Tree
{
    boolean helper(Node root, int min, int max){
        if(root==null) return true;
        if(root.data<=min || root.data>=max){
            return false;
        }
        return helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
        {
            return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
}

// Min Stack

class GfG
{
    int minEle = -1;
    Stack<Integer> s= new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
	    if(s.size()==0) return -1;
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    if(s.size()==0) return -1;
	    int temp = s.pop();
	    if(s.peek()==temp){
	        int toReturn = s.pop();
	        minEle = s.size()>0 ? s.peek() : -1;
	        return toReturn;
	    }
	    return s.pop();
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    if(x<minEle || minEle == -1){
	        minEle = x;
	    }	
	    s.push(x);
	    s.push(minEle);
    }	
}


// n*n chessboard number of squares

n*(n+1)*(2n+1)/6;


// Sort a stack

public Stack<Integer> sort(Stack<Integer> s)
	{
	    if(s.size()==0) return s;
		Integer a = s.pop();
		Stack<Integer> aux = new Stack<>();
		s = sort(s);
		while(s.size()>0 && s.peek()>a){
		    aux.push(s.peek());
		    s.pop();
		}
		s.push(a);
		while(aux.size()>0){
		    s.push(aux.peek());
		    aux.pop();
		}
		return s;
    }
    
// Y linked list intersection point

int intersectPoint(Node headA, Node headB)
	{
         Node temp = headA;
         while(temp.next!=null){
             temp = temp.next;
         }
         temp.next = headB;
         Node slow  = headA;
         Node fast = headA.next;
         while(slow!=fast){
             slow = slow.next;
             fast = fast.next.next;
         }
         fast =  headA.next;
         while(fast!=slow){
             fast = fast.next;
             slow = slow.next;
         }
         return fast.data;
    }
    


// Smallest subarray with sum > x
class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int x = s.nextInt();
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++) arr[i] = s.nextInt();
		    int ans = Integer.MAX_VALUE;
		    int curr = arr[0];
		    int i=0;
		    int j=1;
		    while(j<n){
		        if(arr[j]>x || arr[i]>x){
		            ans=1;
		        }
		        if(curr>x){
		            ans = Math.min(ans, j-i);
		        }
		        if(curr<=x){
		            curr += arr[j++];
		        }else{
		            ans = Math.min(ans, j-i);
		            curr-=arr[i++];
		        }
		        if(i>j){
		            j = i;
		            curr = arr[j];
		        }
		    }
		    if(curr>x){
		        ans = Math.min(ans, j-i);
		    }
		    System.out.println(ans);
		}
	}
}

// Queue using 2 stacks
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element
       into the queue */
    void Push(int x)
    {
	   Stack<Integer> st1 = s2.size()==0 ? s1 : s2;
	   Stack<Integer> st2 = s2.size()==0 ? s2 : s1;
	   while(st1.size()>0){
	       st2.push(st1.pop());
	   }
	   st2.push(x);
	   while(st2.size()>0){
	       st1.push(st2.pop());
	   }
    }
	
    
    /* The method remove which return the
      element popped out of the queue*/
    int Pop()
    {
	   if(s1.size()==0 && s2.size()==0) return -1;
	   if(s1.size()==0) return s2.pop();
	   return s1.pop();
    }
}

// Min cost of joining ropes

class GFG {
	public static void main (String[] args) {
		Scanner s  =  new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    long n = s.nextLong();
		    PriorityQueue<Long> pq = new PriorityQueue<>();
		    for(int i=0; i<n; i++){
		        pq.add(s.nextLong());
		    }
		    long ans = 0L;
	        while(pq.size()>1){
	            long temp = (pq.poll()+pq.poll());
	            ans += temp;
	            pq.add(temp);
	        }
	        
	        System.out.println(ans);
		}
	}
}

// Min number of flips

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    String str = s.next();
		    // Starting with 1
		    int curr = 1;
		    int flips1 = 0;
		    for(int i=0; i<str.length(); i++){
		        int elem = str.charAt(i)-'0';
		        if(elem!=curr){
		            flips1++;
		        }
		        curr = curr == 1 ? 0 : 1;
		    }
		    curr = 0;
		    int flips2 = 0;
		    for(int i=0; i<str.length(); i++){
		        int elem = str.charAt(i)-'0';
		        if(elem!=curr){
		            flips2++;
		        }
		        curr = curr == 1 ? 0 : 1;
		    }
		    int ans = Math.min(flips1, flips2);
		    System.out.println(ans);
		}
	}
}

// Del in groups of k

class GfG
{
    public static Node reverseList(Node head){
        if(head==null || head.next==null) return head;
        Node next = head.next;
        Node newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    public static Node reverse(Node node, int k)
    {
        if(node==null) return node;
        int count = 1;
        Node curr = node;
        while(count<k && curr!=null){
            curr = curr.next;
            count++;
        }
        if(curr==null){
            return reverseList(node);
        }
        Node nextList = reverse(curr.next, k);
        curr.next = null;
        Node reversed = reverseList(node);
        node.next = nextList;
        return reversed;
        
    }
}

// Nodes at given distance

class Solution
{
    public static void addInList(ArrayList<Integer> ans, int k, Node root){
        if(root==null) return;
        if(k==0){
            ans.add(root.data);
            return;
        }
        addInList(ans, k-1, root.left);
        addInList(ans, k-1, root.right);
    }
    public static int helper(Node root, int target, int k, ArrayList<Integer> ans){
        if(root==null) return -1;
        if(root.data==target){
            addInList(ans, k, root);
            return 0;
        }
        int left = helper(root.left, target, k, ans);
        int right = helper(root.right, target, k, ans);
        if(left!=-1){
            if(left==k-1){
                ans.add(root.data);
            }
            addInList(ans, k-left-2, root.right);
            return left+1;
        }
        if(right!=-1){
            if(right==k-1){
                ans.add(root.data);
            }
            addInList(ans, k-right-2, root.left);
            return right+1;
        }
        return -1;
        
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, target, k, ans);
        Collections.sort(ans);
        return ans;
    }
};

// Min steps to reach target by knight

class GFG {
    static class Pair{
        int x;
        int y;
        int steps;
        Pair(int x, int y, int steps){
            this.x=x;
            this.y=y;
            this.steps=steps;
        }
    }
    static int[] xMove = {1,1,-1,-1,2,2,-2,-2};
    static int[] yMove = {2, -2, 2, -2, 1,-1,1,-1};
    public static boolean isSafe(int x, int y, int n){
        if(x<0 || y<0 || x>=n || y>=n) return false;
        return true;
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    HashMap<String, Integer> map = new HashMap<>();
		    int n = s.nextInt();
		    int kX = s.nextInt(), kY = s.nextInt();
		    int tX = s.nextInt(), tY = s.nextInt();
		    if(kX==tX && kY==tY){
		        System.out.println(0);
		        continue;
		    }
		    Queue<Pair> q = new LinkedList<>();
		    q.add(new Pair(kX, kY, 0));
		    boolean found = false;
		    int ans = 0;
		    while(q.size()>0){
		        if(found) break;
		        Pair curr = q.poll();
		        for(int i=0; i<8; i++){
		            int newX = curr.x + xMove[i];
		            int newY = curr.y + yMove[i];
		            int newSteps = curr.steps + 1;
		            if(newX==tX && newY==tY){
		                found = true;
		                ans = newSteps;
		                break;
		            }
		            if(!isSafe(newX, newY, n)){
		                continue;
		            }
		            if(map.getOrDefault(newX+" "+newY, Integer.MAX_VALUE)<newSteps){
		                continue;
		            }
		            q.add(new Pair(newX, newY, newSteps));
		            map.put(newX+" "+newY, newSteps);
		            
		        }
		    }
		    System.out.println(ans);
		}
	}
}

// Min Cost Path Grid all 4 directions - Sort of Djikstra's Algorithm

class GFG {
    static class Pair{
        int x;
        int y;
        int cost;
        Pair(int x, int y, int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    static int xDir[] = {-1, 0, 1, 0};
    static int yDir[] = {0, -1, 0, 1};
    public static boolean isSafe(int x, int y, int n){
        if(x<0 || y<0 || y>=n || x>=n) return false;
        return true;
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt =s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int arr[][] = new int[n][n];
		    int dp[][] = new int[n][n];
		    for(int i=0; i<n; i++){
		        for(int j=0; j<n; j++){
		            arr[i][j] = s.nextInt();
		            dp[i][j] = -1;
		        }
		    }   
		    dp[0][0] = arr[0][0];
		    PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b)->Integer.compare(a.cost, b.cost));
		    q.add(new Pair(0,0,arr[0][0]));
		    while(q.size()>0){
		        Pair p = q.poll();
		        int currX = p.x;
		        int currY = p.y;
		        int currCost = p.cost;
		        for(int i=0; i<4; i++){
		            int newX = currX + xDir[i];
		            int newY = currY + yDir[i];
		            if(!isSafe(newX, newY, n)) continue;
		            int newCost = currCost + arr[newX][newY];
		            if(dp[newX][newY]==-1 || dp[newX][newY]>newCost){
		                q.add(new Pair(newX, newY, newCost));
		                dp[newX][newY] = newCost;
		            }
		        }
		    }
		    System.out.println(dp[n-1][n-1]);
		}
	}
}

// Matrix Binary Search

class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        int i = 0;
        int j = mat[0].length-1;
        while(i<N && j>=0){
            if(mat[i][j]==X){
                return 1;
            }
            if(mat[i][j]<X){
                i++;
            }else{
                j--;
            }
        }
        return 0;
    }
}

// Binary Tree to DLL

class GfG
{
    static class Pair{
        Node head;
        Node tail;
        Pair(){
            this.head=null;
            this.tail=null;
        }
        Pair(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }
    }
    Pair helper(Node root){
        if(root==null){
            return new Pair();
        }
        if(root.left==null && root.right==null){
            return new Pair(root, root);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if(left.head==null){
            root.right = right.head;
            right.head.left = root;
            return new Pair(root, right.tail);
        }
        left.tail.right = root;
        root.left = left.tail;
        if(root.right==null){
            return new Pair(left.head, root);
        }
        root.right = right.head;
        right.head.left = root;
        return new Pair(left.head, right.tail);
        
        
    }
    
    Node bToDLL(Node root)
    {
	    return helper(root).head;
    }
}

// Rectangles in NxN matrix (Not squares)

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt  =  s.nextInt();
		while(tt-->0){
		    long n = s.nextLong();
		    long ans = n*n*(n+1)*(n+1)/4 - (n)*(n+1)*(2*n+1)/6;
		  //  if(n==1) ans=0;
		    System.out.println(ans);
		}
	}
}

// Wave array

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++) arr[i] = s.nextInt();
		    for(int i=0; i<n; i+=2){
		        if(i>0 && arr[i]<arr[i-1]){
		            int temp = arr[i];
		            arr[i] = arr[i-1];
		            arr[i-1] = temp;
		        }
		        if(i < n-1 && arr[i]<arr[i+1]){
		            int temp = arr[i];
		            arr[i] = arr[i+1];
		            arr[i+1] = temp;
		        }
		    }
		    for(int i: arr){
		        System.out.print(i+" ");
		    }
		    System.out.println();
		}
	}
}

// Knight Walk
class GFG {
    static class Pair{
        int x;
        int y;
        int steps;
        Pair(int x, int y, int steps){
            this.x=x;
            this.y=y;
            this.steps=steps;
        }
    }
    static int[] xMove = {1,1,-1,-1,2,2,-2,-2};
    static int[] yMove = {2, -2, 2, -2, 1,-1,1,-1};
    public static boolean isSafe(int x, int y, int n, int m){
        if(x<0 || y<0 || x>=n || y>=m) return false;
        return true;
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    HashMap<String, Integer> map = new HashMap<>();
		    int n = s.nextInt(), m=s.nextInt();
		    int kX = s.nextInt()-1, kY = s.nextInt()-1;
		    int tX = s.nextInt()-1, tY = s.nextInt()-1;
		    if(kX==tX && kY==tY){
		        System.out.println(0);
		        continue;
		    }
		    Queue<Pair> q = new LinkedList<>();
		    q.add(new Pair(kX, kY, 0));
		    boolean found = false;
		    int ans = 0;
		    while(q.size()>0){
		        if(found) break;
		        Pair curr = q.poll();
		        for(int i=0; i<8; i++){
		            int newX = curr.x + xMove[i];
		            int newY = curr.y + yMove[i];
		            int newSteps = curr.steps + 1;
		            if(newX==tX && newY==tY){
		                found = true;
		                ans = newSteps;
		                break;
		            }
		            if(!isSafe(newX, newY, n, m)){
		                continue;
		            }
		            if(map.getOrDefault(newX+" "+newY, Integer.MAX_VALUE)<newSteps){
		                continue;
		            }
		            q.add(new Pair(newX, newY, newSteps));
		            map.put(newX+" "+newY, newSteps);
		            
		        }
		    }
		    if(ans==0) ans = -1;
		    System.out.println(ans);
		}
	}
}

// Array Pair Divisiblity - Check if array can be divided in pairs such that all are divisible by k
class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    HashMap<Integer, Integer> map = new HashMap<>();
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = s.nextInt();
		    }
		    int k = s.nextInt();
		    for(int i=0; i<n; i++){
		        arr[i] %= k;
		        map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		    }
		    boolean ans = true;
		    for(Integer i: map.keySet()){
		        if(i==0){
		            if(map.get(i)%2==1){
		                ans = false;
		                break;
		            } 
		        }
		        else if(map.get(k-i)!=map.get(i)){
		            ans = false;
		            break;
		        }
		    }
		    if(ans){
		        System.out.println("True");
		    }else{
		        System.out.println("False");
		    }
		    
		}
	}
}
 
// Edit Distance
static HashMap<String, Integer> map;
public int helper(String s, String t, int n, int m){
    if(n==-1 && m==-1) return 0;
    if(n==-1) return m+1;
    if(m==-1) return n+1;
    if(map.containsKey(n+" "+m)) return map.get(n+" "+m);
    if(s.charAt(n)==t.charAt(m)){
        int ans = helper(s, t, n-1, m-1);
        map.put(n+" "+m, ans);
        return ans;
    }else{
        int ans = 1+ Math.min(helper(s, t, n-1, m), Math.min(helper(s, t, n, m-1), helper(s, t, n-1, m-1)));
        map.put(n+" "+m, ans);
        return ans;
    }
}
public int editDistance(String s, String t)
{
    map = new HashMap<>();
    return helper(s, t, s.length()-1, t.length()-1);
}

// Flatten a linked list
class GfG
{
    Node merge(Node a, Node b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.data<b.data){
            a.bottom = merge(a.bottom, b);
            return a;
        }else{
            b.bottom = merge(b.bottom, a);
            return b;
        }
    }
    Node flatten(Node root)
    {
	    Node node = root;
	    while(node.next!=null){
	        Node nextList = node.next;
	        Node thirdList = nextList.next;
	        node.next = null;
	        nextList.next = null;
	        node = merge(node, nextList);
	        node.next = thirdList;
	    }
	    return node;
    }
}

// Max Height Staircase from n blocks
class Solution {
    static int maxStairHeight(int N) {
        long l = 1L;
        long h = N;
        long ans = 0L;
        while(l<=h){
            long m = (l+h)/2L;
            long curr = m*(m+1)/2L;
            if(curr==N){
                return (int)m;
            }
            if(curr<N){
                ans = Math.max(ans, m);
                l = m + 1;
            }else{
                h = m-1;
            }
        }
        return (int)ans;
    }
};
