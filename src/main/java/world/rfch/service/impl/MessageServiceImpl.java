package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.MessageRepository;
import world.rfch.service.MessageService;

import java.util.List;

@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private  final MessageRepository messageRepository;

    @Override
    public List<MessageEntity> findAllByReceiverUserAndSenderUserOrderByDateDesc(UserEntity senderUser,
                                                                                 UserEntity receiverUser) {
        return messageRepository.findAllByReceiverUserAndSenderUserOrderByDateDesc(senderUser, receiverUser);
    }

    @Override
    public MessageEntity findById(Long id) {
        return messageRepository.findById(id).
                orElseThrow(() -> new RuntimeException("can not find message with given id"));
    }

    @Override
    public MessageEntity save(MessageEntity messageEntity) {
return messageRepository.save(messageEntity);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<MessageEntity> findAll() {
        return messageRepository.findAll();
    }


}
