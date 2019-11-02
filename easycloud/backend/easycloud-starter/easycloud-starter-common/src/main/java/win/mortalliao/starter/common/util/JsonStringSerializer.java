package win.mortalliao.starter.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;

/**
 * @author liaoyujian
 * JSON中预防XSS，进行转义
 */
@JsonComponent
public class JsonStringSerializer {

    public static class StringSerializer extends JsonSerializer<String> {
        @Override
        public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeString(HtmlUtils.htmlEscape(str));
        }
    }

    public static class StringDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return HtmlUtils.htmlEscape(jsonParser.getValueAsString());
        }
    }
}
