/*
 * Create a tread by implement the Runnable interface
 */
package Basic.Thread;


/**
 *
 * @author Wu
 */
public class TreadBasic implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while(true){
            System.out.println(i++);
            synchronized(this){
                try {
                    this.wait(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        TreadBasic tb = new TreadBasic();
        tb.run();
    }
    
}
