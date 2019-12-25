package com.telekart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "usr")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    @JsonIgnore
    private LocalDateTime lastTimeOnline = LocalDateTime.now();

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.Online;

    public User(long id) {
        this.id = id;
    }

    @Builder
    private User(Long id, String name, String email, String phoneNumber,
                 LocalDateTime lastTimeOnlineStatusHasBeenSet, Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.lastTimeOnline = lastTimeOnlineStatusHasBeenSet;
        this.status = status;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Optional<LocalDateTime> getLastTimeOnline() {
        return Optional.ofNullable(lastTimeOnline);
    }

    public void setLastTimeOnline(LocalDateTime lastTimeOnlineStatus) {
        this.lastTimeOnline = lastTimeOnlineStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(lastTimeOnline, user.lastTimeOnline) &&
                status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, lastTimeOnline, status);
    }

    public enum Status {
        Away, Offline, Online
    }
}
