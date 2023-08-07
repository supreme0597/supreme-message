package club.supreme.message.formatter;

import club.supreme.message.model.User;

import java.util.ArrayList;
import java.util.List;

public class OutlookEmailUserFormatter implements UserFormatter {
    public List<String> format(List<User> userList) {
        // Format the list of users for Outlook Email provider

        return new ArrayList<>();
    }
}