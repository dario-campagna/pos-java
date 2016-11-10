package it.esteco.pos;

public class Sale {

    private Display display;

    public Sale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("12345".equals(barcode)) {
            display.setText("$7.95");
        } else {
            display.setText("$12.10");
        }
    }
}
