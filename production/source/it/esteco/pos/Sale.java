package it.esteco.pos;

public class Sale {

    private Display display;
    private Catalog catalog;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        // Smell: REFUSED BEQUEST
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeErrorMessage();
            return;
        }
        String priceAsText = catalog.findPrice(barcode);
        if (priceAsText != null) {
            display.displayPrice(priceAsText);
        } else {
            display.displayProductNotFoundMessage(barcode);
        }
    }

}
