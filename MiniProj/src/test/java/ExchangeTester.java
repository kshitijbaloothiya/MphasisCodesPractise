import com.mphasis.cui.Exchange;
import com.mphasis.cui.Order;
import com.mphasis.cui.OrderType;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ExchangeTester {


//    public Exchange getExchange() {
//        return exchange;
//    }
//

    @Test
    public void testAddOrder(){

        Exchange exchange = new Exchange();
        ConcurrentMap<Double, PriorityQueue<Order>>orderBook = new ConcurrentHashMap<>();
        //orderBook = new ConcurrentHashMap<Double, PriorityQueue<Order>>();
        OrderType orderType = OrderType.BUY;
        Order order = new Order("1", orderType,1,50.0);
        exchange.addOrder(order);

 }


}
