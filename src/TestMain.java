import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        Eventer e = new Eventer();
        Thread t = new Thread(e);
        t.start();
    }

}


