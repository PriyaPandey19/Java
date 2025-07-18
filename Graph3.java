import java.util.ArrayList;
import java.util.Stack;

public class Graph3 {

    static class Edge{
        int src;
        int dest;
        //int wt;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
           //this.wt = w;
        }
    }
 public static void createGraph(ArrayList<Edge> graph[]){                         //create the graph
      for(int i=0;i<graph.length;i++){       //intitilize the empty  arrayList
      graph[i] = new ArrayList<>();
      }  
      
    //0 vertex
     graph[0].add(new Edge(0, 1));
     graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
     
    
     //1vertex
     graph[1].add(new Edge(1, 0));
     graph[1].add(new Edge(1, 2));
     
     
     //2 vertex
     graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));
    

     //3 vertex
     graph[3].add(new Edge(3, 0));
     graph[3].add(new Edge(3, 4));
    //graph[3].add(new Edge(0, 5));

    //4 vertex
     graph[4].add(new Edge(4, 3));
       

     
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> s){  //step 1 helper function
    vis[curr] = true;
    System.out.print(curr+" ");

    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
            topSort(graph, e.dest, vis, s);
        }
    }
    s.push(curr);

    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){  //step 2 helper function
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[],int V){  //kosaraju algo
        //step 1
        Stack<Integer> s = new Stack<>();    //perform the topological sort
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
            topSort(graph, i, vis, s);
            }
        }


        //step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];    //transpose all the edges of graph
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose,curr,vis);
                    System.out.println();
            }
        }

    }

    public static void dfs(ArrayList<Edge> graph[],int curr, int par, int dt[],int low[], boolean vis[], int time){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i); //e.src ---- e.dest
            int neigh = e.dest;
            if(neigh == par){          //if neighbour is equal to parent than ignore
                continue;
            }
            else if(!vis[neigh]){                  //if not visited than call dfs to visit them
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] < low[neigh]){               //bridge condition
                    System.out.println("Bridge : "+ curr + "----"+ neigh);
                }
                
            }
            else{
              low[curr] = Math.min(low[curr], dt[neigh]);  //agar already visited hai to bus lowest ko update karna hai
            }
        }
    } 
    public static void tarjanBridge(ArrayList<Edge> graph[],int V){  //tarjans algo
        int dt[] = new int[V];
        int low[] = new int[V];
        int time =0;
        boolean vis[] = new boolean[V];

      for(int i=0;i<V;i++){
        if(!vis[i]){
            dfs(graph, i, -1, dt, low, vis, time);
        }
      }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr, int par, int dt[],int low[], int time, boolean vis[],boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children =0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
            else{
              dfs(graph, neigh, curr, dt, low, time, vis,ap);
              low[curr] = Math.min(low[curr], low[neigh]);
              if(par != -1 && dt[curr] <= low[neigh]){
                ap[curr] = true;
              }
              children++;
            }
        }
        if(par == -1 && children > 1){
           ap[curr] = true;
        }
    }


    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time =0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low, time,vis,ap);
            }
        }

        for(int i=0;i<V;i++){
            if(ap[i]){
               System.out.println("AP: "+ i);
            }
        }


    }

    

   public static void main(String[] args) {   //main function
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    getAP(graph, V);
   // tarjanBridge(graph, V);
   // kosaraju(graph, V);
   } 
}
