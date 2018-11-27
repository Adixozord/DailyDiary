package com.dailydiary.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String category;
    @Column(name= "private")
    private Boolean isPrivate;

    @JoinColumn(name = "user_id")
    @OneToMany
    User user;

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
