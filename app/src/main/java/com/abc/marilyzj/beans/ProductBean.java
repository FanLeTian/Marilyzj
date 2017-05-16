package com.abc.marilyzj.beans;

/**
 * Created by acer on 2017/5/16.
 */

public class ProductBean extends StatusBean {


    /**
     * obj : {"repairItems":{"repairItemsId":"3","repairName":"机修","price":"341"},"dept":{"deptId":"1","deptName":"陕西4s","deptAddress":"唐延路","deptPhone":"1101011","deptEmail":"1111@qq.com","deptDesc":"唐延路","deptLevel":3}}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * repairItems : {"repairItemsId":"3","repairName":"机修","price":"341"}
         * dept : {"deptId":"1","deptName":"陕西4s","deptAddress":"唐延路","deptPhone":"1101011","deptEmail":"1111@qq.com","deptDesc":"唐延路","deptLevel":3}
         */

        private RepairItemsBean repairItems;
        private DeptBean dept;

        public RepairItemsBean getRepairItems() {
            return repairItems;
        }

        public void setRepairItems(RepairItemsBean repairItems) {
            this.repairItems = repairItems;
        }

        public DeptBean getDept() {
            return dept;
        }

        public void setDept(DeptBean dept) {
            this.dept = dept;
        }

        public static class RepairItemsBean {
            /**
             * repairItemsId : 3
             * repairName : 机修
             * price : 341
             */

            private String repairItemsId;
            private String repairName;
            private String price;

            public String getRepairItemsId() {
                return repairItemsId;
            }

            public void setRepairItemsId(String repairItemsId) {
                this.repairItemsId = repairItemsId;
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
        }

        public static class DeptBean {
            /**
             * deptId : 1
             * deptName : 陕西4s
             * deptAddress : 唐延路
             * deptPhone : 1101011
             * deptEmail : 1111@qq.com
             * deptDesc : 唐延路
             * deptLevel : 3
             */

            private String deptId;
            private String deptName;
            private String deptAddress;
            private String deptPhone;
            private String deptEmail;
            private String deptDesc;
            private int deptLevel;

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public String getDeptAddress() {
                return deptAddress;
            }

            public void setDeptAddress(String deptAddress) {
                this.deptAddress = deptAddress;
            }

            public String getDeptPhone() {
                return deptPhone;
            }

            public void setDeptPhone(String deptPhone) {
                this.deptPhone = deptPhone;
            }

            public String getDeptEmail() {
                return deptEmail;
            }

            public void setDeptEmail(String deptEmail) {
                this.deptEmail = deptEmail;
            }

            public String getDeptDesc() {
                return deptDesc;
            }

            public void setDeptDesc(String deptDesc) {
                this.deptDesc = deptDesc;
            }

            public int getDeptLevel() {
                return deptLevel;
            }

            public void setDeptLevel(int deptLevel) {
                this.deptLevel = deptLevel;
            }
        }
    }
}
