package world.rfch.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name = "message")
public class MessageEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiverUser;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;
}
