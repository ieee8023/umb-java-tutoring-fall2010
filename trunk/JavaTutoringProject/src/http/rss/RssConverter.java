package http.rss;

import java.io.FileInputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class RssConverter {
	
    private XStream xs;
    public RssConverter(XStream xs) {
    	this.xs = xs;
        xs.alias("rss", Rss.class);
        xs.alias("atom:link", String.class);
        xs.alias("title", String.class);
        xs.addImplicitCollection(Channel.class, "items", "item", Item.class);
        xs.useAttributeFor("version", Version.class);
        xs.registerConverter(new VersionConverter());
    }
    
    public RssConverter() {
        this(new XStream(new DomDriver()){
        	@Override
        	protected MapperWrapper wrapMapper(MapperWrapper next) {
        		return new MapperWrapper(next){
        			@SuppressWarnings("rawtypes")
        			@Override
        			public boolean shouldSerializeMember(Class definedIn, String fieldName) {
      	    	  
        				if (definedIn == Object.class)
        					return false;
      	        
        				return super.shouldSerializeMember(definedIn, fieldName);
      	        
        			}
        		};
        	}
        });
    }
    
    public Rss fromXml(String rss) {
    	return (Rss) xs.fromXML(rss);
    }
    
    public Rss fromXml(FileInputStream fileInputStream) {
        return (Rss) xs.fromXML(fileInputStream);
    }
    public void toXml(Rss rss, OutputStream stream) {
        xs.toXML(rss, stream);
    }
}