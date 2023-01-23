package world.rfch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "social_media")
@AllArgsConstructor
@NoArgsConstructor
public class SocialMedia extends BaseEntity {

    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "url")
    private String url;
}
