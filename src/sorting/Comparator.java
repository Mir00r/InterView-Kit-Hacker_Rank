import java.io.*;
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method

    /**
     * In short, when sorting in ascending order, a comparator function returns
     * if (a < b) return -1,
     * if (a == b) return 0 ,
     * and  if (a > b) return 1.
     * <p>
     * for descending order logic will be swiped
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        } else {
            if (a.score < b.score) return -1;
            else
                return 1;
        }
    }
}

public class Comparator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

}
