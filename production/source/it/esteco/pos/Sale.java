package it.esteco.pos;

public class Sale {

    private Display display;

    public Sale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.setText("Scanning error: empty barcode!");
        } else{
            if ("12345".equals(barcode)) {
                display.setText("$7.95");
            } else if ("67890".equals(barcode)) {
                display.setText("$12.10");
            } else {
                display.setText("Product not found for " +
                        barcode);
            }
        }
    }
}
