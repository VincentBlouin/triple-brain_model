package guru.bubl.module.model.notification;

import guru.bubl.module.model.User;

import java.util.List;

public interface NotificationOperator {
    void add();
    List<Notification> listForUser(User user);
}
