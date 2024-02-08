package users.api.hexagonal.users.api.hexagonal.application.exception;

public class ThirdPartyException extends RuntimeException {

    public ThirdPartyException(String message) {
        super(message);
    }
}
