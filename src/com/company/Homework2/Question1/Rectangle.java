package com.company.Homework2.Question1;

public class Rectangle extends Shape{
    private Integer width;
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Rectangle (String name, String color, Integer width,  Integer height) {
        super(name, color);
        this.width = width;
        this.height = height;

    }
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(int line) {
        super();
        this.width = line;
        this.height = line;
    }

    public int getArea(){
        return width*height;
    }

    public int getPerimeter(){
        return (width+height)*2;
    }

    public String printShape(){
        return "The " + name + " has a " + color + " color.";
    }
}
