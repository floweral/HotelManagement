import org.jmock.Expectations;
import org.jmock.States;
public class MockTest extends TestBase{
	final States states = context.states("sm").startsAs("s1");
	/*
	 * ����
	 */
	@Override
	protected void setUpExpectations(){
		context.checking(new Expectations(){{
			allowing(idata).in_Out_Room(901, "allen");
			when(states.is("s1"));
			will(returnValue("allen�ɹ���ס901���䣡"));
			allowing(idata).in_Out_Room(901,"Marry");
			when(states.is("s1"));
			will(returnValue("Marry�ɹ���ס901���䣡"));
			allowing(idata).in_Out_Room(901,"Tom");
			then(states.is("s2"));
			when(states.is("s2"));
			will(returnValue("Tom�ɹ���ס901���䣡"));
		}});
	}
	/**
	 * ���÷�������֤
	 */
	@Override
	protected void invokeAndVerify(){
		//״̬1
		assertState(901,"allen","allen�ɹ���ס901���䣡");
		assertState(901,"allen","allen�ɹ���ס901���䣡");
		//��ת��״̬2
		assertState(901,"Marry","Marry�ɹ���ס901���䣡");
		assertState(901,"Marry","Marry�ɹ���ס901���䣡");
		//״̬2
		assertState(901,"Tom","Tom�ɹ���ס901���䣡");
	}
}
