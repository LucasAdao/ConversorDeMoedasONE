package dev.lucas.models;

import com.google.gson.annotations.SerializedName;

public class MoedasPropriedades {
    @SerializedName("timestamp")
    private int timestamp;
    @SerializedName("price")
    private Double valor;

    public int getTimestamp() {
        return timestamp;
    }

    public Double getValor() {
        return valor;
    }
}
