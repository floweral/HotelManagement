package hotel;

import java.util.Scanner;
public class MainRun {
	private static ListHome lh=new ListHome();// ��ʾ����
	private static InHotel ih=null;
	private static OutHotel oh=null;
	static DP dp=new DP();
	 static IData id =dp;
    	public static void main(String[] args) {
      		
		id.iniRooms();
		Command();
	}
	private static  void Command() {
		String comm;// ��ʾ�û����������
		Scanner sca=new Scanner(System.in);
		while (true) {
			System.out.println("���������");
			System.gc();
			comm = sca.next();
			if ("search".equalsIgnoreCase(comm)) {
				lh.search();
			} else if ("in".equalsIgnoreCase(comm)) {
				int roomNo = sca.nextInt();
				try{
				if( validRoomNo(roomNo)){
					String name = sca.next();
					ih=new InHotel(id);
					System.out.println(ih.in(roomNo, name));
					}else
				      System.out.println("����Ŵ�!");
				}catch(Exception e)
				{
					System.out.println(e.toString());
				}
				
			} else if ("out".equalsIgnoreCase(comm)) {
				int roomNo = sca.nextInt();
				if( validRoomNo(roomNo)){
					
					oh=new OutHotel(id);
					System.out.println(oh.out(roomNo));
					}else
						System.out.println("����Ŵ�!");
													
			} else if ("exit".equalsIgnoreCase(comm)) {
				System.out.println("�����˳�...");
				break;
			} else {
				System.out.println("��������������������룺");
			}
			
		}
		sca.close();
		
	}
	private static  boolean validRoomNo(int roomNo){
		if((roomNo/100>10)||(roomNo/100<1)||(roomNo%100>12)||(roomNo%100<1))
			{
				return false;}
			else 
				{return true;}		
	}
	
}

