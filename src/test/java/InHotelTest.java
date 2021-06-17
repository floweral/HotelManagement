import static org.junit.Assert.*;
import org.junit.Test;
import hotel.DP;
import hotel.IData;
import hotel.InHotel;

public class InHotelTest {
	protected DP dp=new DP();
	protected IData id=dp;
	protected InHotel ih=new InHotel(id);
	@Test
	public void testIn() {
		id.iniRooms();
		assertEquals("Marry�ɹ���ס901���䣡",ih.in(901, "Marry"));
	}

}
