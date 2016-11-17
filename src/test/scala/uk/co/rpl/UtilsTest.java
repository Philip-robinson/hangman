package uk.co.rpl;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Created by philip on 15/11/2016.
 */
public class UtilsTest {
    @Test
    public void prlineTest() throws Exception {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            try(PrintStream ps = new PrintStream(bos)) {
                Out inst = new Out(ps);
                inst.prline();
                assertTrue(bos.toString().startsWith("#"));
                assertTrue(bos.toString().endsWith("#\n"));
                assertEquals(inst.MAX_LEN()+1, bos.toString().length());
            }
        }
    }

    @Test
    public void prline1() throws Exception {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            try(PrintStream ps = new PrintStream(bos)) {
                Out inst = new Out(ps);
                inst.prline("123");
                assertTrue(bos.toString().startsWith("# 123"));
                assertTrue(bos.toString().endsWith("#\n"));
                assertEquals(inst.MAX_LEN()+1, bos.toString().length());
            }
        }

    }

}