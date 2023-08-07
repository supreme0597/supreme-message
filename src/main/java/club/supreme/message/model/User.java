package club.supreme.message.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String phone;
    private String email;
    private String discordId;
    private String outlookId;
}