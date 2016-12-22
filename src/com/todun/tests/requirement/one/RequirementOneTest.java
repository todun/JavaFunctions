package com.todun.tests.requirement.one;

import com.todun.utils.requirement.one.RequirementOne;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RequirementOneTest {
    @Test
    public void testIsNullOrEmptyWithEmptyString() {
        assertTrue(RequirementOne.isNullOrEmpty(""));
    }

    @Test
    public void testIsNullOrEmptyWithNullString() {
        assertFalse(RequirementOne.isNullOrEmpty("null"));
    }

    @Test
    public void testIsNullOrEmptyWithLetteredString() {
        assertFalse(RequirementOne.isNullOrEmpty("a"));
    }

    @Test
    public void testIsNullOrEmptyWithNull() {
        assertTrue(RequirementOne.isNullOrEmpty(null));
    }
}
