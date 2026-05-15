public class UserSubscriber implements Subscriber {
    private String username;
    private String email;
    private NotificationFacade facade;

    public UserSubscriber(String username, String email, NotificationFacade facade) {
        this.username = username;
        this.email = email;
        this.facade = facade;
    }

    @Override
    public void update(String event, String message) {
        System.out.println("Kullanıcı " + username + " için '" + event + "' olayı tetiklendi.");
        facade.sendStandardEmail(message, email);
    }
}
