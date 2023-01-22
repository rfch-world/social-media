package world.rfch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = "marital_status")
public class Marital_Status extends BaseEntity {

    @OneToOne(mappedBy = "user")
    private UserEntity id;
    private char status;
}
