package desingPattern.command;

import desingPattern.command.receiver.Light;

public interface Command {
	public void execute();
	public void undo();
}

class NoCommand implements Command {

	@Override
	public void execute() {}

	@Override
	public void undo() {}
	
}

class LightOnCommand implements Command {
	
	Light light;  // ���ù�
	
	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}
	
}


class LightOffCommand implements Command {
	
	Light light;  // ���ù�
	
	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}
	
}