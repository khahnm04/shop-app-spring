package com.projects.shopapp.models;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", length = 255)
    private String token;

    @Column(name = "token_type", length = 50)
    private String tokenType;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private boolean revoke; // token đã bị hủy chưa

    private boolean expired; // token đã hết hạn chưa

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
