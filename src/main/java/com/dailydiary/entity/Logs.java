package com.dailydiary.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String category;
    @Column(name = "private")
    private Boolean isPrivate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    public LocalDateTime getCreated() {
        return created;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long userId() {
        return user.getId();
    }


    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logs logs = (Logs) o;
        return Objects.equals(id, logs.id) &&
                Objects.equals(content, logs.content) &&
                Objects.equals(category, logs.category) &&
                Objects.equals(isPrivate, logs.isPrivate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, category, isPrivate);
    }

    public Logs() {
    }


}
