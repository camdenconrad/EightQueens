package EightQueens;

import java.awt.*;

public class Helper {

    public static int h;

    public static void setH(int h) {
        Helper.h = h;
    }

    public static boolean inConflict(Point p1, Point p2) {

        double slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());

        double rads = Math.atan(slope);

        return Math.toDegrees(rads) % 45 == 0;
    }

    public static int findConflicts(Queen[] q) {
        int conflicts = 0;

        // release all conflicts before evaluation
        for (Queen q1 : q) {
            q1.releaseConflict();
        }

        // evaluation
        for (Queen q1 : q) {
            for (Queen q2 : q) {
                if (inConflict(q1.getPosition(), q2.getPosition())) {

                    q1.setInConflict();

                    q2.setInConflict();

                    conflicts++;
                }
            }
        }

        // q1 and q2 always conflict each other and therefore create 2 conflicts
        return conflicts;
    }

    public static Board bestNeighbor(Board[] states) {
        int bestBoard = 0;


        for (int i = 0; i < states.length; i++) {
            if (Helper.findConflicts(states[i].getQueens()) < Helper.findConflicts(states[bestBoard].getQueens())) {
                bestBoard = i;
            }

        }

        return states[bestBoard];
    }

    public static int currentH() {
        return h;
    }
}
