package configuration;

public enum MetaDane {
    SLABE_KOSCI("SLABE_KOSCI"),
    MOCNE_KOSCI("MOCNE_KOSCI");

    private String napis;

    MetaDane(String inputInt) {
        this.napis = inputInt;
    }

    public String getNapis() {
        return napis;
    }
}
