package concretes;

import abstracts.ObserverInterface;
import abstracts.SubjectInterface;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements SubjectInterface {

    private List<ObserverInterface> units = new ArrayList<>();

    @Override
    public void attach(ObserverInterface unit) {
        units.add(unit);
    }

    @Override
    public void detach(ObserverInterface unit) {
        units.remove(unit);
    }

    @Override
    public void notify(String message) {
        for(ObserverInterface unit : units) {
            unit.update(message);
        }
    }
}
