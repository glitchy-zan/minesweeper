public class Tile {

    int locX;
    int locY;
    boolean mine;
    boolean uncovered;
    boolean marked;
    int number;

    Tile(int x, int y){
        this.locX = x;
        this.locY = y;
        this.mine = false;
        this.uncovered = false;
        this.marked = false;
        this.number = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }
}
