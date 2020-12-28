import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class Listener implements Watcher, AsyncCallback.StatCallback {
    ZooKeeper zk = null;
    public Listener(ZooKeeper zk) {
        this.zk = zk;
        System.out.println("start");
        zk.exists("/zk_test", true, this, null);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("listen 에서의 process");
        zk.exists("/zk_test", true, this, null);
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        System.out.println("listen 에서의 processResult");
    }
}
