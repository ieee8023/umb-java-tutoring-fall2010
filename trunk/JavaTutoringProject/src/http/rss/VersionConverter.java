package http.rss;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class VersionConverter extends AbstractSingleValueConverter {
	
    @SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
    	return type.equals(Version.class);
    }
    
    public String toString(Object obj) {
        return obj == null ? null : ((Version) obj).getValue();
    }
    
    public Object fromString(String str) {
        return new Version(str);
    }
}