package com.abc.marilyzj.beans;

import java.util.List;

/**
 * Created by acer on 2017/5/2.
 */

public class HomeListBean extends StatusBean {


    private List<ObjBean> obj;

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * repairItemsId : 1
         * repairName : 常规保养
         */

        private String repairItemsId;
        private String repairName;

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
    }
}
