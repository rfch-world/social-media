package world.rfch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "social_media")
public class SocialMedia extends BaseEntity {
    private Long user_id;
    private String url;
}
