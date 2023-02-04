package world.rfch.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString(exclude = "password")
public class LoginDto {

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 6, max = 16)
    private String password;


}
