package net.anyjava.blogcode.controller;

import net.anyjava.blogcode.BlogCodeApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackageClasses = BlogCodeApplication.class)
@WebMvcTest
class LocalDateControllerTest {
    @Autowired
    MockMvc mockMvc;

    @DisplayName("LocalDate 파라미터를 받는 API 테스트 - default format")
    @Test
    void assetLocalDateGetAPIDefault() throws Exception {
        // given
        String url = "/localdate-default?createdAt=2020-01-01";

        // when
        // then
        var res = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string("\"2020-01-01\""))
                .andDo(print());
    }

    @DisplayName("LocalDate 파라미터를 받는 API 테스트 - custom format")
    @Test
    void assetLocalDateGetAPI() throws Exception {
        // given
        String url = "/localdate?createdAt=2020.01.01";

        // when
        // then
        var res = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string("\"2020-01-01\""))
                .andDo(print());
    }

    @DisplayName("LocalDate 파라미터를 받는 API 테스트 - 400 에러")
    @Test
    void assetLocalDateGetAPIFailed() throws Exception {
        // given
        String url = "/localdate?createdAt=20209999";

        // when
        // then
        var res = mockMvc.perform(get(url))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }
}
