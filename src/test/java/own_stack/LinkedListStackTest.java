package own_stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListStackTest {
    List<Integer> testData;

    @Before
    public void init(){
        testData = Arrays.asList(600, 1200, 500, 200);
    }

    @Test
    public void testPushPop(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(300);
        stack.push(1);
        assertEquals("1,300,", stack.toString());
        assertEquals(1, (int)stack.pop());
        assertEquals("300,", stack.toString());
    }
    
    @Test
    public void stackPopIsEmpty(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
        for (Integer value : testData) {
            stack.push(value);
        }
        assertFalse(stack.isEmpty());

        for (int i = testData.size(); i > 0 ; --i) {
            assertEquals(testData.get(i-1), stack.pop());
        }
    }

    @Test
    public void testPushIsEmpty() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());

        for (Integer value : testData) {
            stack.push(value);
        }
        assertFalse(stack.isEmpty());
    }



}