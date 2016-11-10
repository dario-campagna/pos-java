package it.esteco.pos;

public class Display {
    private String text;

    public String getText() {
        return this.text;
    }

    public void displayEmptyBarcodeErrorMessage() {
        this.text = "Scanning error: empty barcode!";
    }

    public void displayProductNotFoundMessage(String barcode) {
        this.text = "Product not found for " + barcode;
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
    }
}
