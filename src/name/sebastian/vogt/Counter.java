package name.sebastian.vogt;

/**
 * Created by sebastian on 20.10.16.
 */
public class Counter {

    protected int count;
    protected int max;
    protected int steps;

    protected IOnFinishListener onFinsishListener = null;
    protected IOnStartListener onStartListener = null;
    protected IOnUpdateListener onUpdateListener = null;


    public void setOnFinishListener(IOnFinishListener listener) {
        this.onFinsishListener = listener;
    }

    public void setOnUpdateListener(IOnUpdateListener listener) {
        this.onUpdateListener = listener;
    }

    public void setOnStartListener(IOnStartListener listener) {
        this.onStartListener = listener;
    }

    public Counter(int max, int steps) {
        this.max = max;
        this.steps = steps;
    }

    public int getCount() {
        return this.count;
    }




    public void start() {
        if(this.onStartListener != null) {
            this.onStartListener.onStart(new Event(this));
        }
        for(this.count = 0; this.count <= this.max; this.count += this.steps) {
            if(this.onUpdateListener != null) {
                this.onUpdateListener.onUpdate(new Event(this));
            }
        }
        if(this.onFinsishListener != null) {
            this.onFinsishListener.onFinish(new Event(this));
        }
    }

    public void reset(int max, int steps) {
        this.max = max;
        this.steps = steps;
    }
}
