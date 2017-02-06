package sk.vrto;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@AllArgsConstructor
class SampleController {

    private final SampleService service;

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

    @RequestMapping(value = "/service-conflict", method = GET)
    public void causeConflictInServiceLayer() {
        service.performCrashingCommand();
    }

}
