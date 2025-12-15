package subspubs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubSub {

    /**
     * Subscriber:
     * */
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();


    /**
     *
     * */
    public void subscribe(String event, Subscriber subscriber){
        subscribers.computeIfAbsent(event, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(String event, Subscriber subscriber){
        List<Subscriber> subs = subscribers.get(event);
        if(subs != null) subs.remove(subscriber);
    }

    public void publish(String event, Object data){
        List<Subscriber> subs = subscribers.get(event);
        if(subs != null) {
            for(Subscriber subscriber : subs) subscriber.update(event, data);
        }
    }


}