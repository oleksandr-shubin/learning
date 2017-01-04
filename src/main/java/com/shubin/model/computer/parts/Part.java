package com.shubin.model.computer.parts;

public class Part {
    private int partId;
    private PartType type;
    private String info;
    private int price;
    private int amount;

    public Part() {
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }


    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId=" + partId +
                ", type=" + type +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
