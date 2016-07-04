package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;

import java.net.URI;

/**
 * Created by alexander.hubachov on 30.06.2016.
 */
@Controller
public class ResourceController {

    @Autowired
    @Qualifier("sparklrRestTemplate")
    private RestOperations restTemplate;

    @RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String user() {
        return restTemplate.getForObject(URI.create("http://localhost:9999/uaa/user"), String.class);
    }

    @RequestMapping(value = "resource", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String resource() {
        String result = restTemplate.getForObject(URI.create("http://localhost:9999/uaa/hello"), String.class);
        return result;
    }

}
