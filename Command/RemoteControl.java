package desingPattern.command;

public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new NoCommand();  // 초기화를 위한 null 커맨더
		
		for (int i = 0; i < 7; i++) {  // 초기화
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}
	
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		
		stringBuff.append("\n------------ Remote Control -------------\n");
		for(int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " 
					+ onCommands[i].getClass().getName() + "\t" 
					+ offCommands[i].getClass().getName() + "\n");
		}
		
		return stringBuff.toString();
	}
}
