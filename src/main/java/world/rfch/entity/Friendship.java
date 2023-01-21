package world.rfch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friendship")
@Data
public class Friendship extends BaseEntity {
    private Long user_id;
    private Long friend_id;
}
