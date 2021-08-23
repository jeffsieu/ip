package duke.task;

public class DukeEvent extends DukeTask {
    final DukeDate date;

    public DukeEvent(String name, String date) {
        super(name);
        this.date = DukeDate.of(date);
    }

    public DukeEvent(String name, boolean isDone, String date) {
        super(name, isDone);
        this.date = DukeDate.of(date);
    }

    @Override
    public String toString() {
        return String.format("%s (at %s)", super.toString(), date);
    }

    @Override
    public String toSerializedString() {
        return String.format("%s/%d/at/%s", name, done ? 1 : 0, date);
    }
}
