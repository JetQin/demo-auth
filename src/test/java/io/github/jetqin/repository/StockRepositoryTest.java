package io.github.jetqin.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import io.github.jetqin.config.PersistenceConfig;
import io.github.jetqin.domain.Stock;
import io.github.jetqin.domain.StockCurrent;
import io.github.jetqin.domain.StockHistory;
import io.github.jetqin.domain.StockHistoryID;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class StockRepositoryTest
{

  @Autowired
  StockRepository repository;
  
  @Autowired
  StockCurrentRepository currentRepository;
  
  @Autowired
  StockHistoryRepository historyRepository;

  @Test
  public void testGetStock ( )
  {
    Stock stock = repository.findByCode("600000");
    assertEquals("Find", "600000", stock.getCode());
  }
  
  @Test
  public void testGetStockCurrent ( )
  {
    StockCurrent stockCurrent = currentRepository.findByCode("600000");
    assertEquals("Find", "600000", stockCurrent.getCode());
  }
  
  @Test
  public void testGetStockHistory ( )
  {
    StockHistoryID id = new StockHistoryID("2015-01-05","000795");
    StockHistory stockHistory = historyRepository.findByCode(id);
    assertEquals("Find", id.getCode(), stockHistory.getCode());
  }

}
