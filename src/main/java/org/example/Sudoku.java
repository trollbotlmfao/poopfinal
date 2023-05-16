package org.example;
import java.util.*;

public class Sudoku {
    private final int N = 9;
    private int[][] grid = new int[N][N];
    private int solutions = 0;
    private int[][] solveGrid = new int[N][N];

    private int errorsRemaining = 5;

    public Sudoku(String dif) {
        this.grid = createGrid(dif);
        solveGrid = cloneGrid(grid);
        Solver.solveSudoku(solveGrid, N);
    }


    private int[][] cloneGrid(int[][] g) {
        int[][] temp = new int[9][9];
        for (int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                temp[i][j] = g[i][j];
            }
        }
        return temp;
    }

    private int[][] createGrid(String dif) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for (int i = 0; i < 5; i++) {
            board[(int)(Math.random() * 9)][(int)(Math.random() * 9)] = (int)(Math.random() * 9 + 1);
        }
        // removed semicolon here
        while (!(Solver.solveSudoku(board, N))) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j ++) {
                    board[i][j] = 0;
                }
            }
            for (int i = 0; i < 8; i++) {
                board[(int)(Math.random() * 9)][(int)(Math.random() * 9)] = (int)(Math.random() * 9 + 1);
            }
        }
        Solver.solveSudoku(board, N);
        if (dif.equals("easy")) {
            for (int i = 0; i < 46; i++) {
                board[(int) (Math.random() * 9)][(int) (Math.random() * 9)] = 0;
                System.out.println("HELLO");
            }
        }
        return board;
    }


    public int[][] getGrid() {
        return this.grid;
    }

    public void printGrid() {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(grid[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }


    public void print() {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(solveGrid[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    public int[][] getSolution() {
        return solveGrid;
    }

    public int getBoard(int i, int j) {
        return this.grid[i][j];
    }

    public void setBoard(int i, int j, int value) {
        this.grid[i][j] = value;
    }


}
