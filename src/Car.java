public class Car {
    private Integer brand_id;
    private String model;
    private String color;
    private Integer yearOdProduction;
    private Double price;

    public Car(Integer brand_id, String model, String color, Integer yearOdProduction, Double price) {
        this.brand_id = brand_id;
        this.model = model;
        this.color = color;
        this.yearOdProduction = yearOdProduction;
        this.price = price;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYearOdProduction() {
        return yearOdProduction;
    }

    public void setYearOdProduction(Integer yearOdProduction) {
        this.yearOdProduction = yearOdProduction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}