/*
package com.example.test.tiNet.yewu;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Author ShineQi
 * @Date 2021/3/23 11:19
 *//*

public class RegionTest {
//    provinceAreacode
    public static final int[] 西北 = new int[]{29, 931, 971, 951, 991};

    public static final int[] 陕西 = new int[]{911, 912, 913};
    public static final int[] 甘肃 = new int[]{932, 933, 934,935};
    public static final int[] 青海 = new int[]{972,973};
    public static final int[] 宁夏 = new int[]{952,953,954};
    public static final int[] 新疆 = new int[]{992,993};


    public static final Integer[] 华北 = new Integer[]{10,22,311,351,471};

    public static final Integer[] 北京 = new Integer[]{};
    public static final int[] 天津 = new int[]{};
    public static final int[] 河北 = new int[]{312,313};
    public static final int[] 山西 = new int[]{349};
    public static final int[] 内蒙古 = new int[]{472,476,477};

//    cityAreacode


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer[]> provinceAreacodeList = new ArrayList<>();
        provinceAreacodeList.add(RegionTest.华北);
//        provinceAreacodeList.get(0)[0];
        String area = "19123";
        if(area.startsWith("12",0)){
            System.out.println("111是的true");
        }
        if(area.startsWith("19",0)){
            System.out.println("222是的true");
        }



    }

    package com.tinet.vnc.v3.utils;

import com.tinet.ccic.v3.core.utils.StringUtils;
import com.tinet.vnc.inc.Const;
import com.tinet.vnc.v3.service.TrunkPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

    */
/**
     * @Author ShineQi
     * @Date 2021/3/23 14:23
     *//*

    @Controller
    public class RegionAreacodeUtil {

        public static final String[] NORTH_CHINA_P = {"010","022","0311","0351","0471"};
        public static final String[] HEBEI = {"0312","0313","0314","0315","0316","0317","0318","0319","0310","0335"};


        @Autowired
        private TrunkPoolService trunkPoolService;

        public String getTelX(String vncAppId,String areacode,String telA,String telB,String serviceType) {
            if (StringUtils.isNotEmpty(areacode)) {
                if (!areacode.startsWith("0")) {
                    areacode = "0" + areacode;
                }
            }
            String telX = "";
            if (areacode.startsWith("031") || areacode.startsWith("035")) {
                for (int i = 0; i < RegionAreacodeUtil.HEBEI.length; i++) {
                    telX = trunkPoolService.getXNumberByAreaCodeAXB(vncAppId, RegionAreacodeUtil.HEBEI[i], telA, telB, Const.AXB_SERVICE_TYPE);
                    if (StringUtils.isNotEmpty(telX)) {
                        return telX;
                    }
                }

                if (StringUtils.isEmpty(telX)) {
                    for (int i = 0; i < RegionAreacodeUtil.NORTH_CHINA.length; i++) {
                        telX = trunkPoolService.getXNumberByAreaCodeAXB(vncAppId, RegionAreacodeUtil.NORTH_CHINA[i], telA, telB, Const.AXB_SERVICE_TYPE);
                        if (StringUtils.isNotEmpty(telX)) {
                            return telX;
                        }
                    }
                }
                if (StringUtils.isEmpty(telX)) {

                }

            }
            return telX;
        }

    }

}
*/
