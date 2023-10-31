public class Main {
    public static void main(String[] args) {
        Conflict conflict1 = new Conflict("Конфлікт 1");
        Conflict conflict2 = new Conflict("Конфлікт 2");

        Thread thread1 = new Thread(() -> {
            try {
                conflict1.bow(conflict2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                conflict2.bow(conflict1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}