import java.util.ArrayList;

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
     graph[0].add(new Edge(0, 1,2));
    graph[0].add(new Edge(0, 2,4)); 
    
     //1vertex
     graph[1].add(new Edge(1, 2,-4));
     
    

     //2 vertex
     graph[2].add(new Edge(2, 3,2));

     //3 vertex
     graph[3].add(new Edge(3, 4,4));
    

     //4 vertex
     graph[4].add(new Edge(4, 1,-1));
   

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





    public static void main(String[] args) {
     int V =5;
     ArrayList<Edge> graph[] = new ArrayList[V];
     createGraph(graph);
     bellmanFord(graph, 0);
    }
}
