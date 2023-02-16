package EightQueens;

import java.awt.*;
import java.util.ArrayList;

public class Queen {
    private Point position;

    public ArrayList<Queen> getConflictsWith() {
        return conflictsWith;
    }

    private final ArrayList<Queen> conflictsWith = new ArrayList<>();

    public boolean inConflict() {
        return inConflict;
    }

    public void setInConflict() {
        this.inConflict = true;
    }

    public void releaseConflict() {
        this.conflictsWith.clear();
        this.inConflict = false;
    }

    private boolean inConflict = false;

    public Queen(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void addConflict(Queen q) {
        this.conflictsWith.add(q);
    }

    public void moveUp() {
        this.position = new Point(this.position.x - 1, this.position.y);
    }

    public void moveDown() {
        this.position = new Point(this.position.x + 1, this.position.y);
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }
}