/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicore;

import static java.lang.Thread.sleep;
import java.time.Duration;
import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;

/**
 *
 * @author Mahmoud
 */
public class MultiCore {

    public static double avg = 0.0;

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processor cores is " + cores);
        Instant now = Instant.now(); // Start clock at now

        //ExecutorService threadPool = Executors.newWorkStealingPool();
        //List<Future<Double>> futures = new ArrayList<Future<Double>>(cores);
        for (int i = 0; i < cores; i++) {
            //futures.add(i, threadPool.submit(new Worker(i))); // non-blocking
            Worker w = new Worker(i);
            Thread thread = new Thread(w);
            thread.start();
        }

        sleep(1500);//enough time for the last thread to be finished.

        System.out.println("Total average is: " + avg / cores);
        Duration d = Duration.between(now, Instant.now());
        System.out.println("Time Taken: " + d); // Total time taken
    }
}
