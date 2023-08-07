package club.supreme.message.resolver;

import club.supreme.message.model.User;
import club.supreme.message.model.Receiver;

import java.util.List;

interface ReceiverResolver {
    List<User> resolve(Receiver receiver);
    List<User> resolveAll(List<Receiver> receiverList);
}