package com.chernyavsky.itrex.task2;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = ParseFile.matrixInfo();
        String[][][] matrix = Matrix.parseAllMatrix(list, 3, 3);
        System.out.println(Arrays.deepToString(matrix));
    }
}
