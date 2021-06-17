import org.jmock.Expectations;
import org.jmock.Sequence;
public class MockIteratorTest extends TestBase{
	final Sequence sequence = context.sequence("mySeq_01");  
	/*
	 * ����
	 */
	@Override
	protected void setUpExpectations(){
		context.checking(new Expectations(){{
			oneOf(idata).in_Out_Room(901,"Marry");
			inSequence(sequence);
			will(returnValue("Marry�ɹ���ס901���䣡"));
			oneOf(idata).in_Out_Room(901,"Marry");
			inSequence(sequence);
			will(returnValue("�Ѿ����˿���"));
		}});
	}
	/**
	 * ���÷�������֤
	 */
	@Override
	protected void invokeAndVerify(){
		//assertState(901,"Marry","Marry�ɹ���ס901���䣡");
		assertState(901,"Marry","�Ѿ����˿���");
	}
}
