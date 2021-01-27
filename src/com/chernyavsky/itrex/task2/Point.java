package com.chernyavsky.itrex.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Point {

    private int h;
    private int m;
    private int n;
    private Point parent;
    private String value;
    private ArrayList<Point> pointsAround = new ArrayList<>();
    private boolean isVisited;
    private int steps;

    public Point(int h, int m, int n) {
        this.h = h;
        this.m = m;
        this.n = n;
    }

    public Point(int h, int m, int n, String value) {
        this.h = h;
        this.m = m;
        this.n = n;
        this.value = value;
    }
}
