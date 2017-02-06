package sk.vrto;

import org.springframework.stereotype.Service;
import sk.vrto.exception.biz.ServiceLayerException;

@Service
class SampleService {

    void performCrashingCommand() {
        throw new ServiceLayerException();
    }
}
