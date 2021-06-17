package hotel;

public class Search {
	IData id;
	DP dp=new DP();
	public String status(int roomNumber) {
		String roomStatus="�÷���Ϊ��";
		id=dp;
		if(roomNumberIsValid(roomNumber))
		{if(!roomIsEmpty(roomNumber)){
			roomStatus = id.getStation(roomNumber);
		}}else
		{
			roomStatus="��������ȷ�ķ����";
		}
		return roomStatus;
	}

	private boolean roomNumberIsValid(int roomNumber) {
		int floor = roomNumber/100;
		int roomSeq = roomNumber%100;
		return floor>0&&roomSeq<=HotelConstant.HOTEL_TOTAL_FLOOR&&roomSeq>0&&roomSeq<=HotelConstant.HOTEL_ROOMS_EVERYFLOOR;
	}
	
	private boolean roomIsEmpty(int roomNumber) {
		return HotelConstant.EMPTY.equals(id.getStation(roomNumber));
	}

}
