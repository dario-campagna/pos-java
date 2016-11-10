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
            displayEmptyBarcodeErrorMessage();
            return;
        }
        if (pricesByBarcode.containsKey(barcode)) {
            findPriceAndDisplayAsText(barcode);
        } else {
            displayProductNotFoundMessage(barcode);
        }
    }

    private void findPriceAndDisplayAsText(String barcode) {
        String priceAsText = pricesByBarcode.get(barcode);
        display.setText(priceAsText);
    }

    private void displayProductNotFoundMessage(String barcode) {
        display.setText("Product not found for " + barcode);
    }

    private void displayEmptyBarcodeErrorMessage() {
        display.setText("Scanning error: empty barcode!");
    }
}
