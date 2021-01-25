package com.chernyavsky.itrex.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Point {

    private int x;
    private int y;
    private int z;
    private Point previous;

}