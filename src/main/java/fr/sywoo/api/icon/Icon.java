package fr.sywoo.api.icon;

public class Icon {

    private String currentIcon;
    private String currentColor;
    private String material;

    public Icon(String currentIcon, String currentColor){
        this.currentIcon = currentIcon;
        this.currentColor = currentColor;
    }

    public String getMaterial() {
        return material;
    }

    public Icon setMaterial(String material) {
        this.material = material;
        return this;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public String getCurrentIcon() {
        return currentIcon;
    }

    public Icon setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
        return this;
    }

    public Icon setCurrentIcon(String currentIcon) {
        this.currentIcon = currentIcon;
        return this;
    }
}
