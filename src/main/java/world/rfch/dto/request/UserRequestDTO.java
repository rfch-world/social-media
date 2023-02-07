package world.rfch.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import world.rfch.enums.Gender;
import world.rfch.enums.MaritalStatus;
import world.rfch.jpa.entity.UserEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
public class UserRequestDTO {

    @NotBlank(message = "Please fill the all fields")
    @Size(min = 2, max = 20, message = "Username size must be between 2 and 20")
    private String username;


    @NotBlank
    @Size(min = 3, max = 35, message = "Name size must be between 2 and 15")
    private String name;


    @NotBlank
    @Size(min = 3, max = 35, message = "Surname size must be between 2 and 20")
    private String surname;


    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @NotBlank(message = "Please fill the all fields")
    @Size(min = 11, max = 35, message = "Email size must be between 11 and 35")
    private String email;

    @NotBlank(message = "Please fill the all fields")
    @Size(min = 5, max = 25, message = "Password size must be between 3 and 25")
    private String password;


    private String countryName;


    private String cityName;

    private Gender gender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    private MaritalStatus maritalStatus;


    @Size(min = 3, max = 25, message = "Address size must be between 3 and 50")
    private String address;


    @Size(min = 3, max = 25, message = "Contact Number size must be between 3 and 25")
    private String contactNumber;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    @Size(min = 11, max = 35, message = "Email size must be between 11 and 35")
    private String contactEmail;


    private String image;

    private String URL;


    public UserEntity toEntity(){
        return UserEntity.builder()
                .username(this.username)
                .name(this.name)
                .surname(this.surname)
                .email(this.email)
                .password(this.password)
                .countryName(this.countryName)
                .cityName(this.cityName)
                .gender(this.gender)
                .dateOfBirth(this.dateOfBirth)
                .maritalStatus(this.maritalStatus)
                .address(this.address)
                .contactNumber(this.contactNumber)
                .contactEmail(this.contactEmail)
                .image(this.image)
                .build();
    }


}
