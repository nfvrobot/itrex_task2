package com.chernyavsky.itrex.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseFile {

    public static final String FILENAME = "resources/INFO.txt";

    public static String[] searchMatrixHMN() {
        List<String> tempList = new ArrayList<>();
        String[] matrixPoints = new String[3];

        try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
            tempList = stream
                    .limit(1L)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : tempList) {
            matrixPoints = s.split(" ");
        }
        return matrixPoints;
    }

    public static List<String> matrixInfo() {
        List<String> matrix = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
            matrix = stream
                    .skip(1L)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }
}