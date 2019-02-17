package pr3;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        int p1ships = 0;
        int p2ships = 0;

        Scanner scanner = new Scanner(System.in);


            int testCases = Integer.parseInt(scanner.nextLine());

            for(int i=0; i<testCases; i++){
                String input = scanner.nextLine();

                int w = Integer.parseInt(input.substring(0, input.indexOf(' ')));

                String rest = input.substring(input.indexOf(' ') + 1);

                int h = Integer.parseInt(rest.substring(0, rest.indexOf(' ')));
                int n = Integer.parseInt(rest.substring(rest.indexOf(' ') +1));

                char[][] p1field = new char[h][w];
                char[][] p2field = new char[h][w];

                for(int j=0; j<h; j++){

                    String line = scanner.nextLine();

                    for(int k=0; k<line.length(); k++){
                        p1field[j][k] = line.charAt(k);
                        if(line.charAt(k) == '#'){
                            p1ships++;
                        }
                    }
                }

                for(int l=0; l<h; l++){

                    String line = scanner.nextLine();

                    for(int m=0; m<line.length(); m++){
                        p2field[l][m] = line.charAt(m);

                        if(line.charAt(m) == '#'){
                            p2ships++;
                        }
                    }
                }
            }
    }
}
