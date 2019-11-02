package win.mortalliao.admin.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;

/**
 * @author liaoyujian
 *         <p>
 *         Jackson序列化：预防XSS攻击
 */
@JsonComponent
@ConditionalOnExpression("'${spring.jackson.XSS}' == 'true'")
public class JsonStringSerializer {

    //返回Json字符串时序列化
    public static class StringSerializer extends JsonSerializer<String> {
        @Override
        public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            //jsonGenerator.writeString(HtmlUtils.htmlEscape(str));
            jsonGenerator.writeString(str);
        }
    }

    //接收Json字符串时反序列化
    public static class StringDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String str = jsonParser.getValueAsString();
            return HtmlUtils.htmlEscape(str);
        }
    }
}
