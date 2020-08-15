import java.util.*;

public class Main {
    public static class Line{
        int pointA, pointB;

        public Line(int pointA, int pointB){
            this.pointA = pointA;
            this.pointB = pointB;
        }
    }
    public static class Value{
        int firstNum;
        int value;
        public Value(int firstNum, int value){
            this.firstNum = firstNum;
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        scan.nextLine();

        int pointA, pointB;
        ArrayList<Line> lines = new ArrayList<>();
        for(int i=0;i<N;i++){
            pointA = scan.nextInt();
            pointB = scan.nextInt();

            lines.add(new Line(pointA, pointB));
            scan.nextLine();
        }

        // Sort by A point
        Collections.sort(lines, new Comparator<Line>(){
            @Override
            public int compare(Line line1, Line line2){
                if(line1.pointA > line2.pointA) return 1;
                else if(line1.pointA == line2.pointA) return 0;
                return -1;
            }
        });
        
        ArrayList<Integer> bPoints = new ArrayList<>();
        
        for(int i=0;i<N;i++) bPoints.add(lines.get(i).pointB);
        
        System.out.println(N-LIS(bPoints));
        

    }
    // Apply LIS Algorithm at B sequence
    public static int LIS(ArrayList<Integer> arr){
    	int returnLength = 0;
    	ArrayList<Integer> tmpArr;
    	
    	if (arr.size() == 1) return 1;
    	
    	for(int i= 0;i<arr.size();i++) {
    		tmpArr = new ArrayList<>();
    		
    		for(int j=i+1;j<arr.size();j++) {
    			if(arr.get(i) < arr.get(j)) tmpArr.add(arr.get(j));
    		}
    		returnLength = Math.max(returnLength,1+LIS(tmpArr));
    	}
    	return returnLength;
    }
    
}
