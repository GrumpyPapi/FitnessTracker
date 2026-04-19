package pl.wsb.fitnesstracker.achievement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;
import java.time.LocalDate;

@Entity
@Table(name = "achievements")
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

    @Column(name = "date_earned", nullable = false)
    private LocalDate dateEarned;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Achievement(String name, String description, LocalDate dateEarned, User user) {
        this.name = name;
        this.description = description;
        this.dateEarned = dateEarned;
        this.user = user;
    }
}