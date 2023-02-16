package EightQueens;

public class Main {
    public static void main(String[] args) {

        System.out.println("START.");

        int restarts = 0;
        int stateChanges = 0;

        Board neighbor = Helper.bestNeighbor(new NeighborStates(new Board()).getStates());

        int conflicts = Helper.findConflicts(neighbor.getQueens());
        while (conflicts > 0) {
            System.out.println("Current h (conflicts): " + conflicts);
            System.out.println("Current State");

            neighbor = Helper.bestNeighbor(new NeighborStates(neighbor).getStates());

            System.out.print(neighbor.printBoard());

            System.out.println("Neighbors found with lower h: " + Helper.currentH());
            System.out.println("Setting new current state\n");
            stateChanges++;
//
            if (!(Helper.findConflicts(neighbor.getQueens()) < conflicts)) {
                neighbor.restart();
                System.out.println("RESTARTED\n");
                restarts++;
            }

            conflicts = Helper.findConflicts(neighbor.getQueens());
        }

        System.out.println("Current h (conflicts): " + conflicts);
        System.out.println("\nCurrent State");

        System.out.print(neighbor.printBoard());
        System.out.println("Solution found!");
        System.out.println("State changes: " + stateChanges);
        System.out.println("Restarts: " + restarts);


    }


}