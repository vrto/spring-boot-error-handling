package sk.vrto;

import org.springframework.stereotype.Component;
import sk.vrto.exception.NotFoundException;

import java.util.Map;

@Component
public class CompanyGuardian extends UrlParameterGuardian {
    @Override
    protected void checkUrlVariables(Map<String, Object> parameters) {
        if (parameters.containsKey("companyId"))
            throw new NotFoundException("Unknown company: " + parameters.get("companyId"));
    }
}
