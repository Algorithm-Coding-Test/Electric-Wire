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

        Collections.sort(lines, new Comparator<Line>(){
            @Override
            public int compare(Line line1, Line line2){
                if(line1.pointA > line2.pointA) return 1;
                else if(line1.pointA == line2.pointA) return 0;
                return -1;
            }
        });

        
        Value[] values = new Value[N];
        Value tmpValue;
        values[N-1] = new Value(lines.get(N-1).pointB, 1);
        
        for(int i = N-2; i >= 0; i--){
            
            if(values[i+1].firstNum > lines.get(i).pointB){
                values[i] = new Value(lines.get(i).pointB, values[i+1].value + 1);
                
            }else{
                tmpValue = values[i+1];
                for(int j = i + 2; j < N; j++){
                    if(values[j].firstNum > lines.get(i).pointB){
                        tmpValue = (tmpValue.value < values[j].value + 1) ? new Value(lines.get(i).pointB, values[j].value + 1) :
                                    (tmpValue.value == values[j].value + 1 && lines.get(i).pointB > tmpValue.firstNum) ? new Value(lines.get(i).pointB, values[j].value + 1) : tmpValue;

                    }
                }
                values[i] = tmpValue;
            }
        }
        System.out.println(lines.size() - values[0].value);
    }
    
}
