package oncall.model;

import java.util.Objects;
import oncall.exception.ErrorMessage;

public class Worker {

    private static final int MAX_NAME_SIZE = 5;

    private String name;

    public Worker(String name) {
        validate(name);
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }
}
