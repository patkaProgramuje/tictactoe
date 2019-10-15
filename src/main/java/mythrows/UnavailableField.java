package mythrows;

public class UnavailableField extends Exception {

    private String message;

    public UnavailableField(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
