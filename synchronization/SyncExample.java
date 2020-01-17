package synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static synchronization.unsync.ConcurrentUtils.stop;

public class SyncExample {

    int count = 0;

    void increment() {
        count = count + 1;
    }

    void execute(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));

        System.out.println(count);  // 9965

        stop(executor);

    }

    public static void main(String[] args) {
        new SyncExample().execute();
    }
}
