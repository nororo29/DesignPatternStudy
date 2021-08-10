package desingPattern.command;

import desingPattern.command.receiver.Light;

// Client
public class RemoteLoader {

	public static void main(String[] args) {
		// 리모컨 - 인보커객체 Invoker 생성
		RemoteControl remoteControl = new RemoteControl();
		
		// 리시버 생성 - 행동action() 메서드들이 구체화되어있는 객체
		Light livingRoomLight = new Light("living room");
		Light kitchenRoomLight = new Light("kitchen");
//		CeilingFan ceilingFan = new CeilingFan("living room");
//		GarageDoor garageDoor = new GarageDoor("");
//		Stereo stereo = new Stereo("living room");
		
		// 각 커맨드 객체 생성
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		
		LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLight);
		LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLight);
		
		// 리모컨에 커맨드들 로드
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);
		
		// 리모컨 정보 출력 - toString()메소드
		System.out.println(remoteControl);
		
		// 리모컨 작동해보기
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		

	}

}
