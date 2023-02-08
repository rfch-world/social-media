package world.rfch.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "message")
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
