package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

public class MainFreemarker {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(MainFreemarker.class, "/template/");
        Template template = configuration.getTemplate("index.ftl", "utf-8");
        StringWriter stringWriter = new StringWriter();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("test", "poipoipoipoio");
        template.process(map, stringWriter);
        System.out.println(stringWriter);



    }
}
