package duke;

import duke.command.DukeCommand;
import duke.exception.InvalidCommandException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class Ui {
    private static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private final Scanner scanner;
    private final PrintStream outputStream;
    private boolean exit;

    public Ui(InputStream inputStream, PrintStream outputStream) {
        this.scanner = new Scanner(inputStream);
        this.outputStream = outputStream;
        this.exit = false;
    }

    public String nextCommand() {
        outputStream.print("Duke> ");
        return scanner.nextLine();
    }

    public void outputLine(String output) {
        outputStream.println(output);
    }

    public void printWelcomeMessage() {
        outputLine("Hello from\n" + logo);
    }

    public void printExitMessage() {
        outputLine("Goodbye from\n" + logo);
    }

    public void printHelp() {
        try {
            DukeCommand.HELP.apply(null, this, null, "", Map.of());
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    public void markExit() {
        exit = true;
    }

    public boolean shouldContinue() {
        return !exit;
    }
}
