package com.chernyavsky.itrex.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Point {

    private int h;
    private int m;
    private int n;
    private Point previousPoint;

}
