package world.rfch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "friend_request")
public class Friend_Request extends BaseEntity {
    private Long sender_id;
    private Long receiver_id;
}
