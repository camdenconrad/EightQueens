package EightQueens;

public class NeighborStates {

    private final Board[] states = new Board[256];

    public NeighborStates(Board b) {
        // fix a conflict
        //for(Queen q : board.getQueens()) {

        for (int i = 0; i < states.length; i++) {

            states[i] = new Board(b);
        }


        int nWithLowerH = 0;
        for (Board state : states) {

            TaskThread thread = new TaskThread();
            int startNumConflicts = Helper.findConflicts(state.queens);

            state = thread.run(state);

            if (64 - Helper.findConflicts(state.queens) <= startNumConflicts) {
                nWithLowerH++;
            }


        }

        Helper.setH(nWithLowerH);
    }

    public Board[] getStates() {
        return states;
    }


}
