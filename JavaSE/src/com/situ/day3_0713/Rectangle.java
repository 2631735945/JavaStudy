package com.situ.day3_0713;

public class Rectangle {
  private int heigth=1;
  private int width=1;

    public Rectangle() {
    }

    public Rectangle(int heigth) {
        this.heigth = heigth;
        this.width=heigth;
    }

    public Rectangle(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int area(){
        return this.heigth*this.width;
    }
    public int circumference(){
        return this.width*2+this.heigth*2;
    }
}
