package MajorClasses;

import Commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandMap {


    Map<String, Command> commandMap = new HashMap<>();
    public CommandMap(java.time.LocalDate time) {

        this.commandMap.put("help", new Help());

        this.commandMap.put("info", new Info(time));

        this.commandMap.put("show", new Show());

        this.commandMap.put("clear", new Clear());

        this.commandMap.put("exit", new Exit());

        this.commandMap.put("save", new Save());

        this.commandMap.put("execute_script", new ExecuteScript());

        this.commandMap.put("add", new Add());

        this.commandMap.put("update", new UpdateId());

        this.commandMap.put("remove_by_id", new Remove_by_id());

        this.commandMap.put("add_if_min", new AddIfMin());

        this.commandMap.put("remove_lower", new RemoveLower());

        this.commandMap.put("remove_all_by_owner", new RemoveAllByOwner());

        this.commandMap.put("print_descending", new PrintDescending());

        this.commandMap.put("history", new History());

        this.commandMap.put("group_counting_by_part_number", new GroupCountingByPartNumber());
    }

    public Command getCommand(String args) {

        ArrayList<String> arrArgs = new ArrayList<>(Arrays.asList(args.split(" ")));

        Command command = commandMap.get(arrArgs.get(0));
        arrArgs.remove(0);
        command.addArgs(arrArgs);
        return command;
    }
}
