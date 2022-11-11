package com.lab_6_1.command;

import java.util.ArrayList;
import java.util.List;

public class Commands {

	private List<Command> commandList = new ArrayList<>();

	public void executeCommands(Command command) {

		commandList.add(command);
		command.execute();
	}
}
