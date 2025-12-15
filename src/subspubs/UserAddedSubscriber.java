package subspubs;

import org.reactivestreams.Subscription;

import java.util.Map;

public class UserAddedSubscriber implements Subscriber{
    @Override
    public void update(String event, Object data) {
        System.out.println("User added: " + ((Map)data).get("name"));
    }

}
