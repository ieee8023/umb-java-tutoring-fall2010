package http.rss;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class Rss {
    Version version;
    Channel channel;
}
class Channel {
    String title, link, description, language, webMaster, pubDate, lastBuildDate, copyright, docs, ttl, atom;
    List<Item> items = new ArrayList<Item>();
}
class Item {
    String title, link, description;
}

class Version {
    private String value;
    public Version(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;  
    }
}


