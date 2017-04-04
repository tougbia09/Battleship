package edu.utep.cs.cs4330.battleship;

/**
 * Created by oscarricaud on 3/31/17.
 */
class Player {
    public int[][] map = new int[10][10]; // size of the grid
    private String typeOfPlayer;
    Ship aircraft = new Ship(5, "aircraft", getTypeOfPlayer());
    Ship battleship = new Ship(4, "battleship", getTypeOfPlayer());
    Ship destroyer = new Ship(3, "destroyer", getTypeOfPlayer());
    Ship submarine = new Ship(3, "submarine", getTypeOfPlayer());
    Ship patrol = new Ship(2, "patrol", getTypeOfPlayer());
    private Board humanBoard = new Board(10);

    Player(String player, Board board) {
        if (player.equals("human")) {
            setTypeOfPlayer("human");
            setHumanBoard(board);
        }
    }

    public void addCoordinates(int[][] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates.length; j++) {
                if (coordinates[i][j] == 1) { // Aircraft
                    map[i][j] = 1;
                }
                if (coordinates[i][j] == 2) { // Battleship
                    map[i][j] = 2;
                }
                if (coordinates[i][j] == 3) { // Destroyer
                    map[i][j] = 3;
                }
                if (coordinates[i][j] == 4) { // Submarine
                    map[i][j] = 4;
                }
                if (coordinates[i][j] == 5) { // Patrol
                    map[i][j] = 5;
                }
            }
        }
    }

    public void removeCoordinates(int[][] coordinates, String typeOfShip) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates.length; j++) {
                if (typeOfShip.equals("aircraft") && coordinates[i][j] == 1) { // Remove aircraft coordinates
                    map[i][j] = -1;
                }
                if (typeOfShip.equals("battleship") && coordinates[i][j] == 2) { // Remove aircraft coordinates
                    map[i][j] = -2;
                }
                if (typeOfShip.equals("destroyer") && coordinates[i][j] == 3) { // Remove destroyer coordinates
                    map[i][j] = -3;
                }
                if (typeOfShip.equals("submarine") && coordinates[i][j] == 4) { // Remove submarine coordinates
                    map[i][j] = -4;
                }
                if (typeOfShip.equals("patrol") && coordinates[i][j] == 5) { // Remove patrol coordinates
                    map[i][j] = -5;
                }
            }
        }
    }

    public String getTypeOfPlayer() {
        return typeOfPlayer;
    }

    public void setTypeOfPlayer(String typeOfPlayer) {
        this.typeOfPlayer = typeOfPlayer;
    }

    public Board getHumanBoard() {
        return humanBoard;
    }

    public void setHumanBoard(Board humanBoard) {
        this.humanBoard = humanBoard;
    }

}
