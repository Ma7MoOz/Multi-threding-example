/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicore;

import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.Callable;

/**
 *
 * @author Mahmoud
 */
public class Worker implements Runnable {

    private double avg;
    Integer workerId;
    Integer workSize = 2 << 22;
    List<Double> workList;

    // Constructor
    Worker(Integer id) {
        this.workerId = id;
        workList = new ArrayList<>();
        for (int i = 0; i < workSize; i++) {
            workList.add(i, Math.random());
        }
    }

    Worker() {
    }

//    public Double call() throws Exception {
//        Double avg = 0.0;
//        WorkerTask collect = workList
//                .stream()
//                .collect(WorkerTask::new
//                        , WorkerTask::accept
//                        , WorkerTask::combine);
//        avg = collect.average();
//        System.out.println(String
//                .format("Worker %d done with average %f on %d numbers"
//                        , workerId
//                        , avg
//                        , collect.count));
//        return avg;
//    }
    
    @Override
    public void run() {
        WorkerTask collect = workList
                .stream()
                .collect(WorkerTask::new, 
                        WorkerTask::accept, 
                        WorkerTask::combine);
        avg = collect.average();
        System.out.println(String
                .format("Worker %d done with average %f on %d numbers"
                , workerId
                , avg
                , collect.count));
        MultiCore.avg += avg;
    }
}
