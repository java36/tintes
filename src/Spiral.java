import java.util.*;

public class Spiral {

    private List<Square> spiral;

    public Spiral(){
        spiral = new ArrayList<>();
    }

    public List<Square> getSpiral() {
        return spiral;
    }

    public List<Square> generateSpiral(int num){

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

    public int findShortestRoute(int start, int finish){

        Square firstSquare = findByNumber(start);
        Square lastSquare = findByNumber(finish);

        Queue<List<Square>> pathQ = new LinkedList<>();

        Set<Square> visited = new HashSet<>();

        List<Square> pathToSQ = new ArrayList<>();

        pathToSQ.add(firstSquare);
        visited.add(firstSquare);

        pathQ.add(pathToSQ);

        while(!pathQ.isEmpty()){
            pathToSQ = pathQ.poll();
            Square sq = pathToSQ.get(pathToSQ.size()-1);
            if(sq.equals(lastSquare)){
                return pathToSQ.size()-1;
            }
            visited.add(sq);

            List<Square> nextSQs = getUnvisitedSquares(sq, visited);

            for(Square s : nextSQs){
                List<Square> pathToNextSq = new ArrayList<>(pathToSQ);
                pathToNextSq.add(s);
                pathQ.add(pathToNextSq);
                visited.add(s);
            }
        }

        if(pathQ.isEmpty()){
            return 0;
        }
        else{
            return ((LinkedList<List<Square>>) pathQ).get(pathQ.size()-1).size();
        }
    }

    public boolean isPrime(int a){
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

    public boolean isSquareValid(Square square){

        if(square.equals(null) || !spiral.contains(square)){
            return false;
        }
        return true;
    }

    public Square findByNumber(int n){

        for(Square s : spiral){
            if(s.getNumber() == n){
                return s;
            }
        }
        return new Square();
    }

    public Square findByCoordinates(int x, int y){
        for(Square s : spiral){
            if((s.getX() == x) && s.getY() == y){
                return s;
            }
        }
        return new Square();
    }

    public Square moveUp(Square square){
        return findByCoordinates(square.getX(), square.getY() + 1);
    }
    public Square moveDown(Square square){
        return findByCoordinates(square.getX(), square.getY() - 1);
    }

    public Square moveRight(Square square){
        return findByCoordinates(square.getX() + 1, square.getY());
    }

    public Square moveLeft(Square square){
        return findByCoordinates(square.getX() - 1, square.getY());
    }

    public List<Square> getUnvisitedSquares(Square square, Set<Square> visited){
        List<Square> unvisited = new ArrayList<>();

        Square up = moveUp(square);
        if(isSquareValid(up) && !isPrime(up.getNumber()) && !visited.contains(up)){
            unvisited.add(up);
        }

        Square down = moveDown(square);
        if(isSquareValid(down) && !isPrime(down.getNumber()) && !visited.contains(down)){
            unvisited.add(down);
        }

        Square right = moveRight(square);
        if(isSquareValid(right) && !isPrime(right.getNumber()) && !visited.contains(right)){
            unvisited.add(right);
        }

        Square left = moveLeft(square);
        if(isSquareValid(left) && !isPrime(left.getNumber()) && !visited.contains(left)){
            unvisited.add(left);
        }

        return unvisited;
    }
}
