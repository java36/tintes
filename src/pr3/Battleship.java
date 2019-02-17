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
    private boolean gameOver;


    public Battleship(){

        scanner = new Scanner(System.in);

        testCases = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<testCases; i++){

            p1ships = 0;
            p2ships = 0;

            scanDimensions();

            p1field = scanBattlefield();
            p2field = scanBattlefield();

            p1ships = determineNumShips(p1field);
            p2ships = determineNumShips(p2field);

            for(int j=0; j<n/2; j++){

                playRound();

                System.out.println("p1" + p1ships);
                System.out.println("p2" + p2ships);

                if(gameOver){
                    if((p1ships == 0 && p2ships == 0) || (p1ships != 0 && p2ships != 0)){
                        System.out.println("draw");
                    }
                    else if(p1ships == 0){
                        System.out.println("player two wins");
                    }
                    else if(p2ships == 0){
                        System.out.println("player one wins");
                    }
                    break;
                }
            }

            if((p1ships == 0 && p2ships == 0) || (p1ships != 0 && p2ships != 0)){
                System.out.println("draw");
            }

        }

    }

    public void scanDimensions(){

            String input = scanner.nextLine();

            w = Integer.parseInt(input.substring(0, input.indexOf(' ')));

            String rest = input.substring(input.indexOf(' ') + 1);

            h = Integer.parseInt(rest.substring(0, rest.indexOf(' ')));
            n = Integer.parseInt(rest.substring(rest.indexOf(' ') + 1));
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
        int y = Integer.parseInt(input.substring(0, input.indexOf(' ')));
        int x = (h - 1) - Integer.parseInt(input.substring(input.indexOf(' ') + 1));
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

    public void playRound(){
        int[] p1hit = scanCoordinates();
        int[] p2hit = scanCoordinates();

        if(p2field[p1hit[0]] [p1hit[1]] == '#'){
            p2ships--;
        }

        p2field[p1hit[0]] [p1hit[1]] = '0';

        if(p1field[p2hit[0]] [p2hit[1]] == '#'){
            p1ships--;
        }

        p1field[p2hit[0]] [p2hit[1]] = '0';

        System.out.println("pl 2");
        for(int i=0; i<p2field.length; i++){
            for(int j=0; j<p2field[i].length; j++){
                System.out.print(p2field[i][j]);
            }
            System.out.println();
        }

        System.out.println("pl 1");

        for(int k=0; k<p1field.length; k++){
            for(int j=0; j<p1field[k].length; j++){
                System.out.print(p1field[k][j]);
            }
            System.out.println();
        }

        if(p1ships == 0 || p2ships == 0){
            System.out.println("game over!");
            gameOver = true;
        }
    }
}
