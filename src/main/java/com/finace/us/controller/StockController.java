package com.finace.us.controller;


import com.finace.us.domain.StockData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/spy")
    public ResponseEntity<List<Stock>> getStockData() throws IOException {

        Calendar from = Calendar.getInstance();
        from.set(2022, 4, 1);
        Calendar to = Calendar.getInstance();
        to.set(2022, 4, 15);
        List<Stock> stockList = new ArrayList<>();

        Stock stock = YahooFinance.get("^GSPC",from,to,Interval.DAILY);
        stockList.add(stock);
        if (stockList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stockList);
    }


}

