package pl.wsb.fitnesstracker.achievement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;
import java.time.LocalDateTime; // Zmienione z LocalDate

@Entity
@Table(name = "achievement") // Poprawione: liczba pojedyncza
@Getter
@Setter
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "earned_at", nullable = false) // Poprawione: nazwa kolumny dla testu
    private LocalDateTime earnedAt; // Zmienione na LocalDateTime zgodnie z LAB03-2

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Dodane: nullable = false
    private User user;

    public Achievement(String name, String description, LocalDateTime earnedAt, User user) {
        this.name = name;
        this.description = description;
        this.earnedAt = earnedAt;
        this.user = user;
    }
}