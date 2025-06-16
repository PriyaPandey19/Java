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
     graph[0].add(new Edge(0, 2));
     graph[0].add(new Edge(0, 3));
     
    
     //1vertex
     graph[1].add(new Edge(1, 0));
     
     
     //2 vertex
     graph[2].add(new Edge(2, 1));
    

     //3 vertex
     graph[3].add(new Edge(3, 4));
     
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
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[],int V){
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

   public static void main(String[] args) {
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    kosaraju(graph, V);
   } 
}
