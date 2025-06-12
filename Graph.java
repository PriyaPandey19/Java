import java.util.*;

public class Graph {
    static class Edge{
        int src;
        int dest;
       // int wt;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
          //  this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){                         //create the graph
      for(int i=0;i<graph.length;i++){       //intitilize the empty  arrayList
      graph[i] = new ArrayList<>();
      }  
      
    //0  vertex
        graph[0].add(new Edge(0, 3));
    
     //2 vertex
     graph[2].add(new Edge(2, 3));
    

     //3 vertex
     graph[3].add(new Edge(3, 1));

     //4 vertex
     graph[4].add(new Edge(4, 0));
     graph[4].add(new Edge(4, 1));

     //5 vertex
     graph[5].add(new Edge(5, 0));
     graph[5].add(new Edge(5, 2));


    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> [] graph,boolean vis[]){     //BFS Code
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){                           //if not visited so print curr and mark visited as true
                System.out.println(curr +" ");
                vis[curr] = true;               
                for(int i=0;i<graph[curr].size();i++){  //get all the adjacent edges
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }





    public static void dfs(ArrayList<Edge>[] graph){      
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){      //DFS code
        System.out.print(curr+ " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }







    public static boolean hasPath(ArrayList<Edge>[] graph, int src,int dest ,boolean vis[]){  //has path  btw src and dest
        if(src == dest){ 
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            //e.dest = neighbor
          if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){  
            return true;
          }
        }
        return false;
    }






    public static boolean detectCycle(ArrayList<Edge>[] graph){   //detect cycle in undirected graph
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
               if( detectCycleUtil(graph,vis, i,-1)){
                return true;
               }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
      vis[curr] = true;

      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        //case 3   to check other cycle is there or not
        if(!vis[e.dest] ){
            if(detectCycleUtil(graph,vis,e.dest,curr))
            return true;
        }
        //case 1
        else if(vis[e.dest] && e.dest != par){
            return true;
        }
      }
      return false;
    }





    public static boolean isBipartitieGraph(ArrayList<Edge>[] graph){     //is bipartitie graph or not
        int col[] = new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i] = -1;
        }  
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++){
            if(col[i] == -1){  //BFS
                q.add(i);
                col[i] =0;  //YELLOW
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1: 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }





    public static boolean isCycle(ArrayList<Edge>[] graph){         //detect cycle in directed graph
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

   public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
    vis[curr] = true;
    stack[curr] = true;

    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(stack[e.dest]){
            return true;
        }
        if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
            return true;
        }
    }
    stack[curr]= false;
    return false;
   } 







   public static void topSort(ArrayList<Edge>[] graph){    //topological sort using DFS
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            topSortUtil(graph,i,vis,s);
        }
    }
    while (!s.isEmpty()) {
        System.out.print(s.pop() + " ");
    }
   }

   public static void topSortUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],Stack<Integer> s){
    vis[curr] = true;

    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
            topSortUtil(graph,e.dest,vis,s);
        }
    }
    s.push(curr); 
   }







   public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]){
    for(int i=0;i<graph.length;i++){
        int v = i;
        for(int j=0;j<graph[v].size();j++){
            Edge e = graph[v].get(j);
            indeg[e.dest]++;
        }
    }
   } 

   public static void topSort1(ArrayList<Edge> graph[]){
    int indeg[] = new int[graph.length];
    calcIndeg(graph, indeg);
    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<indeg.length;i++){
        if(indeg[i] == 0){
            q.add(i);
        }
    }

    //bfs
    while (!q.isEmpty()) {
       int curr = q.remove();
       System.out.print(curr+" "); 

       for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        indeg[e.dest]--;
        if(indeg[e.dest] == 0){
            q.add(e.dest);
        }
       }
    }
    System.out.println();
   }


   public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
    if(src == dest){
        System.out.println(path+dest);
        return;
    }
    for(int i=0;i<graph[src].size();i++){
        Edge e = graph[src].get(i);
        printAllPath(graph, e.dest, dest, path +src);
    }
   }


    public static void main(String[] args) {
      int V = 6;
      ArrayList<Edge>[] graph = new ArrayList[V];
       createGraph(graph);
       int src = 5,dest = 1;
    printAllPath(graph, src, dest, "");
      //topSort1(graph);
    //   System.out.println(detectCycle(graph));
    //   System.out.println(isBipartitieGraph(graph));
    // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

    }
}
