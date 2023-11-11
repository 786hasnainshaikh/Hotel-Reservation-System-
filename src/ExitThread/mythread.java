package ExitThread;

public class mythread extends Thread{

    @Override
    public void run() {
        System.out.println();
        System.out.print("Exiting System");

        for (int i = 0; i <=6; i++) {
            System.out.print(".");
            // after printing "." this thread will sleep or stop for 0.4 second
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println("Thank you for using Reservation System");
        System.exit(0);
    }
}
