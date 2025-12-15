package creationClass;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FluxTest {

    public static void main(String [] args) {
        final List<String> basket1 = Arrays.asList(new String[]{"kiwi", "orange", "lemon", "orange", "lemon", "kiwi"});
        final List<String> basket2 = Arrays.asList(new String[]{"banana", "lemon", "lemon", "kiwi"});
        final List<String> basket3 = Arrays.asList(new String[]{"strawberry", "orange", "lemon", "grape", "strawberry"});
        final List<List<String>> baskets = Arrays.asList(basket1, basket2, basket3);
        final Flux <List<String>> basketFlux = Flux.fromIterable(baskets);// 제공된 순환자에 포함된 아이템을 전송하는 flux를 만든다.

        //cancatMap: Flux에 의해 비동기적으로 Publisher로 전송된 요소들을 변환시켜 내부 publisher들은 한 개의 FLux로 만든다.(순서 보장)
        basketFlux.concatMap(basket ->{
            final Mono<List<String>> distinctFruits = Flux.fromIterable(basket).distinct().collectList();
          return null;
        });
    }


}
