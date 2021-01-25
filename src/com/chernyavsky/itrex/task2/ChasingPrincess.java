package com.chernyavsky.itrex.task2;

import java.util.LinkedList;
import java.util.Queue;

public class ChasingPrincess {

    private static Queue<Point> pointQueue = new LinkedList<>();
    private static final String[][][] matrix = Matrix.buildAndInitializeMatrix();
    private static String[] matrixInfo = ParseFile.searchMatrixHMN();
    private static final int h_lvl_count = Integer.parseInt(matrixInfo[0]);
    private static final int m_rows_count = Integer.parseInt(matrixInfo[1]);
    private static final int n_columns_count = Integer.parseInt(matrixInfo[2]);
    private static int countStep = 0;
    private static final int SEC_PER_STEP = 5;


    private static Point algorithmBFS(int h, int m, int n) {

        pointQueue.add(new Point(h, m, n, null));

        while (!pointQueue.isEmpty()) {

            Point activeP = pointQueue.remove();

            if (matrix[activeP.getH()][activeP.getM()][activeP.getN()].equals("2")) {
                return activeP;
            }

        }
        return null;
    }

    private static boolean freePoint(int x, int y, int z) {
        return (x >= 0 && x < h_lvl_count)
                && (y >= 0 && y < m_rows_count)
                && (z >= 0 && z < n_columns_count)
                && ((matrix[x][y][z].equals(".")) || (matrix[x][y][z].equals("2")));
    }

    public static String start() {
        Point p = algorithmBFS(0, 0, 0);
        if (p != null) {
            while (p.getPreviousPoint() != null) {
                System.out.println(p);
                p = p.getPreviousPoint();
                countStep++;
            }
        }
        System.out.println(countStep * SEC_PER_STEP);
        return String.valueOf((countStep * SEC_PER_STEP));
    }
}
