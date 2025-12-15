package subspubs;

import java.util.Map;

public class PubSubExample {

        public static void main(String[] args){
            PubSub pubSub = new PubSub();
            Subscriber userAddedSubscriber = new UserAddedSubscriber();

            pubSub.subscribe("userAdded", userAddedSubscriber);
            pubSub.publish("userAdded", Map.of("name", "David"));

        }


}
