package sk.vrto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class SampleController {

    @RequestMapping(value = "/internal-server-error", method = GET)
    String causeInternalError() {
        throw new RuntimeException();
    }

    @RequestMapping(value = "/consume-payload", method = POST)
    void consumePayload(@RequestBody PayloadBean payload) {
        payload.getBar();
    }
}
