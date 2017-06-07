package io.github.jetqin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.jetqin.domain.Stock;
import io.github.jetqin.repository.StockRepository;

@Controller
public class StockController
{

  @Autowired
  StockRepository repository;

  @RequestMapping("/stock")
  @ResponseBody
  public Stock getStock (@RequestParam(name = "code", defaultValue = "600000") String code)
  {
    return repository.findByCode(code);
  }
  
  @RequestMapping("/listStock")
  @ResponseBody
  public List<Stock> getStockList ()
  {
    return repository.findAll();
  }
}
