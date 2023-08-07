package club.supreme.message.formatter;

import club.supreme.message.model.User;

import java.util.List;

public interface UserFormatter {
    List<String> format(List<User> userList);
}