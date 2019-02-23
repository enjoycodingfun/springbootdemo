package com.enjoycodingfun.springbootdemo;

import com.enjoycodingfun.springbootdemo.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;
    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andDo(print());
        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")));
    }
}
