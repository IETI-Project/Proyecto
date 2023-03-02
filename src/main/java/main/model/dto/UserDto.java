package main.model.dto;

public class UserDto {
    private String name;
    private String email;
    private String password;

    public UserDto() {

    }

    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto(String name, String email) {
        this.name = name;

        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

