package sk.vrto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
class SampleController {

    @RequestMapping(value = "/internal-server-error", method = GET)
    public String causeInternalError() {
        throw new RuntimeException();
    }

    @RequestMapping(value = "/consume-payload", method = POST)
    public void consumePayload(@RequestBody PayloadBean payload) {
        // nothing interesting, we're testing that the payload will make it here
    }

    @RequestMapping(value = "/{companyId}/protected", method = GET)
    public void guardianVetoedAccess(@PathVariable long companyId) {
        // nothing interesting, CompanyGuardian will veto access to this method
    }

}
