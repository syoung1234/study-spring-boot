package com.rubypaper;

// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// Controller만 메모리에 올림
// @WebMvcTest


// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

// 아래 두 개는 Controller 뿐만 아니라 Service, Repository도 메모리에 올림
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    // @Autowired
    // private TestRestTemplate restTemplate;

    @Test
    public void testHello() throws Exception {
        when(boardService.hello("둘리")).thenReturn("Hello : 둘리");

        mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "둘리"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Hello : 둘리"))
        .andDo(MockMvcResultHandlers.print());

        // String result = restTemplate.getForObject("/hello?name=둘리", String.class);
        // assertEquals("Hello : 둘리", result);
    }

    // @Test
    // public void testGetBoard() throws Exception {
    //     BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
    //     assertEquals("테스터", board.getWriter());
    // }
    
}
