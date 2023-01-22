/* On a 0-indexed 8 x 8 chessboard, there can be multiple black queens ad one white king... You are given a 2D integer array queens where queens[i] = [xQueen i, yQueen i] represents the position of the ith black queen on the chessboard... You are also given an integer array king of length 2 where king = [xKing, yKing] represents the position of the white king... Return the coordinates of the black queens that can directly attack the king... You may return the answer in any order...
 * Eg 1: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]]       king = [0,0]    Output: [[0,1],[1,0],[3,3]]
 * Eg 2: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]] king = [3,3]    Output: [[2,2],[3,4],[4,4]]
 */
import java.util.*;
public class QueenI
{
    public List<List<Integer>> QueensThatCanKill(int queens[][], int king[])
    {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        boolean visited[][] = new boolean[8][8];    // Matrix representing chessboard...
        for(int queen[] : queens)
        {
            visited[queen[0]][queen[1]] = true;
        }
        int direction[] = {-1, 0, 1};   // The possible directions...
        for(int x: direction)  
        {   // For every X coordinate we can move either up or down or stay...
            for(int y: direction)
            {   // For every Y coordinate we can move either u or down or stay...
                if((x == 0) && (y == 0))   // We are on same square, we skip the iteration...
                    continue;
                int x1 = king[0], y1 = king[1];   // Getting the position of the White King...
                while((x1 + x >= 0) && (x1 + x < 8) && (y1 + y >= 0) && (y1 + y < 8))
                {
                    x1 = x1 + x;    // Moving the King in a direction...
                    y1 = y1 + y;    // Moving the King in a direction...
                    if(visited[x1][y1] == true)
                    {   // When we find the first queen in that direction within the Chessboard we exit the loop and stop moving in that direction...
                        list.add(Arrays.asList(x1, y1));     // Adding the index of the Queen...
                        break;
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Black Queens : ");
        x = sc.nextInt();
        int queens[][] = new int[x][2];
        for(int i = 0; i < queens.length; i++)
        {
            System.out.print("Enter the X coordinate of "+(i+1)+" th Queen : ");
            queens[i][0] = sc.nextInt();
            System.out.print("Enter the Y coordinate of "+(i+1)+" th Queen : ");
            queens[i][1] = sc.nextInt();
        }
        int king[] = new int[2];
        System.out.print("Enter the X Coordinate of the White King : ");
        king[0] = sc.nextInt();
        System.out.print("Enter the Y Coordinate of the White King : ");
        king[1] = sc.nextInt();
        QueenI queenI = new QueenI();     // Object creation...
        List<List<Integer>> lst = queenI.QueensThatCanKill(queens, king);
        for(int i = 0; i < lst.size(); i++)
            System.out.print("["+lst.get(i).get(0)+", "+lst.get(i).get(1)+"], ");
        sc.close();
    }
}

// Time Complexity  - O(1) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. We move in all eight possible directions in the chessboard from the position of the King...
 * 2. The firs Queen encountered in every direction within the chessboard is added to the List...
*/