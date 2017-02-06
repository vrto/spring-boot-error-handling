package sk.vrto.exception.biz;

import sk.vrto.exception.web.ConflictException;

public class ServiceLayerException extends ConflictException {

    public ServiceLayerException() {
        super("Some important message from service layer");
    }
}
