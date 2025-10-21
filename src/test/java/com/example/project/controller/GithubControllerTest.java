package com.example.project.controller;

import com.example.project.dto.GithubResponseDto;
import com.example.project.service.GithubService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GithubControllerTest {
    @MockitoBean
    private GithubService githubService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGithubResponseDtoWhenDataCorrect() throws Exception {
        String owner = "owner";
        String repository = "repository-name";
        GithubResponseDto githubResponseDto = GithubResponseDto.builder()
                .fullName("owner/repository-name")
                .description("repositoryDescription")
                .cloneUrl("https://github.com/owner/repository-name.git")
                .stars(100)
                .createdAt(LocalDateTime.of(2025, 9, 9, 12, 15))
                .build();

        when(githubService.fetchRepositoryDetails(owner, repository)).thenReturn(githubResponseDto);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/repositories/owner/repository-name")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.fullName").value("owner/repository-name"),
                        jsonPath("$.description").value("repositoryDescription"),
                        jsonPath("$.cloneUrl").value("https://github.com/owner/repository-name.git"),
                        jsonPath("$.stars").value(100),
                        jsonPath("$.createdAt").value("2025-09-09T12:15:00")
                );
    }
}
