package decoratorPattern2;

public class Client {

	public static void main(String[] args) {
		// �⺻����ǥ��
		Display road = new RoadDisplay();
		road.draw();
		
		// �⺻����ǥ�� + ����ǥ��
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw();
		
		// �⺻����ǥ�� + ���뷮ǥ��
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw();
		
		// �⺻����ǥ�� + ����ǥ�� + ���뷮ǥ��
		Display roadWithTrafficLane = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
		roadWithTrafficLane.draw();
	}

}
