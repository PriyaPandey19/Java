import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph2 {
       static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d,int w){
            this.src = s;
            this.dest = d;
           this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){                         //create the graph
      for(int i=0;i<graph.length;i++){       //intitilize the empty  arrayList
      graph[i] = new ArrayList<>();
      }  
      
    //0 vertex
     graph[0].add(new Edge(0, 1,10));
    graph[0].add(new Edge(0, 2,15));
     graph[0].add(new Edge(0, 3,30));
     
    
     //1vertex
     graph[1].add(new Edge(1, 0,10));
     graph[1].add(new Edge(1, 3,40));
     
     
     //2 vertex
     graph[2].add(new Edge(2, 0,15));
     graph[2].add(new Edge(2, 3,50));
     

     //3 vertex
     graph[3].add(new Edge(3, 1,40));
     graph[3].add(new Edge(3, 2,50));
     


    }

    public static void bellmanFord(ArrayList<Edge> graph[],int src){   //bellman ford algo
        int dist[] = new int[graph.length]; // 
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){   //the distance should not be infinite
                        dist[v] = dist[u]+wt;                                     //bcz when weight is added then it will become negative
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
        System.out.print(dist[i] + " ");
    }
    System.out.println();
    }

    static class Pair implements Comparable<Pair>{
     int v;
     int cost;
     public Pair(int v, int c){
        this.v = v;
        this.cost =c;
     }
     @Override
     public int compareTo(Pair p2){
        return this.cost - p2.cost;
     }

    }
    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;    //total min weight

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
            vis[curr.v] = true;
            finalCost +=curr.cost;

            for(int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                pq.add(new Pair(e.dest, e.wt));
            }
            }
        }
        System.out.println("final(min) cost "+ finalCost);
    }





    public static void main(String[] args) {
     int V =4;
     ArrayList<Edge> graph[] = new ArrayList[V];
     createGraph(graph);
     bellmanFord(graph, 0);
     prims(graph);
    }
}
