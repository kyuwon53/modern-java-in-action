package chapter17;

import java.util.concurrent.Flow.Publisher;

public class TempMain {
    public static void main(String[] args) {
//        getTemperaturesBasic("Basic New York").subscribe(new TempSubscriber());
//        getTemperaturesExecutor("Executor New York").subscribe(new TempSubscriber());
        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
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

    public static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempExecutorSubscription(processor, town));
        };
    }
}
