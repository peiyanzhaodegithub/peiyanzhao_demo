package com.example.demo.testenum;

public enum TestEnum {

    TO_PAY("待付款",0){
        @Override
        public boolean deliver(){
            return false;
        }
    };


    private String name;
    private int val;

    /**
     * 	抽象方法：发货
     * @return
     */
    public abstract boolean deliver();


    /**
     * 	int转枚举
     * @param val
     * @return
     */
    public static TestEnum getOrderState(int val) {
        for (TestEnum orderState : TestEnum.values()) {
            if (orderState.val == val) {
                return orderState;
            }
        }
        throw new RuntimeException("错误的订单状态");
    }


    public String getName() {
        return name;
    }

    public int getVal() {
        return val;
    }

    TestEnum(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVal(int val) {
        this.val = val;
    }

    TestEnum() {
    }
}
