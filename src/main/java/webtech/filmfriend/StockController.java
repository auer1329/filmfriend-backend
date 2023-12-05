package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    StockService service;
    @CrossOrigin
    @PostMapping("/api/stocks")
    public Stock createStock(@RequestBody Stock stock) {
        return service.save(stock);
    }
    @CrossOrigin
    @GetMapping("/api/stocks/{id}")
    public Stock getStock(@PathVariable String id) {
        Long stockId = Long.parseLong(id);
        return service.get(stockId);
    }
    @CrossOrigin
    @GetMapping("/api/stocks")
    public Iterable<Stock> getAllStocks() {
        return service.getAll();
    }
}
