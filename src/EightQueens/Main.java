package EightQueens;

public class Main {
    public static void main(String[] args) {

        Board neighbor = Helper.bestNeighbor(new NeighborStates(new Board()).getStates());

        int conflicts = Helper.findConflicts(neighbor.getQueens());
        while (conflicts > 0) {
            System.out.println("Current h: " + conflicts);
            System.out.println("Current State");

            neighbor = Helper.bestNeighbor(new NeighborStates(neighbor).getStates());

            System.out.print(neighbor.printBoard());

            System.out.println("Neighbors found with lower h: " + Helper.currentH());
//
            if (!(Helper.findConflicts(neighbor.getQueens()) < conflicts)) {
                neighbor.restart();
                System.out.println("RESTARTED");
            }

            conflicts = Helper.findConflicts(neighbor.getQueens());
        }

        System.out.println("Current h: " + conflicts);
        System.out.println("Current State");

        System.out.print(neighbor.printBoard());
        System.out.println("Solution found!");


    }


}