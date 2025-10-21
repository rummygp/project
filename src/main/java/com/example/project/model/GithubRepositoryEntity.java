package com.example.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "githubRepositories")
public class GithubRepositoryEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private LocalDateTime createdAt;

    public void update(GithubRepositoryEntity newData) {
        this.fullName = newData.fullName;
        this.description = newData.description;
        this.cloneUrl = newData.cloneUrl;
        this.stars = newData.stars;
    }
}
