package chapter17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

public class TempExecutorSubscription implements Subscription {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Flow.Subscriber<? super TempInfo> subscriber;
    private final String town;

    public TempExecutorSubscription(Flow.Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }


    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception exception) {
                    subscriber.onError(exception);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
