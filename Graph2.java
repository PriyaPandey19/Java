import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public static void prims(ArrayList<Edge> graph[]){   //prims algorithm
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


    public static void createGraph(int flights[][], ArrayList<Edge> graph1[]){     //cheapest flight
        for(int i=0;i<graph1.length;i++){       //intitilize the empty  arrayList
            graph1[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            
            Edge e = new Edge(src, dest, wt);
            graph1[src].add(e);
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
         public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;

         }
    }

    public static int cheapestFlight(int n, int flights[][],int src,int dest,int k){
     ArrayList<Edge> graph1[] = new ArrayList[n]; //create graph and initilize with infinite
     createGraph(flights, graph1);
       int dist[] = new int[n];
       for(int i=0;i<n;i++){
        if( i!= src){
            dist[i] = Integer.MAX_VALUE;
        }
       }
       Queue<Info> q = new LinkedList<>();  //queue ke andar add kiya src ko
       q.add(new Info(src, 0, 0));

       while (!q.isEmpty()) {                     //if curr ke stop grater than k hai to stop
        Info curr = q.remove();
        if(curr.stops > k){
            break;
        }
        for(int i=0;i<graph1[curr.v].size();i++){    //sare neighbours ke liya 
            Edge e = graph1[curr.v].get(i);
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if(curr.cost+ wt < dist[v] && curr.stops <= k){   //relaxation step 
            dist[v] = curr.cost + wt;
            q.add(new Info(v, dist[v], curr.stops+1));
            }

        }
       }
       if(dist[dest] == Integer.MAX_VALUE){
        return -1;
       }
       else{
        return dist[dest];
       }
    }






    static class Edge1 implements Comparable<Edge1>{
        int dest;
        int cost;
        
        public Edge1(int d, int c){
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edge1 e2){
            return this.cost - e2.cost;
        }
    }
    public static int connectCitiesS(int cities[][]){    //min cost to connect  cities
      PriorityQueue<Edge1> pq = new PriorityQueue<>();
      boolean vis[] = new boolean[cities.length];

   pq.add(new Edge1(0, 0));
    int finalCost=0;
    while(!pq.isEmpty()){
        Edge1 curr = pq.remove();
        if(!vis[curr.dest]){    //if not visited than visit and add in final cost
        vis[curr.dest] = true;
        finalCost += curr.cost;
        
        for(int i=0;i<cities[curr.dest].length;i++){    //phir check karenge neighbour if edge exists or not agar hoti hai to add karo pq mai
            if(cities[curr.dest][i] != 0){
                pq.add(new Edge1(i, cities[curr.dest][i]));
            }
        }
        }
    }
    return finalCost;
    }

    static int n = 7;
   static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;

        }
    }

    public static int find(int x){
        if(x == par[x]){
        return x;
        }
        return  find(par[x]);
    }

public static void union(int a, int b){
    int parA = find(a);
    int parB = find(b);

    if(rank[parA] == rank[parB]){          //if both have same rank so no change
        par[parB] = parA;
        rank[parA]++;
    }
    else if(rank[parA] < rank[parB]){   //if rank of A is less it should be added with B
       par[parA] = parB;  
    }
    else{
      par[parB] = parA;  //if rank of B is less it should be added with A
    }

}







    public static void main(String[] args) {
        init();
        union(1, 3);
       System.out.println(find(3));
       union(2, 4);
       union(3, 6);
       union(1, 4);
       System.out.println(find(3));
       System.out.println(find(4));
       union(1, 5);


        int n = 4;
        int flights[][] ={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dest =3, k =1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));


        int cities[][] ={{0,1,2,3,4},
                         {1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,6,0,0},
                        {4,7,0,0,0}};
                        System.out.println(connectCitiesS(cities));
    
     int V =4;
     ArrayList<Edge> graph[] = new ArrayList[V];
     createGraph(graph);
     bellmanFord(graph, 0);
     prims(graph);
    }
}
