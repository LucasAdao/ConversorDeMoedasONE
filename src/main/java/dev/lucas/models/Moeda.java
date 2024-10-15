package dev.lucas.models;

import com.google.gson.annotations.SerializedName;

public class Moeda {
    @SerializedName("BRL_USD")
    private MoedasPropriedades brlDlr;
    @SerializedName("BRL_EUR")
    private MoedasPropriedades brlEur;
    @SerializedName("BLR_JPY")
    private MoedasPropriedades brlJpy;
    @SerializedName("USD_BRL")
    private MoedasPropriedades dlrBrl;
    @SerializedName("USD_EUR")
    private MoedasPropriedades dlrEur;
    @SerializedName("USD_JPY")
    private MoedasPropriedades dlrJpy;

    public MoedasPropriedades getBrlDlr() {
        return brlDlr;
    }

    public MoedasPropriedades getBrlEur() {
        return brlEur;
    }

    public MoedasPropriedades getBrlJpy() {
        return brlJpy;
    }

    public MoedasPropriedades getDlrBrl() {
        return dlrBrl;
    }

    public MoedasPropriedades getDlrEur() {
        return dlrEur;
    }

    public MoedasPropriedades getDlrJpy() {
        return dlrJpy;
    }

}
