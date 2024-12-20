package oncall.model;

import java.util.Objects;
import oncall.exception.ErrorMessage;

public class Worker {

    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private Worker(String name) {
        validateSize(name);
        this.name = name;
    }

    public static Worker from(String name) {
        return new Worker(name);
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

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }
}
