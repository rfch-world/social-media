package world.rfch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "message")
@NoArgsConstructor
public class Message extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User senderUser;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiverUser;

    @Lob
    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;
}
