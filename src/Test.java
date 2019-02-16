import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        List<Square> spiral = generateSpiral(25);

        Square testFind = findByNumber(10, spiral);
        System.out.println(testFind);

        Square test2 = findByCoordinates(5, 6, spiral);
        System.out.println(test2);

//        for(Square s : spiral){
//            System.out.println(s.toString());
//        }


    }

    public static List<Square> generateSpiral(int num){

        List<Square> spiral = new ArrayList<>();
        int xbefore = 0;
        int ybefore = 0;
        int x=0;
        int y=0;
        for(int i=1; i<num+1; i++){
            if(i == 1){
                x = 0;
                y = 0;
            }
            else{
                x = (int)((int) xbefore + Math.sin((Math.floor(Math.sqrt((4*(i-2))+1)) %4) * Math.PI/2));
                y = (int)((int) ybefore - Math.cos((Math.floor(Math.sqrt((4*(i-2))+1)) %4) * Math.PI/2));
            }

            Square square = new Square(i, x, y);
            spiral.add(square);

            xbefore = x;
            ybefore = y;
        }

        return spiral;
    }

    public static boolean isPrime(int a){
        if(a%2 == 0){
            return false;
        }
        for(int i=3; i*i<=a; i+=2){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }

    public static Square findByNumber(int n, List<Square> squares){

        for(Square s : squares){
            if(s.getNumber() == n){
                return s;
            }
        }
        return null;
    }

    public static Square findByCoordinates(int x, int y, List<Square> squares){
        for(Square s : squares){
            if((s.getX() == x) && s.getY() == y){
                return s;
            }
        }
        return null;
    }

    public static Square moveUp(Square square){
        return findByCoordinates(square.getX(), square.getY() +1);
    }
}
