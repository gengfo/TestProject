package mypack.mockito;

import junit.framework.Assert;

import mypack.MainTstObject;
import mypack.MayMockObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MainTstObjectMockitoTest {

	// ָ��Mock�Ķ���
	@Mock
	private MayMockObject mayMockObject;

	private MainTstObject mainTstObject;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this); // ��������������

		this.mainTstObject = new MainTstObject();
		this.mainTstObject.setMayMockObject(this.mayMockObject);
	}

	@Test
	public void process() {
		String str1 = "Mockito�����ַ�����";
		String str2 = "Mockito�����ַ�����";

		Mockito.when(this.mayMockObject.getString(str2)).thenReturn(""); // Mock����ֵ

		String ret = this.mainTstObject.create(str1, str2);
		Assert.assertEquals(ret, str1);
	}

	@After
	public void tearDown() {
	}

}
