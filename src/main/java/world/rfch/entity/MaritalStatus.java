package world.rfch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "marital_status")
public class MaritalStatus extends BaseEntity {

    @OneToMany(mappedBy = "user")
    private List<User> user;
    private String status;
}
