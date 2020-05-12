package com.yao.snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    private static URL headUP = Data.class.getResource("/resources/up.png");
    private static URL headRIGHT = Data.class.getResource("/resources/right.png");
    private static URL headLEFT = Data.class.getResource("/resources/left.png");
    private static URL headDOWN = Data.class.getResource("/resources/down.png");

    static ImageIcon up = new ImageIcon(headUP);
    static ImageIcon right = new ImageIcon(headRIGHT);
    static ImageIcon left = new ImageIcon(headLEFT);
    static ImageIcon down = new ImageIcon(headDOWN);

    private static URL FOOD=Data.class.getResource("/resources/food.png");
    public static ImageIcon food = new ImageIcon(FOOD);

    private static URL BODY=Data.class.getResource("/resources/body.png");
    static ImageIcon body=new ImageIcon(BODY);
}
