/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicore;

/**
 *
 * @author Mahmoud
 */
public class WorkerTask {
    
    Double total = 0.0; // sum of every number given to the task
    Integer count = 0; // count of every number given
// Simple average function

    public Double average() {
        return count > 0 ? total / (double) count : 0;
    }
// Adds a number from the list

    public void accept(Double i) {
        total += i;
        count++;
    }
// Will combine with another of itself

    public void combine(WorkerTask other) {
        System.out.println("Combine Called");
        total += other.total;
        count += other.count;
    }
}
