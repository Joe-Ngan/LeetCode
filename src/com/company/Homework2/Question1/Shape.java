package com.company.Homework2.Question1;

public class Shape {
    String name;
    String color;
    Integer perimeter;
    Integer area;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public void setPerimeter(Integer perimeter) {
        this.perimeter = perimeter;
    }

    public Shape() {

    }

    public Shape(String name, String color, Integer perimeter, Integer area) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.area = area;
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String printShape(){
        return "The " + name + " has a " + color + " color.";
    }

    public int getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }
}
