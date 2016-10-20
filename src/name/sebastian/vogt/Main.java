package name.sebastian.vogt;

public class Main implements IOnStartListener, IOnUpdateListener, IOnFinishListener{


    private Counter counter;
    private int loop;


    public Main() {
        this.loop = 0;
        this.counter = new Counter(10, 1);

        this.counter.setOnStartListener(this);
        this.counter.setOnUpdateListener(this);
        this.counter.setOnFinishListener(this);

        this.counter.start();
    }

    public void onStart(Event e) {
        System.out.println("onStart");
    }

    public void onUpdate(Event e) {
        Counter target = (Counter) e.getTarget();
        System.out.println("onUpdate count = " + target.getCount());
    }

    public void onFinish(Event e) {
        Counter target = (Counter) e.getTarget();
        this.loop ++;
        System.out.println("onFinish");
        if(this.loop <= 1) {
            target.reset(20, 2);
            target.start();
        }

    }




    public static void main(String[] args) {
	// write your code here

       new Main();





/*        Counter counter = new Counter(10, 1);

        counter.setOnStartListener(new IOnStartListener() {
            @Override
            public void onStart(Event e) {
                System.out.println("onStart");
            }
        });

        counter.setOnUpdateListener(new IOnUpdateListener() {
            @Override
            public void onUpdate(Event e) {
                Counter target = (Counter) e.getTarget();
                System.out.println("onUpdate count = " + target.getCount());
            }
        });

        counter.setOnFinishListener(new IOnFinishListener() {
            @Override
            public void onFinish(Event e) {
                System.out.println("onFinish");
            }
        });

        counter.start();*/
    }


}
