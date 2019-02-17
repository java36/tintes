package pr3;

import java.util.Scanner;

public class Battleship {

    private int p1ships;
    private int p2ships;
    private int testCases;
    private Scanner scanner;
    private int w = 0;
    private int h = 0;
    private int n = 0;
    private char[][] p1field;
    private char[][] p2field;


    public Battleship(){
        p1ships = 0;
        p2ships = 0;

        scanner = new Scanner(System.in);

        testCases = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<testCases; i++){

            scanDimensions();

            p1field = scanBattlefield();
            p2field = scanBattlefield();

            p1ships = determineNumShips(p1field);
            p2ships = determineNumShips(p2field);

//            for(i=0; i<h; i++){
//                for (int j=0; j<w; j++){
//                    System.out.print(i +" " + j + " " + p1field[i][j] +" ");
//                }
//                System.out.println();
//            }
            scanCoordinates();
        }

    }

    public void scanDimensions(){

        for(int i=0; i<testCases; i++) {
            String input = scanner.nextLine();

            w = Integer.parseInt(input.substring(0, input.indexOf(' ')));

            String rest = input.substring(input.indexOf(' ') + 1);

            h = Integer.parseInt(rest.substring(0, rest.indexOf(' ')));
            n = Integer.parseInt(rest.substring(rest.indexOf(' ') + 1));
        }
    }

    public char[][] scanBattlefield(){

        char[][] battlefield = new char[h][w];

        for(int j=0; j<h; j++){

            String line = scanner.nextLine();

            for(int k=0; k<line.length(); k++){
                battlefield[j][k] = line.charAt(k);
            }
        }
        return battlefield;
    }

    public int[] scanCoordinates(){
        String input = scanner.nextLine();
        int x = Integer.parseInt(input.substring(0, input.indexOf(' ')));
        int y = w - Integer.parseInt(input.substring(input.indexOf(' ') + 1));
        int[] result = {x, y};
        return result;
    }

    public int determineNumShips(char[] [] field){

        int numShips = 0;
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[i].length; j++){
                if(field[i][j] == '#'){
                    numShips++;
                }
            }
        }
        System.out.println(numShips);
        return numShips;
    }
}
