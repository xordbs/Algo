package SWEA;

import java.io.*;
import java.util.*;


public class Solution_SWEA_3124_최소스패닝트리_D4_오윤택 {
    
   static class Edge implements Comparable<Edge>{
       int start, end, weight;

       public Edge(int start, int end, int weight) {
           this.start = start;
           this.end = end;
           this.weight = weight;
       }

       @Override
       public int compareTo(Edge o) {
//         return this.weight - o.weight; // 가중치가 전부 양수일 경우
           return Integer.compare(this.weight, o.weight);
       }
   }
    
   static int[] parents; // 부모원소 관리(트리처럼 사용)
   static int V,E; // 정점, 간선 개수
   static Edge[] edgeList; // 간선 리스트
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int tc = Integer.parseInt(br.readLine());
       for (int t = 1; t <= tc; t++) {
            
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
           V = Integer.parseInt(st.nextToken());
           E = Integer.parseInt(st.nextToken());
            
           // 간선리스트 작성
           edgeList = new Edge[E];
            
           for (int i = 0; i < E; i++) {
               st = new StringTokenizer(br.readLine(), " ");
               int start = Integer.parseInt(st.nextToken());
               int end = Integer.parseInt(st.nextToken());
               int weight = Integer.parseInt(st.nextToken());
               edgeList[i] = new Edge(start, end, weight); // 간선리스트에 정보 저장
           }
            
           Arrays.sort(edgeList); // 오름차순 정렬
           make(); //  모든 정점을 각각의 집합으로 만들고 출발
            
           // 간선 하나씩 시도하며 트리 만들어감
           int cnt = 0; // 쓰인 간선의 개수
           long result = 0; // 가중치 최소비용
           for (Edge edge : edgeList) {
               if(union(edge.start, edge.end)) {
                   result += edge.weight;
                   if(++cnt == V-1) break; // 신장트리 완성
               }
           }
            
           System.out.println("#"+t+" "+result);
        
       }
   }
    
   private static void make() {
       parents = new int[V];
       // 모든 원소를 자신을 대표자로 만듬
       for (int i = 0; i < V; i++) {
           parents[i] = i;
       }
   }
    
   // a가 속한 집합의 대표자 찾기
   private static int find(int a) {
       if(a == parents[a]) return a; // 자신이 대표자.
       return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
   }
    
   // 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
   private static boolean union(int a, int b) {
       int aRoot = find(a-1);
       int bRoot = find(b-1);
       if(aRoot == bRoot) return false; // 이미 같은 집합이라 합치지 않음
        
       parents[bRoot] = aRoot;
       return true;
   }

}