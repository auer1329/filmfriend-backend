package webtech.filmfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    StockRepository repo;

    public Stock save(Stock stock) {
        return repo.save(stock);
    }

    public Stock get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
    }
}
