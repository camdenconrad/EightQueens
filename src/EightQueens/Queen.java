package EightQueens;

import java.awt.*;

public class Queen {
    private Point position;
    private boolean inConflict = false;

    public Queen(Point position) {
        this.position = position;
    }

    public boolean inConflict() {
        return inConflict;
    }

    public void setInConflict() {
        this.inConflict = true;
    }

    public void releaseConflict() {
        this.inConflict = false;
    }

    public Point getPosition() {
        return position;
    }

    public void moveDown() {
        this.position = new Point(this.position.x + 1, this.position.y);
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }
}
