package Interface;

public class Interface {

    public static void main(String[] args) {
        Queen q = new Queen();
        q.started();
        q.moves();

    }
}

interface ChessPlayer {
    void moves(); // Interface, without implements
}

interface Game { // Multiple Inerfaces and Inheritance
    void started();
}

class Queen implements ChessPlayer, Game { // Multiple Inheritance
    public void started() {
        System.out.println("Started...");
    }

    public void moves() {
        System.out.println("up, down, left, right, diagonal");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, right, left");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, right, left, Down by one steps");
    }
}
