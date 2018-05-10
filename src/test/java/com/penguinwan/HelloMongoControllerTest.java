package com.penguinwan;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloMongoControllerTest {
    private MockMvc mockMvc;

    private BookRepository mockBookRepository;

    private HelloMongoController controller;

    @Before
    public void setup() {
        mockBookRepository = mock(BookRepository.class);
        controller = new HelloMongoController();
        controller.bookRepository = mockBookRepository;

    }

    @Test
    public void shouldReturn200WhenPost() throws Exception {
        when(mockBookRepository.save(any(Book.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(post("/book/susi").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().is2xxSuccessful()).
                andExpect(jsonPath("$.title").value("susi"));
    }


}
