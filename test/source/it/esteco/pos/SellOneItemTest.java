package it.esteco.pos;

import it.esteco.pos.Display;
import it.esteco.pos.Sale;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {

    @Test
    public void productFound() throws Exception {
        Display display = new Display();
        Sale sale = new Sale();

        sale.onBarcode("12345");

        assertEquals("$7.95", display.getText());
    }
}
