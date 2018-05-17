package com.bao.tao.base.m;

public class Result {

        @Override
        public String toString() {
                return "Result{" +
                        "province='" + province + '\'' +
                        ", city='" + city + '\'' +
                        ", areacode='" + areacode + '\'' +
                        ", zip='" + zip + '\'' +
                        ", company='" + company + '\'' +
                        ", card='" + card + '\'' +
                        '}';
        }

        public String province;

        public String city;

        public String areacode;

        public String zip;

        public String company;

        public String card;
    }