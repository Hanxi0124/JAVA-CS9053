package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:31 AM
 */
public class PhilosopherFactory {

    public static Philosopher construct(final String name) {
        return new SolutionDijkstra(name);
    }

    public static Philosopher constructWithWaiter(final Waiter waiter, final String name) {
    	return new SolutionWaiter(waiter,name);
    }

    public static Waiter constructWaiter() {
        return new Waiter() ;
    }

}
