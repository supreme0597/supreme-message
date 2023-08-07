package club.supreme.message.resolver;

import club.supreme.message.model.User;
import club.supreme.message.model.Receiver;

import java.util.ArrayList;
import java.util.List;

public class RoleReceiverResolver implements ReceiverResolver {
    public List<User> resolve(Receiver receiver) {
        // Resolve the receiver to a list of users based on their role
        return new ArrayList<>();
    }
    public List<User> resolveAll(List<Receiver> receiverList) {
        // Resolve all receivers to a list of users based on their role
        return new ArrayList<>();
    }
}