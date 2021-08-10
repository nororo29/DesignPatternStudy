package desingPattern.command;

import desingPattern.command.receiver.Light;

// Client
public class RemoteLoader {

	public static void main(String[] args) {
		// ������ - �κ�Ŀ��ü Invoker ����
		RemoteControl remoteControl = new RemoteControl();
		
		// ���ù� ���� - �ൿaction() �޼������ ��üȭ�Ǿ��ִ� ��ü
		Light livingRoomLight = new Light("living room");
		Light kitchenRoomLight = new Light("kitchen");
//		CeilingFan ceilingFan = new CeilingFan("living room");
//		GarageDoor garageDoor = new GarageDoor("");
//		Stereo stereo = new Stereo("living room");
		
		// �� Ŀ�ǵ� ��ü ����
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		
		LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
		LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);
		
		// �������� Ŀ�ǵ�� �ε�
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);
		
		// ������ ���� ��� - toString()�޼ҵ�
		System.out.println(remoteControl);
		
		// ������ �۵��غ���
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		

	}

}
