package ch.zhaw.prog2.printer;

public class PrinterB {

    // test program
    public static void main(String[] arg) {
        PrinterRunnable a = new PrinterRunnable("PrinterA", '.', 10);
        Runnable b = new PrinterRunnable("PrinterB", '*', 20);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }


    private static class PrinterRunnable implements Runnable{
        private String name;
        char symbol;
        int sleepTime;

        public PrinterRunnable(String name, char symbol, int sleepTime) {
            this.name = name;
            this.symbol = symbol;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " run started...");
            for (int i = 1; i < 100; i++) {
                System.out.print(symbol);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println('\n' + threadName + " run ended.");
        }
    }
}
