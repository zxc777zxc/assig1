import app.Point;
import app.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    //Link to source file
        File file = new File("D:\\java\\assig1\\src\\source");

        Scanner sc = new Scanner(file);

        //Shape for points
        Shape shape = new Shape();

        //Variables for the first and previous points
        Point firstPoint = null;
        Point previousPoint = null;

        //Reading points from the file
        while (sc.hasNext()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            //Creating a Point with the coordinates
            Point point = new Point(x, y);

            //Adding the point to the Shape
            shape.addPoint(point);

            //Distance between points
            if (previousPoint != null) {
                double distance = previousPoint.distanceTo(point);
                System.out.println("Distance between points" + previousPoint + " and " + point + " is " + distance);
            } else {
                firstPoint = point;
            }

            //Updating the previous point to the current point
            previousPoint = point;
        }

        //Printing the distance between the last and first points
        if (previousPoint != null && firstPoint != null) {
            double distance = previousPoint.distanceTo(firstPoint);
            System.out.println("Distance between points" + previousPoint + " and " + firstPoint + " is " + distance);
        }

        //Output perimeter,Avarage and Longest sides
        System.out.println("Perimeter: " + shape.Perimeter());
        System.out.println("Average side: " + shape.AverageSide());
        System.out.println("Longest side: " + shape.LongestSide());

    }
}
