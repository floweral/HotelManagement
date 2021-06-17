import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.junit.Test;
import hotel.IData;
import hotel.InHotel;
public abstract class TestBase {
	//����һ��test�����Ķ���
	protected Mockery context=new Mockery();
	//����һ��mock����
	protected final IData idata=context.mock(IData.class);
	
	/*
	 * ʵ����Ҫ���Ե���
	 */
     protected InHotel ih;
     
     /*
      * ���ò����࣬������Mock�Ľӿ�
      */
     private void setUpMockInterface(){
    	 ih=new InHotel(idata);
    	 
     }
     /**
      * ����Mock�Ľӿڣ����ҷ�����ֵ֤
      * @param  roomNo,name
      * @param  expected
      * 
      */
     protected void assertState(int roomNo,String name,String expected){
    	     	 assertEquals(expected,ih.in(roomNo, name));
     }
     
     /**
      * ����iData������֤�����׳��쳣
      */
     protected void  assertStateFail(int roomNo,String name){
    	 try{
    		 ih.in(roomNo, name);
    		 fail("��������");
    	 }catch(Throwable t){}
     }

@Test
public final void test(){
 setUpExpectations();
 setUpMockInterface();
 invokeAndVerify();
	}
/*
 * ����
 */
protected abstract void setUpExpectations();
/**
 * ���÷�������֤
 */
protected abstract void invokeAndVerify();
}
