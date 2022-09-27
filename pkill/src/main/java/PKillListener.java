import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/5/19       create this file
 * </pre>
 */
public class PKillListener implements SignalHandler {


    public static void main(String[] args) throws InterruptedException {


        PKillListener tsh = new PKillListener();

        Signal.handle(new Signal("TERM"), tsh);  // kill -15 common kill

        Signal.handle(new Signal("INT"), tsh);   // Ctrl+c

//Signal.handle(new Signal("KILL"), tsh);  // kill -9  no Support

//Signal.handle(new Signal("USR1"), tsh);   // kill -10

//Signal.handle(new Signal("USR2"), tsh);   // kill -12

        for (; ; ) {
            Thread.sleep(3000);
            System.out.println("running ......");
        }
    }


    private void signalCallBack(Signal sn) {
        System.out.println(sn.getName() + " is recevied.");
    }

    @Override
    public void handle(Signal sn) {
        signalCallBack(sn);
    }

}
