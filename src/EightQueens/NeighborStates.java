package EightQueens;

public class NeighborStates extends Board {

    public Board[] getStates() {
        return states;
    }

    private final Board[] states = new Board[1];
    public NeighborStates(Board b) {
        int conflicts = Helper.findConflicts(b.getQueens());

        // fix a conflict
        //for(Queen q : board.getQueens()) {

        for(int i = 0; i < states.length; i++) {

            states[i] = new Board(b);
        }


        for (Board state : states) {

            Queen q = state.getQueens()[new java.util.Random().nextInt(8)];

            if (q.inConflict()) {

                int bestX = q.getPosition().x;
                int numConflicts = Helper.findConflicts(state.queens);

                q.setPosition(0, q.getPosition().y);
                while (q.getPosition().x < 8) {
                    q.moveDown();
                    if (Helper.findConflicts(state.queens) < numConflicts) {
                        bestX = q.getPosition().x;
                    }
                }

                if (numConflicts > Helper.findConflicts(state.queens)) {
                    q.setPosition(bestX, q.getPosition().y);
                }

            }
        }
    }
}
