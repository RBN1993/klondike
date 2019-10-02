package klondike.utils;

import java.util.ArrayList;

public abstract class Menu {

    private static final String OPTION = "Choose an option: ";
    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<Command>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        for (int i = 0; i < this.commandList.size(); i++) {
            commands.add(this.commandList.get(i));
        }
        int option = getOption(commands);
        commands.get(option).execute();
    }

    private int getOption(ArrayList<Command> commands) {
        boolean error;
        int option;
        do {
            error = false;
            for (int i = 0; i < commands.size(); i++) {
                IO.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            IO.write(OPTION);
            option = IO.readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).includes(option)) {
                error = true;
            }
            IO.writeln();
        } while (error);
        return option;
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
