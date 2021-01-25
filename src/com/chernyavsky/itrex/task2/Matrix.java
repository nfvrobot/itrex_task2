package com.chernyavsky.itrex.task2;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static String[][][] buildAndInitializeMatrix() {
        List<String[]> list = convertListToStringArraysList();
        int lvl = 0;
        int row = 0;
        String[] array = ParseFile.searchMatrixHMN();
        int h_lvl_count = Integer.parseInt(array[0]);
        int m_rows_count = Integer.parseInt(array[1]);
        int n_column_count = Integer.parseInt(array[2]);

        String[][][] matrix = new String[h_lvl_count][m_rows_count][n_column_count];
        while(lvl < h_lvl_count) {
            for (String[] strings : list) {
                if (row == m_rows_count) {
                    lvl++;
                    row = 0;
                }
                matrix[lvl][row] = strings;
                row++;
            }
        }
        return matrix;
    }

    public static List<String[]> convertListToStringArraysList() {
        List<String> temp = ParseFile.matrixInfo();
        List<String[]> listOfStringsArrays = new ArrayList<>();
        for (String s : temp) {
            char[] tempChars = s.toCharArray();
            String[] tempString = new String[temp.size()];
            for (int i = 0; i < tempChars.length; i++) {
                tempString[i] = String.valueOf(tempChars[i]);
            }
        }
        return listOfStringsArrays;
    }

}
