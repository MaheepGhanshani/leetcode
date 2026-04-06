import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: 0: North, 1: East, 2: South, 3: West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Obstacles ko Set mein store karna fast lookup ke liye
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int x = 0, y = 0; // Current position
        int d = 0;        // Current direction (North)
        int maxDistSq = 0;
        
        for (int cmd : commands) {
            if (cmd == -1) {
                // Turn Right
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                // Turn Left
                d = (d + 3) % 4;
            } else {
                // Move forward 'cmd' steps
                for (int i = 0; i < cmd; i++) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    
                    // Check if next step is an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        // Max distance square update karo
                        maxDistSq = Math.max(maxDistSq, x * x + y * y);
                    } else {
                        // Obstacle mil gaya, ruk jao
                        break;
                    }
                }
            }
        }
        
        return maxDistSq;
    }
}