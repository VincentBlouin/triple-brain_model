package guru.bubl.module.model.notification;

import java.net.URI;
import java.util.Date;

public class Notification {
    private String label;
    private URI rootUri;
    private URI watchUri;
    private Date date;
    private String action;

    private String watchLabel;

    public Notification(String label, URI rootUri, URI watchUri, Date date, String action, String watchLabel) {
        this.label = label;
        this.rootUri = rootUri;
        this.watchUri = watchUri;
        this.date = date;
        this.action = action;
        this.watchLabel = watchLabel;
    }

    public String getLabel() {
        return label;
    }

    public URI getRootUri() {
        return rootUri;
    }

    public URI getWatchUri() {
        return watchUri;
    }

    public Date getDate() {
        return date;
    }

    public String getAction() {
        return action;
    }

    public String getWatchLabel() {
        return watchLabel;
    }
}
