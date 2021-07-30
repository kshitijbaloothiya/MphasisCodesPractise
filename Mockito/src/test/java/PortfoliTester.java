
import com.mphasis.main.se.Portfolio;
import com.mphasis.main.se.Stock;
import com.mphasis.main.se.StockService;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PortfoliTester {
    Portfolio portfolio;
    StockService stockService;
    public void setUp(){
        portfolio = new Portfolio();
        stockService = Mockito.mock(StockService.class);
        portfolio.setStockService(stockService);
    }
    public boolean testMarketValue(){
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1","google",10);
        Stock microsoft = new Stock("2","microsoft",10);

        stocks.add(googleStock);
        stocks.add(microsoft);
        portfolio.setStocks(stocks);

        Mockito.when(stockService.getPrice(googleStock)).thenReturn(10.0);
        Mockito.when(stockService.getPrice(microsoft)).thenReturn(10.0);

        double marketValue = portfolio.getMarketValue();

        return marketValue == 200;




    }

    public static void main(String[] args) {
        PortfoliTester portfoliTester = new PortfoliTester();
        portfoliTester.setUp();
        boolean test = portfoliTester.testMarketValue();
        System.out.println(test);

    }

}
