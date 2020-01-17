package reentrant_lock;

import synchronization.unsync.Unsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static synchronization.unsync.ConcurrentUtils.stop;

public class SyncImpl {

    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count = count + 1;
        } finally {
            lock.unlock();
        }
    }

    void execute(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));

        System.out.println(count);  // 10000

        stop(executor);
    }

    public static void main(String[] args) {
        new SyncImpl().execute();
    }

}
