package novi.spring.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;
    //public int[] speelveld;
    public char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int aantal_keer_gelijkspel;

    //Dennis zegt lege constructor nodig want entity
    public Game() {
    }

    public Game(char[] board, int aantal_keer_gelijkspel) { //int id,
        this.id = id;
        this.board = board;
        this.aantal_keer_gelijkspel = aantal_keer_gelijkspel;
    }


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public char[] getBoard() {
        return board;
    }

    public void setBoard(char[] board) {
        this.board = board;
    }

    public int getAantal_keer_gelijkspel() {
        return aantal_keer_gelijkspel;
    }

    public void setAantal_keer_gelijkspel(int aantal_keer_gelijkspel) {
        this.aantal_keer_gelijkspel = aantal_keer_gelijkspel;
    }
}
