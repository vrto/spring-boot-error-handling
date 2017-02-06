package sk.vrto.exception.web;

import sk.vrto.JsonError;

public interface JsonErrorBodyAware {
    JsonError createErrorBody();
}
