package name.sebastian.vogt;

/**
 * Created by sebastian on 20.10.16.
 */
public class Event {

    protected Object target = null;

    public Event(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return this.target;
    }
}
