package synchronization.unsync;

import synchronization.SyncExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static synchronization.unsync.ConcurrentUtils.*;

public class Unsync {

    int count = 0;

    synchronized void increment() {
        count = count + 1;
    }

    void execute(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));

        System.out.println(count);

        //stop(executor);
    }

    public static void main(String[] args) {
        new Unsync().execute();
    }

}
