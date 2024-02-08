package users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String city;
    private String country;

    @Column(unique = true)
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
