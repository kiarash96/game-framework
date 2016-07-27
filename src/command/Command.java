package command;

/**
 * Created by kiarash on 7/19/16.
 */
public class Command {
    Category category;
    Action action;

    public Command() { }

    public Command(Action action, Category category) {
        this.action = action;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
