package com.abc.marilyzj.beans;

import java.util.List;

/**
 * Created by acer on 2017/5/16.
 */

public class HomeBean extends StatusBean {


    /**
     * obj : {"reslut":[{"repairItemsId":"3","deptName":"西安4s","repairName":"机修","price":"341","deptId":"2"},{"repairItemsId":"2","deptName":"陕西4s","repairName":"大型保养","price":"3123","deptId":"1"}]}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        private List<ReslutBean> reslut;

        public List<ReslutBean> getReslut() {
            return reslut;
        }

        public void setReslut(List<ReslutBean> reslut) {
            this.reslut = reslut;
        }

        public static class ReslutBean {
            /**
             * repairItemsId : 3
             * deptName : 西安4s
             * repairName : 机修
             * price : 341
             * deptId : 2
             */

            private String repairItemsId;
            private String deptName;
            private String repairName;
            private String price;
            private String deptId;

            public String getRepairItemsId() {
                return repairItemsId;
            }

            public void setRepairItemsId(String repairItemsId) {
                this.repairItemsId = repairItemsId;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public String getRepairName() {
                return repairName;
            }

            public void setRepairName(String repairName) {
                this.repairName = repairName;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }
        }
    }
}

