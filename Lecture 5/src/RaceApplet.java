import java.applet.Applet;
import java.awt.*;

public class RaceApplet extends Applet implements Runnable {
    final static int NUMRUNNERS = 2;
    final static int SPACING = 20;

    Thread updateThread = null;

    Runner runner[] = new Runner[NUMRUNNERS];

    @Override
    public void run() {
        while (updateThread != null) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void init(){
        String raceType = getParameter(("type"));

        for(int i = 0; i < NUMRUNNERS; i++) {
            runner[i] = new Runner(i);

            if (raceType.compareTo("unfair") == 0){
                runner[i].setPriority( i + 1);
            } else {
                runner[i].setPriority(2);
            }
        }
        if (updateThread == null) {
            updateThread = new Thread(this, "Thread Race");
            updateThread.setPriority(NUMRUNNERS + 1);
        }
    }

    public boolean mouseDown(java.awt.Event evt, int x, int y) {
        if (!updateThread.isAlive()) {
            updateThread.start(); //NEW state
        }
        for(int i = 0; i < NUMRUNNERS; i++) {
            if(!runner[i].isAlive()) {
                runner[i].start(); //RUNNABLE state
            }
        }
        return true;
    }

    public void paint( Graphics g ) { g.setColor(Color.lightGray) ; g.fillRect(0, 0, size().width, size().height) ; g.setColor(Color.black) ;
        for ( int i = 0 ; i < NUMRUNNERS ; i++ ) { int pri = runner[i].getPriority() ;
            g.drawString( new Integer(pri).toString(), 0, (i+1)*SPACING ) ;
        }
        update(g) ;
    }

    public void update(Graphics g) {
        for (int i = 0 ; i < NUMRUNNERS ; i++) {
            g.drawLine( SPACING, (i+1)*SPACING, SPACING + ( runner[i].tick ) / 1000, (i+1) * SPACING ) ;
        }
    }

    // Applet’s stop method
    public void stop() {
        for (int i = 0 ; i < NUMRUNNERS ; i++) {
            if ( runner[i].isAlive() ) {
                runner[i].terminate = true;
                runner[i] = null;
            }
        }
        if ( updateThread.isAlive() ) {
            updateThread = null ;
        }
    }
}
