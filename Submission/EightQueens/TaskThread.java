package EightQueens;

public class TaskThread {

    public Board run(Board state) {

        Thread task = new Thread(() -> {
            Queen q = state.getQueens()[new java.util.Random().nextInt(state.boardSize)];

            if (q.inConflict()) {

                int bestX = q.getPosition().x;
                int startNumConflicts = Helper.findConflicts(state.queens);

                q.setPosition(0, q.getPosition().y);

                while (q.getPosition().x < state.boardSize - 1) {

                    q.moveDown();
                    if (Helper.findConflicts(state.queens) < startNumConflicts) {
                        bestX = q.getPosition().x;
                    }
                }

                if (Helper.findConflicts(state.queens) <= startNumConflicts) {
                    q.setPosition(bestX, q.getPosition().y);
                }

            }
        });
        task.start();

        return state;
    }
}
