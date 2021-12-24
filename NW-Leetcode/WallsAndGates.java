import java.util.*;

public class WallsAndGates {

    public static void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                dfs(i,j,0,rooms);
            }
        }
    }

    private static void dfs(int i, int j, int count, int[][] rooms) {
        // Base Conditions
        if (i < 0 || j < 0 || i > rooms.length || j > rooms[0].length || rooms[i][j] < count) {
            return;
        }

        rooms[i][j] = count;
        dfs(i+1,j,count+1,rooms);
        dfs(i-1,j,count+1,rooms);
        dfs(i,j+1,count+1,rooms);
        dfs(i,j-1,count+1,rooms);
    }

    public static void main(String[] args) {

    }
}
