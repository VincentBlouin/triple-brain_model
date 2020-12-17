package guru.bubl.module.model.notification;

import java.net.URI;
import java.util.Date;

public class Notification {
    private String label;
    private URI rootUri;
    private URI watchUri;
    private Date date;
    private String action;

    public Notification(String label, URI rootUri, URI watchUri, Date date, String action) {
        this.label = label;
        this.rootUri = rootUri;
        this.watchUri = watchUri;
        this.date = date;
        this.action = action;
    }

}
