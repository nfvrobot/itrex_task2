package com.chernyavsky.itrex.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

    public static String[][][] buildAndInitializeMatrix() {
        List<String> list = ParseFile.matrixInfo();
        String[] array = ParseFile.searchMatrixHMN();
        int h_lvl_count = Integer.parseInt(array[0]);
        int m_rows_count = Integer.parseInt(array[1]);
        int n_column_count = Integer.parseInt(array[2]);
        return Matrix.parseAllMatrixs(list, n_column_count, m_rows_count);
    }

    public static String[][][] parseAllMatrixs(final List<String> list, int n, int m) {
        final String[][][] all = new String[n][][];
        for (int i = 0; i < n; i++) {
            all[i] = parseMatrix(list, i, m);
        }
        return all;
    }

    private static String[][] parseMatrix(List<String> list, int matrixNumber, int m) {
        final String[][] matrix = new String[m][];
        for (int i = 0; i < m; i++) {
            matrix[i] = parseLine(list.get(matrixNumber * m + i));
        }
        return matrix;
    }

    private static String[] parseLine(String s) {
        String[] line = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            line[i] = String.valueOf(s.charAt(i));
        }
        return line;
    }

}
