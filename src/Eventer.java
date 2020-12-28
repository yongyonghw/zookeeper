import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class Eventer implements Watcher, Runnable {

//    Listener listener  = null;
    ZooKeeper zk;
    public Eventer() {
        try {
            zk = new ZooKeeper("localhost:2181", 3000, this);
//            listener = new Listener(z);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("eventer 에서의 process, listener를 실행한다.");
        zk.exists("/zk_test", true, null, null);
        try {
            byte [] b = zk.getData("/zk_test", true, null);
            System.out.println(new String(b));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        listener.process(watchedEvent);
    }

    @Override
    public void run() {
        while(true) {

//            try {
//               Thread.sleep(1000);
//            } catch (Exception e) {
////                e.printStackTrace();
//            }
        }
    }
}
