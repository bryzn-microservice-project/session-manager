package com.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[MAIN_CONTROLLER] Test Endpoints")
    public void testGetPost(TestInfo testInfo) throws Exception {
        System.out.println("\n-----------Running: " + testInfo.getDisplayName() + "-----------");
        // GET USER
        mockMvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("NO-USER"));

        // POST LOGIN
        mockMvc.perform(post("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("DUMMY"))  // JSON string for request body
                .andExpect(status().isOk());

        // GET USER
        mockMvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("DUMMY"));

        // POST LOGOUT
        mockMvc.perform(post("/api/v1/logout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))  // JSON string for request body
                .andExpect(status().isOk());

        // GET USER
        mockMvc.perform(get("/api/v1/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("NO-USER"));
    }
}
