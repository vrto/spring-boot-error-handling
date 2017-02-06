# spring-boot-error-handling

This is a proof of concept application that handles common error scenarios for a REST API system.

## scenarios
- Unexpected exception - returns "Internal Server Error"
    - code: [ErrorHandler.allOtherErrorsHandler](src/main/java/sk/vrto/ErrorHandler.java#L19)
- Unknown route - returns "Not Found"
    - code: [ErrorHandler.unknownRouteHandler](src/main/java/sk/vrto/ErrorHandler.java#L28)
- Invalid payload (marhsalling failure - eg. invalid types or bogus payload in general)
    - not concerned with actual business logic validation
    - code: [ErrorHandler.invalidPayloadMarshallingHandler](src/main/java/sk/vrto/ErrorHandler.java#L35)
- Service-thrown exceptions handled by a special handler
    - translates service-layer exceptions to web-layer responses
    - picks up Guardian-thrown authroization errors as well, see [CompanyGuardian](src/main/java/sk/vrto/CompanyGuardian.java)
    - code: [ErrorHandler.appThrownExceptions](src/main/java/sk/vrto/ErrorHandler.java#L42)
- Allowed a way to pass Preconditions (translated to `ResponseEntity` responses) as an alternate approach to exception handlers - see [PreconditionsAction](src/main/java/sk/vrto/precondition/PreconditionsAction.java)
    - synchronously via [call](src/main/java/sk/vrto/precondition/PreconditionsAction.java#L27) and asynchronously via [callNonBlocking](src/main/java/sk/vrto/precondition/PreconditionsAction.java#L32)
    - invoked via controller methods [SampleController.preconditionVetoedAccess](src/main/java/sk/vrto/SampleController.java#L45) and [SampleController.preconditionVetoedAccessNonBlocking](src/main/java/sk/vrto/SampleController.java#L54)   
    

## running
`gradle bootRun`

## building
`gradle build`

## notes
This sample is using [project lombok](https://projectlombok.org), you may need to install a lombok plugin for your IDE.
