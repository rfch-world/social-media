package world.rfch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "post")
public class Post extends BaseEntity {
    private UserEntity user;
}
