package org.knowm.xchange.binance;

import org.apache.commons.lang3.StringUtils;
import org.knowm.xchange.binance.dto.BinanceException;
import org.knowm.xchange.exceptions.CurrencyPairNotValidException;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.ExchangeSecurityException;
import org.knowm.xchange.exceptions.ExchangeUnavailableException;
import org.knowm.xchange.exceptions.NonceException;
import org.knowm.xchange.exceptions.RateLimitExceededException;

/** @author walec51 */
public final class BinanceErrorAdapter {

  private BinanceErrorAdapter() {}

  public static ExchangeException adapt(BinanceException e) {
    String message = e.getMessage();
    if (StringUtils.isEmpty(message)) {
      message = "Operation failed without any error message";
    }
    switch (e.getCode()) {
      case -1002:
        return new ExchangeSecurityException(message, e);
      case -1003:
        return new RateLimitExceededException(message, e);
      case -1016:
        return new ExchangeUnavailableException(message, e);
      case -1021:
        return new NonceException(message, e);
      case -1121:
        return new CurrencyPairNotValidException(message, e);
      case -1122:
        return new ExchangeSecurityException(message, e);
    }
    return new ExchangeException(message, e);
  }
}
