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
        String priceAsText = findPrice(barcode);
        if (priceAsText != null) {
            displayPrice(priceAsText);
        } else {
            displayProductNotFoundMessage(barcode);
        }
    }

    private String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    private void displayPrice(String priceAsText) {
        display.setText(priceAsText);
    }

    private void displayProductNotFoundMessage(String barcode) {
        display.setText("Product not found for " + barcode);
    }

    private void displayEmptyBarcodeErrorMessage() {
        display.setText("Scanning error: empty barcode!");
    }
}
