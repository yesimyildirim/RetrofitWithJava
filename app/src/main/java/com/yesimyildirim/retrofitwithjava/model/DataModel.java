package com.yesimyildirim.retrofitwithjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {


        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }
}
