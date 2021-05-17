package abstracts;

public interface SubjectInterface {
    void attach(ObserverInterface observerInterface);

    void detach(ObserverInterface observerInterface);

    void notify(String message);
}
