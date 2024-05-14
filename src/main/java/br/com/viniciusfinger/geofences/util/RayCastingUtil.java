package br.com.viniciusfinger.geofences.util;

import java.awt.geom.Point2D;
import java.util.List;

/*
 * Java implementation of the ray casting algorithm
 */
public class RayCastingUtil {

    private RayCastingUtil(){}

    public static boolean isPointInsidePolygon(Point2D.Double point, List<Point2D.Double> polygon) {
        int intersections = 0;
        int numVertices = polygon.size();

        for (int i = 0; i < numVertices; i++) {
            Point2D.Double vertex1 = polygon.get(i);
            Point2D.Double vertex2 = polygon.get((i + 1) % numVertices);

            if (rayIntersectsSegment(point, vertex1, vertex2)) {
                intersections++;
            }
        }

        // Inside if the number of intersections is odd
        return intersections % 2 == 1;
    }

    private static boolean rayIntersectsSegment(Point2D.Double point, Point2D.Double vertex1, Point2D.Double vertex2) {
        double x = point.getX();
        double y = point.getY();

        double vertex1x = vertex1.getX();
        double vertex1y = vertex1.getY();

        double vertex2x = vertex2.getX();
        double vertex2y = vertex2.getY();

        // Check if the point is within the y-bounds of the segment
        if ((vertex1y <= y && y < vertex2y) || (vertex2y <= y && y < vertex1y)) {
            
            // Calculate the x-coordinate of the intersection point
            double xIntersection = (y - vertex1y) / (vertex2y - vertex1y) * (vertex2x - vertex1x) + vertex1x;

            // Count the intersection if the x-coordinate is greater than the test point's x-coordinate
            if (x < xIntersection) {
                return true;
            }
        }

        return false;
    }
}