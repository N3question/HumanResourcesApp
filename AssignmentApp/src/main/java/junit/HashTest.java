package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.hash.Hash;

class HashTest {

	@Test
	public void testHash() {
		String result = Hash.hashingPassword("sample1");
		assertEquals("e85130791f31db1699f61a5e7ae7b5e85e70399414f38476091896214771cd17", result);
	}

}
