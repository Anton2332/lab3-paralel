public class Conflict {
    private final String name;
    private boolean bowing = true;
    public Conflict (String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public synchronized void bow(Conflict bower) throws InterruptedException {
        while (this.bowing) {
            bower.bowing = false;
            wait();
        }
        System.out.format("%s: %s пропускає мене!%n", this.name, bower.getName());

        if (this.bowing || bower.bowing ) {
            bower.bowBack(this);
        }
    }

    public synchronized void bowBack(Conflict bower) {
        System.out.format("%s: %s пропускає мене у відповідь!%n", this.name, bower.getName());
        this.bowing = false;
        notifyAll();
    }
 }