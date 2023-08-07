package club.supreme.message.resolver;

import club.supreme.message.model.User;
import club.supreme.message.model.Receiver;

import java.util.ArrayList;
import java.util.List;

public class CompositeReceiverResolver implements ReceiverResolver {
    private List<ReceiverResolver> resolvers;
    public List<User> resolve(Receiver receiver) {
        // Resolve the receiver to a list of users using the composite resolver
        return new ArrayList<>();
    }
    public List<User> resolveAll(List<Receiver> receiverList) {
        // Resolve all receivers to a list of users using the composite resolver
        return new ArrayList<>();
    }
}