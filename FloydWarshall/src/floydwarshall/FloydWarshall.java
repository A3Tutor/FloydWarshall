
package floydwarshall;

public class FloydWarshall {


public static final double INF = Double.POSITIVE_INFINITY;
public static double [][][] data =

{

{
{},
{-1, 0, 10, INF, 10, 50},
{-1, 90, 0, 30, 20, INF},
{-1, INF, INF, 0, 40, INF},
{-1, INF, INF, 20, 0, 30},
{-1, 30, INF, INF, 90, 0}
},
  
  
{
{},
{-1, 0, 220, 70, 40, 50, INF, 80, 160, INF,},
{-1, 100, 0, INF, 80, 70, 90, INF, 80, 100},
{-1, 70, INF, 0, 110, INF, 80, INF, 70, INF,},
{-1, 40, 80, 110, 0, INF, 100, 60, INF, 150},
{-1, 30, 20, 60, 80, 0, 10, 50, 120, 70},
{-1, INF, 90, 80, 30, 150, 0, 130, INF, 190},
{-1, 80, INF, INF, 60, INF, 130, 0, 20, 150},
{-1, 160, 80, 70, INF, 120, INF, 20, 0, 60},
{-1, INF, INF, INF, 150, INF, 190, 150, 60, 0}
}
};
    
public static int Floyd(int n, double [][] W, double [][] D, int [][] P) {
int update_count=0;
for(int i=1;i<=n;i++)
{
for(int j=1;j<=n;j++)
{
    D[i][j]=W[i][j];
    P[i][j]=0;
    
}
}
for(int k=1;k<=n;k++)
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if( D[i][j] > (D[i][k] + D[k][j])) 
                    {
                       D[i][j] = D[i][k] + D[k][j];
                       update_count=update_count+1;
                       P[i][j]=k;
                    }
                
        }
    }
}

return update_count;
}
public static void print(double [][]Arr,int n)
{
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=n;j++)
        {
            if(Arr[i][j]!=Double.POSITIVE_INFINITY)
            System.out.print(Arr[i][j]+"\t");
            else
            System.out.print("INF\t");
        } 
        System.out.println();
    }
    
}
public static void print(int [][]Arr,int n)
{
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=n;j++)
        {
            System.out.print(Arr[i][j]+"\t");
        } 
        System.out.println();
    }
    
}
                    public static void main(String[] args) {

                    for (int t = 0; t < data.length; t++) {

                    double [][] W = data[t];
                    int n = W.length - 1;
                    double [][] D = new double[n+1][n+1];
                    int [][] P = new int[n+1][n+1];
                    int numUpdates;

                    numUpdates = Floyd(n, W, D, P);
                    
                    //Testing purpose
                    System.out.println("Updates : "+numUpdates);
                    System.out.println("Weight Matrix : ");
                    print(W,n);
                    System.out.println("Cost of Shortest Path Matrix : ");
                    print(D,n);
                    System.out.println("Index of Vertex Matrix : ");
                    print(P,n);

                    }

                    }
  

    
}
