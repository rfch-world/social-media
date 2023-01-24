package world.rfch.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_social_media")
@AllArgsConstructor
@NoArgsConstructor
public class SocialMediaEntity extends BaseEntity {

    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "url")
    private String url;
}
