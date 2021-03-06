/*
 * The MIT License
 *
 * Copyright 2014 Wave Software.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package pl.wavesoftware.netbeans.eid.generator.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Krzysztof Suszyński <krzysztof.suszynski@wavesoftware.pl>
 */
public class DateGeneratorTest {

    public DateGeneratorTest() {
    }

    @Test
    public void testGenerate() {
        String format = "yyyyMMdd:HHmmss";
        DateGenerator instance = new DateGenerator(format);
        Calendar mock = Mockito.mock(Calendar.class);
        long milis = 1393086452000L;
        when(mock.getTimeInMillis()).thenReturn(milis);
        instance.cal = mock;
        Date date = new Date(milis);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String expResult = formatter.format(date);
        String result = instance.generate();
        assertEquals(expResult, result);
    }

}
