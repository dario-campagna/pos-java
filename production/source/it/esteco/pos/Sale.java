package it.esteco.pos;

import java.util.Map;

public class Sale {

    private Display display;
    private final Map<String, String> pricesByBarcode;

    public Sale(Display display, Map<String, String> pricesByBarcode) {
        this.display = display;
        this.pricesByBarcode = pricesByBarcode;
    }

    public void onBarcode(String barcode) {
        // Smell: REFUSED BEQUEST
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeErrorMessage();
            return;
        }
        String priceAsText = findPrice(barcode);
        if (priceAsText != null) {
            display.displayPrice(priceAsText);
        } else {
            display.displayProductNotFoundMessage(barcode);
        }
    }

    private String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

}
