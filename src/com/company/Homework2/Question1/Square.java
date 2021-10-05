package com.company.Homework2.Question1;

public class Square extends Shape{
    int side;
    public Square(String name, String color, Integer side) {
        super(name, color);
        this.side = side;
    }

    public Square(int side) {
        super();
        this.side = side;
    }




    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public int getArea() {
        return side*side;
    }

    public int getPerimeter() {
        return side*4;
    }

    public String printShape(){
        return "The " + name + " has a " + color + " color.";
    }
}
