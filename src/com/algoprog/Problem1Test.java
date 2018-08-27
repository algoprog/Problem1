package com.algoprog;

import static junit.framework.TestCase.assertTrue;

class Problem1Test {
    @org.junit.jupiter.api.Test
    void solve() {
        Problem1 p = new Problem1();
        Point dest = new Point(2, 2, 2);
        p.setDestination(dest);
        p.add_station(dest);
        p.add_station(new Point(1, 1, 1));
        p.add_station(new Point(1, 2, 2));
        p.add_station(new Point(2, 2, 1));
        double result = p.solve("");

        assertTrue((result-1.73) < 0.01);
    }
}