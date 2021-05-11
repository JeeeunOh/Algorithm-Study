package ���ͽ�Ʈ��;

public class ���ͽ�Ʈ��_���۸�_�⺻���� {
	public static class Graph{
	    private int n;           //������ ��
	    private int maps[][];    //���鰣�� ����ġ ������ ����
	 
	    public Graph(int n){
	        this.n = n;
	        maps = new int[n+1][n+1];
	         
	    }
	    public void input(int i,int j,int w){
	        maps[i][j] = w;
	        maps[j][i] = w;
	    }
	 
	    public void dijkstra(int v){
	        int distance[] = new int[n+1];          //�ִ� �Ÿ��� ������ ����
	        boolean[] check = new boolean[n+1];     //�ش� ��带 �湮�ߴ��� üũ�� ����
	         
	        //distance�� �ʱ�ȭ.
	        for(int i=1;i<n+1;i++){
	            distance[i] = Integer.MAX_VALUE;
	        }
	         
	        //���۳�尪 �ʱ�ȭ.
	        distance[v] =0;
	        check[v] =true;
	         
	        //������ distance����
	        for(int i=1;i<n+1;i++){
	            if(!check[i] && maps[v][i] !=0){
	                distance[i] = maps[v][i];
	            }
	        }
	         
	         
	        for(int a=0;a<n-1;a++){ 
	            //������ ��� ��尡 true�ɶ����� �ε� 
	            //��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�.
	            //������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�.
	            int min=Integer.MAX_VALUE;
	            int min_index=-1;
	             
	            //�ּҰ� ã��
	            for(int i=1;i<n+1;i++){
	                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
	                    if(distance[i]<min ){
	                        min=distance[i];
	                        min_index = i;
	                    }
	                }
	            }
	             
	            check[min_index] = true;
	            for(int i=1;i<n+1;i++){
	                if(!check[i] && maps[min_index][i]!=0){
	                    if(distance[i]>distance[min_index]+maps[min_index][i]){
	                        distance[i] = distance[min_index]+maps[min_index][i];
	                    }
	                }
	            }
	 
	        }
	         
	        //����� ���
	        for(int i=1;i<n+1;i++){
	            System.out.print(distance[i]+" ");
	        }
	        System.out.println("");
	         
	    }
	}

	 public static void main(String[] args) {
	        Graph g = new Graph(8);
	        g.input(1, 2, 3);
	        g.input(1, 5, 4);
	        g.input(1, 4, 4);
	        g.input(2, 3, 2);
	        g.input(3, 4, 1);
	        g.input(4, 5, 2);
	        g.input(5, 6, 4);
	        g.input(4, 7, 6);
	        g.input(7, 6, 3);
	        g.input(3, 8, 3);
	        g.input(6, 8, 2);
	        g.dijkstra(1);
	    }

}
