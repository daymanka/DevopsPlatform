package com.devops.platform;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.devops.platform.controllers.UserController;
import com.devops.platform.services.UserService;
import com.devops.platform.dtos.UserDto;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    void shouldReturnUsers() throws Exception {
        UserDto dto = new UserDto();
        dto.username = "test";
        dto.email = "test@mail.com";

        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].username").value("test"));

    }
    
}
