package world.rfch.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "friendship")
public class Friendship extends BaseEntity {
    @ManyToMany
    @JoinTable(name = "user_id")
    private UserEntity user;
    @ManyToMany
    @JoinTable(name = "friend_id")
    private UserEntity friend;
}
