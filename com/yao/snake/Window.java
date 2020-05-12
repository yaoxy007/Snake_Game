package com.yao.snake;

import javax.swing.*;

public class Window {
    public static void main(String[] args) {

        JFrame window=new JFrame();
        window.setBounds(100,100,900,720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        window.add(new GamePanel());
        window.setVisible(true);

    }
}
