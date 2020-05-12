package com.yao.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private int length;
    private int[] snakeX=new int[600];
    private int[] snakeY=new int[500];
    private String direction;
    private boolean isStart;
    private int foodX;
    private int foodY;
    private Random random = new Random();

    private boolean fail;
    private int score;
    Timer timer=new Timer(100,this);

    GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();

    }

    private void init(){
        length = 3;
        snakeX[0] = 100;snakeY[0] = 100;
        snakeX[1] = 75;snakeY[1] = 100;
        snakeX[2] = 50;snakeY[2] = 100;
        direction="RIGHT";
        foodX= 25+25*random.nextInt(34);
        foodY = 75+25*random.nextInt(24);
        score=0;
        isStart=false;
        fail=false;
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        g.fillRect(25,75,850,600);

        if(direction.equals("RIGHT")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("UP")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("DOWN")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(direction.equals("LEFT")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for(int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        Data.food.paintIcon(this,g,foodX,foodY);

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("Length: "+length,750,35);
        g.drawString("Score: "+score,750,50);

        if(!isStart){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("Press space to start",250,300);
        }
        if(fail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("GAME OVER",250,300);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode=keyEvent.getKeyCode();

        if(keyCode==KeyEvent.VK_SPACE){
            if(fail){
                fail=false;
                init();
            }else {
                isStart = !isStart;
            }
            repaint();
        }
        if(keyCode==KeyEvent.VK_LEFT){
            direction="LEFT";
        }else if(keyCode==KeyEvent.VK_RIGHT){
            direction="RIGHT";
        }else if(keyCode==KeyEvent.VK_UP){
            direction="UP";
        }else if(keyCode==KeyEvent.VK_DOWN){
            direction="DOWN";
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(isStart && !fail){
            for(int i=length-1;i>0;i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            if(direction.equals("RIGHT")){
                snakeX[0] = snakeX[0]+25;
                if(snakeX[0]>850){
                    snakeX[0]=25;
                }
            }else if(direction.equals("LEFT")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){
                    snakeX[0]=850;
                }
            }else if(direction.equals("UP")){
                snakeY[0] = snakeY[0] - 25;
                if(snakeY[0] < 75){
                    snakeY[0] = 650;
                }
            }else if(direction.equals("DOWN")){
                snakeY[0] = snakeY[0] +25;
                if(snakeY[0] > 650){
                    snakeY[0] = 75;
                }
            }

            if(foodX == snakeX[0] && foodY == snakeY[0]){
                length++;
                foodX= 25+25*random.nextInt(34);
                foodY = 75+25*random.nextInt(24);
                score=score+10;
            }
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i] && snakeY[0] == snakeY[i]){
                    fail=true;
                }
            }
            repaint();
        }
        timer.start();
    }
}
