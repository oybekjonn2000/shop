package net.idrok.shopping.entity;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(nullable = false, length = 30)
    private String firstName;

    @Size(max = 30)
    @Column(length = 30)
    private String lastName;

    @Size(max = 30)
    @Column(length = 30)
    private String email;

    @NotNull
    @Size(min = 6, max = 30)
    @Column(nullable = false, length = 30, unique = true)
    private String login;

    @NotNull
    @Size(min = 60, max = 60)
    @Column(nullable = false, length = 60)
    private String password;
    private String phoneNumber;

    private LocalDateTime regTime;
    private LocalDateTime lastVisit;


    private Role role;
    private boolean active;

    @ManyToOne
    private  Fayl rasm;

}
