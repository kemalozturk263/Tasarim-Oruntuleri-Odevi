import java.util.ArrayList;
import java.util.List;

public class SystemPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private MessageFormatStrategy formatStrategy;

    public SystemPublisher(MessageFormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    public void setFormatStrategy(MessageFormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String event, String message) {
        String formattedMessage = formatStrategy.format(message);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(event, formattedMessage);
        }
    }
}
