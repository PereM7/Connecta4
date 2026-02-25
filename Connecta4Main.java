package Principi.Reptes.Connecta4;

public class Connecta4Main {

    public static void main(String[] args) {

        char[][] tablero = {
                {'x','o',' ','o','x',' ',' '},
                {'o','x','o','x','x','o','o'},
                {' ','o','x','o','o',' ','x'},
                {'o',' ','x','o','x','x','o'},
                {'x','o',' ',' ','x','x','o'},
                {'x','x','o','x',' ','o','x'}
        };

        Connecta4 joc = new Connecta4();
        joc.jugar();
    }
}
