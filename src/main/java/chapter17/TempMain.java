package chapter17;

import java.util.concurrent.Flow.Publisher;

public class TempMain {
    public static void main(String[] args) {
        getTemperaturesBasic("Basic New York").subscribe(new TempSubscriber());
        getTemperaturesExecutor("Executor New York").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperaturesBasic(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempBasicSubscription(subscriber, town)
        );
    }

    private static Publisher<TempInfo> getTemperaturesExecutor(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempExecutorSubscription(subscriber, town)
        );
    }
}
