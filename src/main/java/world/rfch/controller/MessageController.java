package world.rfch.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.rfch.dto.request.MessageRequestDTO;
import world.rfch.dto.response.MessageResponseDto;
import world.rfch.dto.response.ResponseDto;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.service.impl.MessageServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name="/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageServiceImpl messageServiceImpl;

    @GetMapping("/find/all")
    public ResponseEntity<List<MessageResponseDto>> findAllByReceiverUserAndSenderUserOrderByDateDesc(@RequestParam
                                                                                                          UserEntity senderUser,
                                                                                                      @RequestParam UserEntity
                                                                                                              receiverUser) {
        List<MessageEntity> messageEntities = messageServiceImpl.findAllByReceiverUserAndSenderUserOrderByDateDesc(
                senderUser, receiverUser);


        return ResponseEntity.ok(getList(messageEntities));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody MessageRequestDTO messageRequestDTO) {
        try {
            messageServiceImpl.save(messageRequestDTO.toEntity());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            MessageEntity message = messageServiceImpl.findById(id);
            return ResponseEntity.ok(ResponseDto.builder().data(message.getId().toString()).httpStatus(HttpStatus.ACCEPTED).build());
        } catch (Exception ex) {
            return ResponseEntity.ok(ResponseDto.builder().data(ex.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            messageServiceImpl.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MessageResponseDto>> findAll() {
        List<MessageEntity> messageEntities = messageServiceImpl.findAll();


        return ResponseEntity.ok(getList(messageEntities));
    }

    private List<MessageResponseDto> getList(List<MessageEntity> messageEntities) {
        List<MessageResponseDto> messageResponseDtos = new ArrayList<>();
        for (MessageEntity message : messageEntities) {
            MessageResponseDto messageResponseDto = new MessageResponseDto();
            messageResponseDto.setContent(message.getContent());
            messageResponseDto.setDate(message.getDate());
            messageResponseDto.setSenderUsername(message.getSenderUser().getUsername());
            messageResponseDto.setReceiverUsername(message.getReceiverUser().getUsername());


        }
        return messageResponseDtos;
    }
}
