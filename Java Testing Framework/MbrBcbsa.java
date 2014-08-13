package com.cambiahealth.test.ahs.support.acors;

import com.cambiahealth.test.ahs.support.Support;
import com.cambiahealth.test.ahs.support.SupportRegistry;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MbrBcbsa extends Support {
    public static final String PITC_BCBSA_MBR = "BCBSA_PI_MBR_A";
    public static final String MBR_BCBSA = "MBR_BCBSA";
    public static final String PITC_RESULTS = "PITC_RESULTS";

    public MbrBcbsa() {
        super(SupportRegistry.NA_CONNECTION, MBR_BCBSA);
    }

    @Override
    public String compareRows(Set<String> dataColumns, String reverseTableName) {
        String sql = "";
        Set<String> idColumns = new HashSet<String>();

        if(PITC_BCBSA_MBR.equals(reverseTableName)) {
            idColumns.add("CONCAT(trim(SUB_ID),CONCAT(trim(HOME_PLN_MBR_ID),trim(NDW_HOME_PLN_CD))) AS ID_COLUMN");

            for(String column : dataColumns) {
                idColumns.add(column);
            }

            String idString = StringUtils.join(idColumns, ",");
            sql = "SELECT " + idString + " FROM MBR_BCBSA PI JOIN MBR ON MBR.MBR_ID = PI.MBR_ID WHERE SRC_CD = 'PITC' ORDER BY ID_COLUMN ASC";
            return sql;
        } else if (PITC_RESULTS.equals(reverseTableName)){
            CoreAttrbnResltPmpm carp = new CoreAttrbnResltPmpm();
            idColumns.add("CONCAT(trim(m.SUB_ID), CONCAT(mb.NDW_HOME_PLN_CD, CONCAT(mb.HOME_PLN_MBR_ID, CONCAT(TO_CHAR(TO_DATE(carp.ELIGTY_MO_YYYYMM, 'YYYYMM'),'YYYY-MM'), '-30')))) AS ID_COLUMN");

            for (String column : dataColumns){
                idColumns.add("mb." + column);
            }

            String idString = StringUtils.join(idColumns, ",");

            sql = "SELECT " + idString +
                 " FROM MBR m " +
                 " JOIN MBR_BCBSA mb ON m.MBR_ID = mb.MBR_ID " +
                 " JOIN (" + carp.latestAttributionResultRecordGroupByMbrIdQuery() + ") carp ON m.MBR_ID = carp.MBR_ID " +
                 " ORDER BY ID_COLUMN ASC";

            return sql;
        } else {
            return super.compareRows(dataColumns, reverseTableName);
        }
    }
}
