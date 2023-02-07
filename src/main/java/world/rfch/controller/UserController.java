package world.rfch.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import world.rfch.dto.request.UserRequestDTO;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.service.UserService;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Void> updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserEntity userEntity = new UserEntity();

            userEntity.setName(userRequestDTO.getName());
            userEntity.setUsername(userRequestDTO.getUsername());
            userEntity.setCountryName(userRequestDTO.getCountryName());
            userEntity.setEmail(userRequestDTO.getEmail());
            userEntity.setAddress(userRequestDTO.getAddress());
            userEntity.setSurname(userRequestDTO.getSurname());
            userEntity.setCityName(userRequestDTO.getCityName());
            userEntity.setGender(userRequestDTO.getGender());
            userEntity.setMaritalStatus(userRequestDTO.getMaritalStatus());
            userEntity.setDateOfBirth(userRequestDTO.getDateOfBirth());
            userEntity.setContactNumber(userRequestDTO.getContactNumber());
            userEntity.setContactEmail(userRequestDTO.getContactEmail());
            userEntity.setUrl(userRequestDTO.getURL());
            userEntity.setImage(userRequestDTO.getImage());

            userService.save(userEntity);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
