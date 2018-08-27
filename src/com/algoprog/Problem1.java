package com.algoprog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem1 {
    private Point destination;
    private ArrayList<Point> stations;

    public Problem1() {
        stations = new ArrayList<>();
    }

    public void setDestination(Point dest) {
        destination = dest;
    }

    public void add_station(Point station) {
        stations.add(station);
    }

    private void read_input(String input_file) {
        if (input_file.equals("")) return;

        try (BufferedReader br = new BufferedReader(new FileReader(input_file))) {
            // read the destination coordinates

            String line = br.readLine();
            String[] coords = line.split(" ");
            Point dest = new Point(coords[0], coords[1], coords[2]);
            setDestination(dest);
            stations.add(dest);

            br.readLine();

            // read the stations coordinates

            while ((line = br.readLine()) != null) {
                coords = line.split(" ");
                Point p = new Point(coords[0], coords[1], coords[2]);
                add_station(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double solve(String input_file) {
        read_input(input_file);

        double max_distance = 0;

        Point current_point = new Point(0, 0, 0); // start from earth

        while (current_point != destination) {

            // teleport to the station with the minimum distance

            double min_distance = Double.MAX_VALUE;
            Point next_point = current_point;
            for (Point p : stations) {
                double distance = current_point.distance(p);
                if (distance < min_distance) {
                    min_distance = distance;
                    next_point = p;
                }
            }

            if(min_distance > max_distance) {
                max_distance = min_distance;
            }

            stations.remove(next_point);

            current_point = next_point;
        }

        System.out.println("Max teleport distance: " + max_distance);

        return max_distance;
    }

    public static void main(String[] args) {
	    Problem1 p = new Problem1();
	    p.solve("input");
    }
}
