package mypack.jmock;

import junit.framework.Assert;

import mypack.MainTstObject;
import mypack.MayMockObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTstObjectJMockTest {

	private Mockery context = new JUnit4Mockery();

	private MayMockObject mayMockObject;
	private MainTstObject mainTstObject;

	@Before
	public void setUp() {
		this.mayMockObject = this.context.mock(MayMockObject.class); // Mock����ӽӿ�

		this.mainTstObject = new MainTstObject();
		this.mainTstObject.setMayMockObject(this.mayMockObject);
	}

	@Test
	public void process() {
		final String str1 = "Mockito�����ַ�����";
		final String str2 = "Mockito�����ַ�����";

		this.context.checking(new Expectations() {
			{
				oneOf(mayMockObject).getString(str2);
				will(returnValue("")); // Mock����ֵ

				// allowing(mayMockObject).getString(with(any(String.class)));
				// will(returnValue(""));
			}
		});

		String ret = this.mainTstObject.create(str1, str2);
		Assert.assertEquals(ret, str1);
	}

	@After
	public void tearDown() {
	}
}
