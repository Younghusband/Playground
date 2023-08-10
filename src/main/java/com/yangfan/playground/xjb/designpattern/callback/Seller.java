package com.yangfan.playground.xjb.designpattern.callback;


import lombok.Data;

@Data
public class Seller {
    
    public class SellerCustomer implements DoJob {

        @Override
        public void fillBlank(int result, int [] params) {
            System.out.println(String.format("%s 算出了这个账大概要多少钱", result));
        }
        
    }
    
    private String name;
    public Seller(String name) {
        this.name = name;
    }
    public void callKidHelp(int ...prices) {
        new Calculator().call(new SellerCustomer(), prices);
    }
    
}
