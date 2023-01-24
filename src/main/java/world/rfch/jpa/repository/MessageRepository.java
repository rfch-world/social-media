package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Long> {

    List<MessageEntity> findAllByReceiverUserAndSenderUserOrderByDateDesc
            (UserEntity senderUser, UserEntity receiverUser);
}
