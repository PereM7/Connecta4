package Principi.Reptes.Connecta4;

public class Connecta4 {

    private final int ALTURA_JOC = 6;
    private final int AMPLARI_JOC = 7;
    private final char JUGADOR_1 = 'x';
    private final char JUGADOR_2 = 'o';

    private char[][] iniciarMatriuChar () {

        char[][] matriu = new char[ALTURA_JOC][AMPLARI_JOC];

        for (int fila = 0; fila < matriu.length; fila++) {
            for (int column = 0; column < matriu[fila].length; column++) {

                matriu[fila][column] = ' ';
            }
        }
        return matriu;
    }

    private void inserirFitxa (char[][] matriu, int fila, int columna, int torn) {



             if (matriu[fila][columna] == ' ') {
                 if (torn % 2 == 0){
                    matriu[fila][columna] = JUGADOR_1;
                 }
                 else {
                     matriu[fila][columna] = JUGADOR_2;
                 }
             }
    }

    private boolean casellesPlenas (char[][] matriu) {

        for (int fila = 0; fila < matriu.length; fila++) {
            for (int column = 0; column < matriu[fila].length; column++) {

                 if (matriu[fila][column] == ' ') {
                     return false;
                 }
            }
        }
        return true;
    }

    private int haConnectatHoritzontal (char[][] matriu, int fila) {

        int contadorX = 0;
        int contadorO = 0;

            for (int columna = 0; columna < matriu[fila].length; columna++) {

                switch(matriu[fila][columna]) {
                    case 'x': {
                        contadorX++;
                        contadorO = 0;
                        break;
                    }
                    case 'o': {
                        contadorO++;
                        contadorX = 0;
                        break;
                    }
                    default: {
                        contadorX = 0;
                        contadorO = 0;
                    }
                }

                if (contadorX == 4) {
                    return 1;
                }
                else if (contadorO == 4) {
                    return 2;
                }
            }

        return -1;
    }

    private int haConnectatVertical (char[][] matriu, int columna) {

        int contadorX = 0;
        int contadorO = 0;

        for (int fila = 0; fila < matriu.length; fila++) {

            switch(matriu[fila][columna]) {
                case 'x': {
                    contadorX++;
                    contadorO = 0;
                    break;
                }
                case 'o': {
                    contadorO++;
                    contadorX = 0;
                    break;
                }
                default: {
                    contadorX = 0;
                    contadorO = 0;
                }
            }

            if (contadorX == 4) {
                return 1;
            }
            else if (contadorO == 4) {
                return 2;
            }
        }
        return -1;
    }

    private int haConnectatDiagonalEsquerra(char[][] matriu) {

        int contadorX = 0;
        int contadorO = 0;

        for (int fila = 0; (fila < (matriu.length - 3)); fila++) {
            for (int columna = 0; (columna < (matriu[fila].length - 3)); columna++) {

                for (int indexX = fila, indexY = columna; (indexY < AMPLARI_JOC) && (indexX < ALTURA_JOC); indexX++, indexY++) {

                    if (matriu[indexX][indexY] == 'x') {
                        contadorX++;
                        contadorO = 0;
                    }
                    else if (matriu[indexX][indexY] == 'o') {
                        contadorO++;
                        contadorX = 0;
                    }
                    else {
                        contadorX = 0;
                        contadorO = 0;
                    }

                    if (contadorX == 4) {
                        return 1;
                    }
                    else if (contadorO == 4) {
                        return 2;
                    }
                }
                contadorX = 0;
                contadorO = 0;
            }
        }

        return -1;
    }

    private int haConnectatDiagonalDreta (char[][] matriu) {

        int contadorX = 0;
        int contadorO = 0;

        for (int fila = (matriu.length - 1); (fila >= 3); fila--) {
            for (int columna = 0; (columna < (matriu[fila].length - 3)); columna++) {

                for (int indexX = fila, indexY = columna; (indexY < ALTURA_JOC) && (indexX >= 0); indexX--, indexY++) {

                    if (matriu[indexX][indexY] == 'x') {
                        contadorX++;
                        contadorO = 0;
                    }
                    else if (matriu[indexX][indexY] == 'o') {
                        contadorO++;
                        contadorX = 0;
                    }
                    else {
                        contadorX = 0;
                        contadorO = 0;
                    }

                    if (contadorX == 4) {
                        return 1;
                    }
                    else if (contadorO == 4) {
                        return 2;
                    }
                }
                contadorX = 0;
                contadorO = 0;
            }
        }

        return -1;
    }

    private int haConnectat (char[][] matriu, int fila, int columna) {

        if (haConnectatHoritzontal(matriu, fila) != -1) {
            return haConnectatHoritzontal(matriu, fila);
        }
        else if (haConnectatVertical(matriu, columna) != -1) {
            return haConnectatVertical(matriu, fila);
        }
        else if (haConnectatDiagonalDreta(matriu) != -1) {
            return haConnectatDiagonalDreta(matriu);
        }
        else if (haConnectatDiagonalEsquerra(matriu) != -1) {
            return haConnectatDiagonalEsquerra(matriu);
        }

        return -1;
    }

    private void displayJoc (char[][] matriu, int torn) {

        for (int fila = 0; fila < matriu.length; fila++) {
            for (int column = 0; column < matriu[fila].length; column++) {

                if (column == 0) {
                    System.out.print("|");
                }
                System.out.print(matriu[fila][column]+"|");
            }
            System.out.println();
        }
        System.out.println();
        if (torn % 2 == 0) {
            System.out.println("Torn de: " + JUGADOR_1);
        }else {
            System.out.println("Torn de: " + JUGADOR_2);
        }
    }

    private int calcFila (char[][] matriu, int columna) {

        for (int fila = matriu.length - 1; fila >= 0 ; fila--) {

            if (matriu[fila][columna] == ' ') {
                return columna;
            }
        }
        return -1;
    }

    public void jugar() {

        char[][] tablero = iniciarMatriuChar();
        int columna = 0;
        int fila = 0;
        int torn = 0;

        do {
            displayJoc(tablero, torn);

        }while (haConnectat(tablero, fila, columna));

    }
}

