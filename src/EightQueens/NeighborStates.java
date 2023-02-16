package EightQueens;

public class NeighborStates {

    private final Board[] states = new Board[128];

    public NeighborStates(Board b) {
        // fix a conflict
        //for(Queen q : board.getQueens()) {

        for (int i = 0; i < states.length; i++) {

            states[i] = new Board(b);
        }


        int nWithLowerH = 0;
        for (Board state : states) {

            Queen q = state.getQueens()[new java.util.Random().nextInt(8)];

            if (q.inConflict()) {

                int bestX = q.getPosition().x;
                int startNumConflicts = Helper.findConflicts(state.queens);

                q.setPosition(0, q.getPosition().y);

                while (q.getPosition().x < 7) {

                    q.moveDown();
                    if (Helper.findConflicts(state.queens) < startNumConflicts) {
                        bestX = q.getPosition().x;
                    }
                }

                if (Helper.findConflicts(state.queens) <= startNumConflicts) {
                    q.setPosition(bestX, q.getPosition().y);
                    nWithLowerH++;
                }



            }
        }

        Helper.setH(nWithLowerH);
    }

    public Board[] getStates() {
        return states;
    }
}
