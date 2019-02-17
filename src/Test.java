import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Spiral spiral = new Spiral();

        spiral.generateSpiral(10000);

//        for(Square s : spiral.getSpiral()){
//            System.out.println(s);
//        }

//        System.out.println(spiral.findShortestRoute(6, 2));

        Scanner scanner = new Scanner(System.in);
        int counter = 1;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            if(line.equals("exit")){
                System.exit(0);
            }

            int breakpoint = line.indexOf(' ');
            int start = Integer.parseInt(line.substring(0, breakpoint));
            int finish = Integer.parseInt(line.substring(breakpoint + 1));

            System.out.println("Case " + counter + ": " + spiral.findShortestRoute(start, finish));
            counter++;
        }


    }


}
