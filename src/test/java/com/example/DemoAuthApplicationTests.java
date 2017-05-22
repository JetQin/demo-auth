package com.example;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.github.jetqin.repository.ResultRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
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
//      mvc.perform(get("/").with(httpBasic("user", "user")));
      // mvc.perform(get("/admin").with(user("admin").password("admin").roles("USER","ADMIN")));
      mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
