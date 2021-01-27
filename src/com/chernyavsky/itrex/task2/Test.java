package com.chernyavsky.itrex.task2;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = ParseFile.matrixInfo();
        String[][][] matrix = Matrix.parseAllMatrixs(list, 3, 3);
        System.out.println(Arrays.deepToString(matrix));
    }
//    private static String[][][] parseAllMatrixs(List<String> list, int n, int m) {
//        final String[][][] all = new String[n][][];
//        for (int i = 0; i < n; i++) {
//            all[i] = parseMatrix(list, i, m);
//        }
//        return all;
//    }
//
//    private static String[][] parseMatrix(List<String> list, int matrixNumber, int m) {
//        final String[][] matrix = new String[m][];
//        for (int i = 0; i < m; i++) {
//            matrix[i] = parseLine(list.get(matrixNumber * m + i));
//        }
//        return matrix;
//    }
//
//    private static String[] parseLine(String s) {
//        String[] line = new String[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            line[i] = String.valueOf(s.charAt(i));
//        }
//        return line;
//    }
}
