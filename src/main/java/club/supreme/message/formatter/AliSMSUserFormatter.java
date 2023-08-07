package club.supreme.message.formatter;

import club.supreme.message.model.User;

import java.util.ArrayList;
import java.util.List;

public class AliSMSUserFormatter implements UserFormatter {
    public List<String> format(List<User> userList) {
        // Format the list of users for Ali SMS provider
        return new ArrayList<>();
    }
}