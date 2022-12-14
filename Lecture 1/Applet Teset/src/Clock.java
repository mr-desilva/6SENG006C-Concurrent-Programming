import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;

public class Clock extends Applet implements Runnable {
    private Thread clockThread = null;

    public void start() // Applet’s "start()" method
    {
        if (clockThread == null) {
            clockThread = new Thread(this, "Clock");
            clockThread.start(); // Thread’s "start()" method
        }
    }

    // implementing ‘‘run’’ makes Clock a ‘‘runnable target’’
    public void run()
    {
        while ( clockThread != null ) {
            repaint();
            try {
                clockThread.sleep( 1000 ) ;
            } catch (InterruptedException e){ }
        }
    }
    public void paint(Graphics g){
        Calendar now = Calendar.getInstance();
        g.drawString( now.get( Calendar.HOUR_OF_DAY ) + ":" +
                now.get( Calendar.MINUTE ) + ":" +
                now.get( Calendar.SECOND ), 5, 10 ) ;
    }
    public void stop(){ // Applet’s "stop" method
        clockThread = null ;
    }
}
