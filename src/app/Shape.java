package app;

import java.util.ArrayList;

public class Shape {
    //Store points forming the shape
    ArrayList<Point> points = new ArrayList<>();

    //Adding a point to the list
    public void addPoint(Point point) {
        points.add(point);
    }

    //Calculating the perimeter
    public double Perimeter() {
        double P = 0;
        int size = points.size();

        //Calculating the distance to the next point
        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size);

            P += currentPoint.distanceTo(nextPoint);
        }

        return P;
    }

    //Average side length
    public double AverageSide() {
        int size = points.size();
        if (size == 0) {
            return 0;
        }

        return Perimeter() / size;
    }

    //The longest side
    public double LongestSide() {
        double longestSide = 0;

        //Finding the length of the current side
        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            double currentSide = currentPoint.distanceTo(nextPoint);
            if (currentSide > longestSide) {
                longestSide = currentSide;
            }
        }

        return longestSide;
    }


}
