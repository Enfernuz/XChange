package org.knowm.xchange.coindeal.service;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.coindeal.CoindealAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.marketdata.params.Params;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CoindealMarketDataService extends CoindealMarketDataServiceRaw
    implements MarketDataService {

  public CoindealMarketDataService(Exchange exchange) {
    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
    throw new NotImplementedException();
  }

  @Override
  public List<Ticker> getTickers(Params params) throws IOException {
    throw new NotImplementedException();
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
    return CoindealAdapters.adaptOrderBook(getCoindealOrderbook(currencyPair), currencyPair);
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {
    throw new NotImplementedException();
  }
}
