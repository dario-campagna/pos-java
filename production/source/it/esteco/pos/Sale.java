package it.esteco.pos;

import java.util.HashMap;
import java.util.Map;

public class Sale {

    private Display display;
    private final Map<String, String> pricesByBarcode;

    public Sale(Display display, HashMap<String, String> pricesByBarcode) {
        this.display = display;
        this.pricesByBarcode = pricesByBarcode;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.setText("Scanning error: empty barcode!");
        } else{
            if (pricesByBarcode.containsKey(barcode)) {
                display.setText(pricesByBarcode.get(barcode));
            } else {
                display.setText("Product not found for " +
                        barcode);
            }
        }
    }
}
