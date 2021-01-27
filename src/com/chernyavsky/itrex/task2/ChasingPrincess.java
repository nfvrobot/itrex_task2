package com.chernyavsky.itrex.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ChasingPrincess {

    private static final Queue<Point> pointQueue = new LinkedList<>();
    private static final ArrayList<Point> POINT_ARRAY_LIST = new ArrayList<>();
    private static final String[][][] MATRIX = Matrix.buildAndInitializeMatrix();
    private static final String[] MATRIX_INFO = ParseFile.searchMatrixHMN();
    private static final int H_LVL_COUNT = Integer.parseInt(MATRIX_INFO[0]);
    private static final int M_ROWS_COUNT = Integer.parseInt(MATRIX_INFO[1]);
    private static final int N_COLUMNS_COUNT = Integer.parseInt(MATRIX_INFO[2]);
    private static final int SEC_PER_STEP = 5;
    private static final Point PRINCE = new Point(0, 0, 0);
    private static final Point PRINCESS = new Point(H_LVL_COUNT - 1, M_ROWS_COUNT - 1, N_COLUMNS_COUNT - 1);
    public static final String PRINCESS_SIGNATURE = "2";
    public static final String FREE_POINT_SIGNATURE = ".";


    public static void createList() {
        for (int i = 0; i < H_LVL_COUNT; i++) {
            for (int j = 0; j < M_ROWS_COUNT; j++) {
                for (int k = 0; k < N_COLUMNS_COUNT; k++) {
                    Point p = new Point(i, j, k, MATRIX[i][k][j]);
                    if (i < H_LVL_COUNT - 1 && (MATRIX[i + 1][j][k].equals(FREE_POINT_SIGNATURE) || MATRIX[i + 1][j][k].equals(PRINCESS_SIGNATURE)))
                        p.getPointsAround().add(new Point(i + 1, j, k, MATRIX[i + 1][j][k]));
                    if (j < M_ROWS_COUNT - 1 && (MATRIX[i][j + 1][k].equals(FREE_POINT_SIGNATURE) || MATRIX[i][j + 1][k].equals(PRINCESS_SIGNATURE)))
                        p.getPointsAround().add(new Point(i, j + 1, k, MATRIX[i][j + 1][k]));
                    if (j > 0 && (MATRIX[i][j - 1][k].equals(FREE_POINT_SIGNATURE) || MATRIX[i][j - 1][k].equals(PRINCESS_SIGNATURE)))
                        p.getPointsAround().add(new Point(i, j - 1, k, MATRIX[i][j - 1][k]));
                    if (k < N_COLUMNS_COUNT - 1 && (MATRIX[i][j][k + 1].equals(FREE_POINT_SIGNATURE) || MATRIX[i][j][k + 1].equals(PRINCESS_SIGNATURE)))
                        p.getPointsAround().add(new Point(i, j, k + 1, MATRIX[i][j][k + 1]));
                    if (k > 0 && (MATRIX[i][j][k - 1].equals(FREE_POINT_SIGNATURE) || MATRIX[i][j][k - 1].equals(PRINCESS_SIGNATURE)))
                        p.getPointsAround().add(new Point(i, j, k - 1, MATRIX[i][j][k - 1]));
                    POINT_ARRAY_LIST.add(p);
                }
            }
        }
    }

    public static int catchThePrincess() {
        createList();
        Point point = getPointFromList(PRINCE);
        pointQueue.add(point);
        assert point != null;
        point.setVisited(true);
        while (!pointQueue.isEmpty()) {
            Point p = pointQueue.poll();
            if (!p.getValue().equals("2")) {
                if (!p.getPointsAround().isEmpty()) {
                    ArrayList<Point> temp = p.getPointsAround();
                    for (Point value : temp) {
                        Point neighbor = getPointFromList(value);
                        assert neighbor != null;
                        if (!neighbor.isVisited()) {
                            neighbor.setVisited(true);
                            neighbor.setSteps(p.getSteps() + 1);
                            pointQueue.add(neighbor);
                        }
                    }
                }
            } else break;
        }
        return (Objects.requireNonNull(getPointFromList(PRINCESS))).getSteps() * SEC_PER_STEP;
    }

    private static Point getPointFromList(Point point) {
        for (Point p : POINT_ARRAY_LIST) {
            if (point.getH() == p.getH() &&
                    point.getM() == p.getM() &&
                    point.getN() == p.getN()) {
                return p;
            }
        }
        return null;
    }

}
