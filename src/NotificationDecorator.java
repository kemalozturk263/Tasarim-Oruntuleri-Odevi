public abstract class NotificationDecorator implements Notification {
    protected Notification wrappee;

    public NotificationDecorator(Notification wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message, String recipient) {
        wrappee.send(message, recipient);
    }
}
