/**
 * @author zhanyuhao
 * @time 2021/9/11 23:27
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private class Grid{
        private int rowStartIndex;
        private int colStartIndex;
        private int rowEndIndex;
        private int colEndIndex;
    }
    private Grid[] grids;
    public Solution(){
        grids = new Grid[5];
        Grid grid1 = new Grid();
        grid1.rowStartIndex = 0; grid1.rowEndIndex = 8;
        grid1.colStartIndex = 0; grid1.colEndIndex = 8;
        Grid grid2 = new Grid();
        grid2.rowStartIndex = 12; grid2.rowEndIndex = 20;
        grid2.colStartIndex = 0; grid2.colEndIndex = 8;
        Grid grid3 = new Grid();
        grid3.rowStartIndex = 0; grid3.rowEndIndex = 8;
        grid3.colStartIndex = 12; grid3.colEndIndex = 20;
        Grid grid4 = new Grid();
        grid4.rowStartIndex = 12; grid4.rowEndIndex = 20;
        grid4.colStartIndex = 12; grid4.colEndIndex = 20;
        Grid grid5 = new Grid();
        grid5.rowStartIndex = 6; grid5.rowEndIndex = 14;
        grid5.colStartIndex = 6; grid5.colEndIndex = 14;
        grids[0] = grid1;
        grids[1] = grid2;
        grids[2] = grid3;
        grids[3] = grid4;
        grids[4] = grid5;
    }

    public static void main(String[] args) {
        char[][] grid = new char[21][];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 21; i++)
            grid[i] = sc.nextLine().toCharArray();
        new Solution().dfs(grid,0,0);

    }

    private void dfs(char[][] grid, int x, int y) {
        if(x == 21){
            print(grid);
            System.out.println();
            return;
        }
        if(grid[x][y]=='0') {
            for (int val = 1; val < 10; val++) {
                if (check(grid, x, y, val)) {
                    grid[x][y] = (char)(val + '0');
                    dfs(grid, x + (y + 1) / 21, (y + 1) % 21);
                    grid[x][y] = '0';
                }
            }
        }else {
            dfs(grid, x + (y + 1) / 21, (y + 1) % 21);
        }
    }

    private  boolean check(char[][] grid, int x, int y, int val) {
        List<Integer> res = getGridRange(x, y);
        char v = (char)(val + '0');
        for (Integer i : res) {
            int rowStart = grids[i -1 ].rowStartIndex;
            int rowEnd = grids[i - 1].rowEndIndex;
            int colStart = grids[i - 1].colStartIndex;
            int colEnd = grids[i - 1].colEndIndex;
            for (int j = rowStart; j <= rowEnd; j++)
                if (grid[x][j] == v)
                    return false;
            for (int j = colStart; j <= colEnd; j++)
                if (grid[j][y] == v)
                    return false;
            for (int j = (x / 3) * 3; j < (x / 3 + 1) * 3; j++) {
                for (int k = (y / 3) * 3; k < (y / 3 + 1) * 3; k++) {
                    if (grid[j][k] == v)
                        return false;
                }
            }
        }
        return res.size() != 0;
    }

    private List<Integer> getGridRange(int x, int y) {
        List<Integer> list = new ArrayList<>();
        if(x >= 6 && x <= 14 && y >= 6 && y <= 14)
            list.add(5);
        if(x >= 0 && x <= 8 && y >= 0 && y <= 8)
            list.add(1);
        else if(x >= 0 && x <= 8 && y >= 12 && y <= 20)
            list.add(2);
        else if(x >= 12 && x <= 20 && y >= 0 && y <= 8)
            list.add(3);
        else if(x >= 12 && x <= 20 && y >= 12 && y <= 20)
            list.add(4);
        return list;
    }
    private void print(char[][] grid) {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
