package gov.cms.qpp.conversion.model.error;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DetailTest {
	@Test
	public void stringRepresentation() {
		Detail objectUnderTest = new Detail("text", "path");

		assertThat("toString representation", objectUnderTest.toString(), is("Detail{message='text', path='path', value='null', type='null'}"));
	}

	@Test
	public void stringRepresentationWithValueAndType() {
		Detail objectUnderTest = new Detail("text", "path", "value", "type");

		assertThat("toString representation", objectUnderTest.toString(), is("Detail{message='text', path='path', value='value', type='type'}"));
	}
}