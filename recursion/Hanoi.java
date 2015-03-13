/**
 * Tower of Hanoi
 * Game objective:
 *     move all plates from source stick to destination stick with minimum moves
 * Game rules:
 *     1. use the third stick as option
 *     2. anytime a larger plate cannot be placed upon a smaller plate
 */
public class Hanoi {
    /*
     * How to run: java Hanoi <n>
     * @param n - number of plates to move
     */
    public static void main(String[] args) {
        Hanoi demo = new Hanoi();
        int n = 0;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        demo.hanoi(n, "P1", "P2", "P3");
    }

    /*
     * The algorithm to play a Tower of Hanoi game
     * Move a stack of n plates from the first stick to the second stick
     * use the third stick as an option
     *
     * @param n - number of plates indexed from 1 to n
     */
    public void hanoi(int n, String stick1, String stick2, String stick3) {
        move(1, n, stick1, stick2, stick3);
    }

    /*
     * the recursive function to move a stack of plates from 'start' to 'end'
     *
     * @param start - integer, the index of the top plate of the stack to move
     * @param end   - integer, the index of the bottom plate of the stack to move
     * @param from  - String, the name of the stick to move from
     * @param to    - String, the name of the stick to move to
     * @param aid   - String, the name of the stick to use as an aid stick
     * @return none
     */
    private void move(int start, int end, String from, String to, String aid) {
        // base cases
        if (start > end) return;
        if (start == end) {
            step(start, from, to);
            return;
        }
        // start < end
        move(start, end-1, from, aid, to);
        move(end, end, from, to, aid);
        move(start, end-1, aid, to, from);
    }

    /*
     * this execution of moving plate with id 'id' from 'from' peg to 'to' peg
     * this can be customized based on real application, like a moving robot arm
     *
     * @param id   - integer, the id of the plate to move
     * @param from - String, the name of the stick to move from
     * @param to   - String, the name of the stick to move to
     * @return none
     */
    private void step(int id, String from, String to) {
        System.out.println("Moving " + id + " from " + from + " to " + to);
    }
}
