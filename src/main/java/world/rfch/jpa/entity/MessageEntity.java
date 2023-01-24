package world.rfch.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "message")
@NoArgsConstructor
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
