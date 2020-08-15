import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();

        int pointA, pointB;
        Map<Integer, Integer> lines = new HashMap<Integer, Integer>();
        
        for(int i=0;i<N;i++){
            pointA = scan.nextInt();
            pointB = scan.nextInt();
            
            lines.put(pointA, pointB);

            scan.nextLine();
        }
        // Sort by A point
        TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>(lines);
        Iterator<Integer> iteratorKey = tree.keySet( ).iterator( );
      
        ArrayList<Integer> bPoints = new ArrayList<>();
        
        while(iteratorKey.hasNext()) bPoints.add(lines.get(iteratorKey.next()));
        
        int[] map = new int[N];
        int tmpMax;
        int maxNum =0;
        
        // Apply LIS Algorithm at B sequence

        for(int i =0;i<N;i++) map[i] = 1;
        
        for(int i = 1;i < N;i ++) {
        	tmpMax = map[i];
        	for(int j = i-1;j >= 0;j--) {
        		if(bPoints.get(j) < bPoints.get(i) && tmpMax <= map[j]) {
        			tmpMax = map[j]+1;
        		}
        	}
        	map[i] = tmpMax;
        }
        
        for(int i = 0;i < N;i++) {
    		maxNum = (maxNum < map[i]) ? map[i] : maxNum;
    	}
        System.out.println(N-maxNum);
        

    }
    
    
    
}