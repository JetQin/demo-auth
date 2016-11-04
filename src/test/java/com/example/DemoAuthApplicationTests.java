package com.example;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import io.github.jetqin.domain.Presult;
import io.github.jetqin.repository.ResultRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class DemoAuthApplicationTests
{

  @Autowired
  private WebApplicationContext context;

  private MockMvc               mvc;

  @Autowired
  ResultRepository              resultRepo;

  @Before
  public void setup ( )
  {
    mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
  }

  @Test
  public void testGetResult ( )
  {
//    Presult result = resultRepo.findLoadResult();
//    Assert.assertNotNull(result);
//    Assert.assertEquals(0, result.getLoadCount());
//    Assert.assertEquals(0, result.getFailedCount());
//    Assert.assertEquals(0, result.getNewCount());
  }

  @Test
  public void testGetGreeting ( )
  {
    try
    {
      mvc.perform(get("/").with(httpBasic("user", "password")));
      // mvc.perform(get("/admin").with(user("admin").password("admin").roles("USER","ADMIN")));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
