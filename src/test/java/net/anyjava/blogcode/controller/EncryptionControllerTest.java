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
class EncryptionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @DisplayName("암호화 API 테스트")
    @Test()
    void encrypt() throws Exception {
        mockMvc.perform(get("/encrypt?password=1234"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"password\":\"w9oKTqKTtvBuRUVbhQP/qw==\"}"))
                .andDo(print());
    }

    @DisplayName("복호화 API 테스트")
    @Test()
    void decrypt() throws Exception {
        mockMvc.perform(get("/decrypt?password=w9oKTqKTtvBuRUVbhQP/qw=="))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"password\":\"1234\"}"))
                .andDo(print());
    }
}
