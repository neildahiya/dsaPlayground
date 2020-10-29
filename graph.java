// BFS and DFS
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean vis[] = new boolean[N];
        vis[0] = true;
        while(q.size()>0){
            Integer p = q.poll();
            ans.add(p);
            ArrayList<Integer> arr = g.get(p);
            for(Integer j: arr){
                if(!vis[j]){
                    vis[j] = true;
                    q.add(j);
                }
            }
        }
        return ans;
    }

    static void dfsHelper(ArrayList<ArrayList<Integer>> g, boolean vis[], int v, ArrayList<Integer> ans){
        vis[v] = true;
        ans.add(v);
        for(Integer i: g.get(v)){
            if(!vis[i]){
                dfsHelper(g, vis, i, ans);
            }
        }
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       ArrayList<Integer> ans = new ArrayList<>();
       boolean vis[] = new boolean[N];
       dfsHelper(g, vis, 0, ans);
       return ans;
    }

}

// Check cycle undirected - DFS
class DetectCycle
{
    static boolean checkCycleDFS(ArrayList<ArrayList<Integer>> g, int v, int p, boolean vis[]){
        vis[v] = true;
        for(Integer i: g.get(v)){
            if(vis[i] && i!=p){
                return true;
            }
            if(!vis[i]){
                if(checkCycleDFS(g, i, v, vis)) return true;
            }
        }
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int N)
    {
       boolean vis[] = new boolean[N];
       for(int i=0; i<N; i++){
           if(!vis[i]){
               if(checkCycleDFS(g, i, -1, vis)) return true;
           }
       }
       return false;
    }
}
// Check cycle undirected BFS
class DetectCycle
{
    static class Pair{
        int par;
        int ver;
        Pair(int par, int ver){
            this.par = par;
            this.ver = ver;
        }
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int N)
    {
       boolean vis[] = new boolean[N];
       for(int i=0; i<N; i++){
           if(!vis[i]){
               Queue<Pair> q = new LinkedList<>();
               q.add(new Pair(-1, i));
               while(q.size()>0){
                   Pair p = q.poll();
                   vis[p.ver] = true;
                   for(Integer u: g.get(p.ver)){
                       if(vis[u] && u!=p.par) return true;
                       if(!vis[u]){
                           q.add(new Pair(p.ver, u));
                       }
                   }
               }
           }
       }
       return false;
    }
}

// Detect cycle directed DFS
class DetectCycle
{
    static boolean dfsHelper(ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean curr[], int v){
        vis[v] = true;
        for(Integer i: adj.get(v)){
            if(vis[i] && curr[i]) return true;
            if(!vis[i]){
                curr[i] = true;
                if(dfsHelper(adj, vis, curr, i)) return true;
                curr[i] = false;
            }
        }
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int n)
    {
        boolean vis[] = new boolean[n];
        boolean curr[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                curr[i] = true;
                if(dfsHelper(adj, vis, curr, i)) return true;
                curr[i] = false;
            }
        }
        return false;
    }
}

// Rat in a maze DFS 
class GfG {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int xDir[] = {-1, 0, 1, 0};
    static int yDir[] = {0, -1, 0, 1};
    static String dir[] = {"U","L", "D", "R"}; 
    public static boolean isSafe(int x, int y, int m[][]){
        if(x<0 || y<0 || x>=m.length || y>=m[0].length || m[x][y]==0) return false;
        return true;
    }
    public static void backtrack(int[][] m, ArrayList<String> ans, HashSet<String> vis, String curr, Pair p, int n){
        vis.add(p.x+" "+p.y);
        if(p.x==n-1 && p.y==n-1){
            ans.add(curr);
            vis.remove(p.x+" "+p.y);
            return;
        }
        for(int i=0; i<4; i++){
            int newX = p.x + xDir[i];
            int newY = p.y + yDir[i];
            if(isSafe(newX, newY, m) && !vis.contains(newX+" "+newY)){
                curr = curr + dir[i];
                backtrack(m, ans, vis, curr, new Pair(newX, newY), n);
                curr = curr.substring(0, curr.length()-1);
            }
        }
        vis.remove(p.x+" "+p.y);
        
    }
    public static ArrayList<String> printPath(int[][] m, int n) {
        HashSet<String> vis = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        backtrack(m, ans, vis, "", new Pair(0,0), n);
        return ans;
    }
}

// Min steps by knight to reach target
class GFG {
    static class Pair{
        int x;
        int y;
        int steps;
        Pair(int x, int y, int steps){
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
    static int xDir[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int yDir[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static boolean isSafe(int x, int y, int n){
        if(x<0 || y<0 || x>=n || y>=n) return false;
        return true;
    }
    public static int minSteps(int kx, int ky, int tx, int ty, int n){
        if(kx==tx && ky==ty) return 0;
        boolean found = false;
        Queue<Pair> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        q.add(new Pair(kx, ky, 0));
        while(q.size()>0){
            if(found) break;
            Pair p = q.poll();
            int newSteps = p.steps + 1;
            
            for(int i=0; i<8; i++){
                int newX = p.x + xDir[i];
                int newY = p.y + yDir[i];
                if(newX==tx && newY==ty){
                    found = true;
                    return newSteps;
                }
                if(!isSafe(newX, newY, n)) continue;
                int storedSteps = map.getOrDefault(newX+" "+newY, Integer.MAX_VALUE);
                if(storedSteps<=newSteps) continue;
                map.put(newX+" "+newY, newSteps);
                q.add(new Pair(newX, newY, newSteps));
            }
            
        }
        return 0;
    }
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		while(tt-->0){
		    int n = s.nextInt();
		    int kx = s.nextInt();
		    int ky = s.nextInt();
		    int tx = s.nextInt();
		    int ty = s.nextInt();
		    int ans = minSteps(kx, ky, tx, ty, n);
		    System.out.println(ans);
		}
	}
}

// Clone a graph
class Solution {
    public Node helper(Node node, HashMap<Integer, Node> map){
        if(node==null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        Node head = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, head);
        for(Node n: node.neighbors){
            head.neighbors.add(helper(n, map));
        }
        return head;
    }
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        helper(node, map);
        return helper(node, map);
    }
}