package edu.utep.cs.cs4330.battleship;

import java.util.LinkedList;

/**
 * Created by oscarricaud on 2/14/17.
 */
public class Ship {
    private int[][] map = new int[10][10]; // size of the grid
    private String typeOfPlayer;
    private int size;
    private String name;
    private boolean sink;
    private int hit;
    private boolean isPlaced;
    private LinkedList<Integer> xShipCoordinate = new LinkedList<>();
    private LinkedList<Integer> yShipCoordinate = new LinkedList<>();

    public Ship(int size, String nameofship, String typeOfUser) {
        if(typeOfUser.equals("Computer")){
            setSize(size);
            setName(nameofship);
            setTypeOfPlayer("computer");
            computerSetCoordinates();
            setSink(false);
        }
        if(typeOfUser.equals("Human")){
            setSize(size);
            setName(nameofship);
            setTypeOfPlayer("human");
            setSink(false);
        }
    }
    public int[][] clearContents(){
        // Clear all elements since the user wants to place boat elsewhere
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = -1;
            }
        }
        return map;
    }
    public void humanSetCoordinates(int size, int x, int y){
        // Boat has not been placed, therefore save user coordinates
        for (int i = 0; i < size; i++) {
            map[i + x][y] = 1;
        }
    }
    public void computerSetCoordinates() {
        int coordinatesRange = (map.length - getSize());
        int randomx = (int) (Math.random() * coordinatesRange);
        int randomy = (int) (Math.random() * coordinatesRange);
        int direction = (int) (Math.random() * 2);
        if(direction == 1) { // if boat is horizontal
            setPosition("Horizontal");
            for(int i = 0; i < getSize(); i++){ // place boat horizontal
                map[randomx][randomy+i] = 1; // Adding to the right of the head
            }
        }
        else{
            setPosition("Vertical");
            for(int j = 0; j < getSize(); j++){ // place boat vertical
                map[randomx+j][randomy] = 1; // Adding below of the head
            }
        }
    }
    public int[][] gethumanSetCoordinates(){
        return map;
    }

    public int[][] getComputerCordinates(){
        return map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        String position1 = position;
    }

    public boolean isSink() {
        return sink;
    }

    public void setSink(boolean sink) {
        this.sink = sink;
    }

    public int getHit() {
        return hit;
    }

    public void hit() {
        hit++;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public LinkedList<Integer> getX() {
        return xShipCoordinate;
    }

    public void setX(int x) {
        xShipCoordinate.add(x);
    }

    public LinkedList<Integer> getY() {
       return yShipCoordinate;
    }

    public void setY(int y) {
        yShipCoordinate.add(y);
    }

    public String getTypeOfPlayer() {
        return typeOfPlayer;
    }

    public void setTypeOfPlayer(String typeOfPlayer) {
        this.typeOfPlayer = typeOfPlayer;
    }
}
