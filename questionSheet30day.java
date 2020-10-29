// Find duplicate in array - fast slow method 
class Solution {
    public int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[arr[0]];
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast = 0;
        while(fast!=slow){
            fast = arr[fast];
            slow = arr[slow];
        }
        return fast;
    }
}

// Sort 0,1,2 single pass no space

class GFG {
    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = s.nextInt();
		    }
		    int l = 0;
		    int m = l;
		    int h = n-1;
		    while(m<=h){
		        if(arr[m]==0){
		            swap(arr, l, m);
		            l++;
		            m++;
		        }else if(arr[m]==1){
		            m++;
		        }else{
		            swap(arr, m, h);
		            h--;
		        }
		    }
		    for(int i: arr){
		        System.out.print(i+" ");
		    }
		    System.out.println();
		}
	}
}

// Missing and Repeating
int[] findTwoElement(int arr[], int n) {
    int missing = -1;
    int repeating = -1;
    for(int i=0; i<n; i++){
        int abs = Math.abs(arr[i]);
        if(arr[abs-1]<0){
            repeating = abs;
        }else{
            arr[abs-1] *=-1;
        }
    }
    for(int i=0; i<n; i++){
        if(arr[i]>0){
            missing = i+1;
        }
    }
    int ans[] = new int[2];
    ans[0] = repeating;
    ans[1] = missing;
    return ans;
    
}

// Merge w/o extra space
public static void swap(int arr1[], int arr2[], int i, int j){
    int temp = arr1[i];
    arr1[i] = arr2[j];
    arr2[j] = temp;
}
public void merge(int arr1[], int arr2[], int n, int m) {
    int gap = (n+m)/2 + ((n+m)%2);
    while(gap>0){
        int i;
        int j;
        // Both in first array
        for(i=0, j=i+gap; j<n; i++, j++){
            if(arr1[i]>arr1[j]){
                swap(arr1,arr1, i, j);
            }
        }
        // i in arr1 and j in arr2
        for(j=0; j<m && i<n; i++, j++){
            if(arr1[i]>arr2[j]){
                swap(arr1, arr2, i, j);
            }
        }
        // Both in 2nd array
        for(i=0, j=i+gap; j<m && i<m; i++, j++){
            if(arr2[i]>arr2[j]){
                swap(arr2, arr2, i, j);
            }
        }
        if(gap<=1){
            gap=0;
        }else{
            gap = (gap/2) + gap%2 ;
        }
    }
}

// Merge overlapping subintervals
class GFG {
    static class Pair{
        int s;
        int e;
        Pair(){};
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b)->Integer.compare(a.s, b.s));
		    for(int i=0; i<n; i++){
		        int st = s.nextInt();
		        int end = s.nextInt();
		        pq.add(new Pair(st, end));
		    }
		    ArrayList<Pair> ans = new ArrayList<>();
		    Pair curr = pq.poll();
		    int currS = curr.s;
		    int currE = curr.e;
		    while(pq.size()>0){
		        Pair p = pq.poll();
		        int newS = p.s;
		        int newE = p.e;
		        if(newS<=currE){
		            currE = Math.max(currE, newE);
		        }else{
		            ans.add(new Pair(currS, currE));
		            currS = newS;
		            currE = newE;
		        }
		    }
		    ans.add(new Pair(currS, currE));
		    for(Pair p: ans){
		        System.out.print(p.s+" "+p.e+" ");
		    }
		    System.out.println();
		}
	}
}

// Find all duplicates in an array
class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[arr[i]%n] += n;
        }
        for(int i=0; i<n; i++){
            if(arr[i]/n>1){
                ans.add(i);
            }
        }
        if(ans.size()==0){
            ans.add(-1);
        } 
        return ans;
    }
}

// Next Permutation

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = s.nextInt();
		    }
		    int ind = n-1;
		    // Finding index
		    while(ind>0 && arr[ind]<arr[ind-1]){
		        ind--;
		    }
		    if(ind==0){
		        for(int i=n-1; i>=0; i--){
		            System.out.print(arr[i]+" ");
		        }
		        System.out.println();
		        continue;
		        
		    }
		    
		    // Finding correct place
		    int toSwap = ind-1;
		    int swapWith = ind;
		    for(int i=swapWith; i<n; i++){
		        if(arr[i]>=arr[toSwap]){
		            swapWith = i;
		        }else{
		            break;
		        }
		    }
		    
		    // Swapping
		    int temp = arr[toSwap];
		    arr[toSwap] = arr[swapWith];
		    arr[swapWith] = temp;
		    
		    //Reversing
		    
		    int i = ind;
		    int j = n-1;
		    while(i<j){
		        temp = arr[j];
		        arr[j] = arr[i];
		        arr[i] = temp;
		        i++;
		        j--;
		    }
		    for(int k: arr){
		        System.out.print(k+" ");
		    }
		    System.out.println();
		    
		}
	}
}

// Inversion
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long merge(long arr[], int l, int m, int r){
        long arr1[] = Arrays.copyOfRange(arr, l, m+1);
        long arr2[] = Arrays.copyOfRange(arr, m+1, r+1);
        int y = l;
        int i = 0;
        int j = 0;
        long ans = 0L;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                arr[y++] = arr1[i++];
            }else{
                ans += (long)arr1.length - (long)i;
                arr[y++] = arr2[j++];
            }
        }
        while(i<arr1.length){
            arr[y++] = arr1[i++];
        }
        while(j<arr2.length){
            arr[y++] = arr2[j++];
        }
        return ans;
    }
    public static long inver(long arr[], int l, int r){
        if(l>=r) return 0L; 
        long ans = 0L;
        int m = (l+r)/2;
        ans += inver(arr, l, m);
        ans += inver(arr, m+1, r);
        ans += merge(arr, l, m, r);
        return ans;
    }
	public static void main (String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    long a[]=new long[n];
		    String s[]=br.readLine().split(" ");
		    for(int i=0;i<s.length;i++)
		    a[i]=Long.parseLong(s[i]);
		    
		    System.out.println(inver(a,0,n-1));
		}
	}
}


// Excel Column Number
class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    String str = s.next();
		    int ans = 0;
		    int p = 0;
		    for(int i=str.length()-1; i>=0; i--){
		        ans += (int)(str.charAt(i)-'A'+1)*(int)Math.pow(26, p++);
		    }
		    System.out.println(ans);
		}
	}
}