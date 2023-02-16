package EightQueens;

public class Main {
    public static void main(String[] args) {

        Board neighbor = new NeighborStates(new Board());

        int conflicts = Helper.findConflicts(neighbor.getQueens());
        while (conflicts > 0) {
            neighbor = new NeighborStates(neighbor);

            System.out.println(neighbor.printBoard());
            System.out.println(Helper.findConflicts(neighbor.getQueens()));
//
            if (Helper.findConflicts(neighbor.getQueens()) > conflicts) {
                neighbor.restart();
                System.out.println("RESTARTED");
            }

            conflicts = Helper.findConflicts(neighbor.getQueens());
        }



    }


}