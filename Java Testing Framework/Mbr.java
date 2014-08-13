package com.cambiahealth.test.ahs.support.acors;

import com.cambiahealth.test.ahs.support.Support;
import com.cambiahealth.test.ahs.support.SupportRegistry;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by r627023 on 7/24/2014.
 */

@Component
public class CoreAttrbnResltPmpm extends Support{

    public static final String TABLE = "CORE_ATTRBN_RESLT_PMPM";
    private static final String PITC_RESULTS = "PITC_RESULTS";

    public CoreAttrbnResltPmpm () {
        super(SupportRegistry.NA_CONNECTION, TABLE);
    }

    protected String latestAttributionResultRecordGroupByMbrIdQuery(){
        //Find latest record per MBR_ID as defined by maximum ELIGTY_MO_YYYYMM
        //TODO: Support for support class, would like to abstract this query to use any table and any max field
        String sql = "SELECT carp1.MBR_ID, CARP1.ELIGTY_MO_YYYYMM, carp1.NPI_TXT " +
                "FROM " + TABLE + " carp1 " +
                "JOIN (" +
                          "SELECT MBR_ID, max(ELIGTY_MO_YYYYMM) maxEligtyMo " +
                          "FROM " + TABLE + " GROUP BY MBR_ID" +
                      ") carp2 " +
                "ON carp2.maxEligtyMo = carp1.ELIGTY_MO_YYYYMM " +
                "AND carp2.MBR_ID = carp1.MBR_ID";
        return sql;
    }

    public String compareRows(Set<String> dataColumns, String reverseTableName){
        String sql = "";
        if (PITC_RESULTS.equals(reverseTableName)){
            Set<String> idColumns = new HashSet<String>();
            idColumns.add("CONCAT(trim(m.SUB_ID), CONCAT(mb.NDW_HOME_PLN_CD, CONCAT(mb.HOME_PLN_MBR_ID, CONCAT(TO_CHAR(TO_DATE(carp.ELIGTY_MO_YYYYMM, 'YYYYMM'),'YYYY-MM'), '-30')))) AS ID_COLUMN");

            for (String column: dataColumns){
                idColumns.add("carp." + column);
            }

            String idString = StringUtils.join(idColumns, ",");

            sql = "SELECT " + idString +
                " FROM MBR m " +
                " JOIN MBR_BCBSA mb ON m.MBR_ID = mb.MBR_ID " +
                " JOIN (" + latestAttributionResultRecordGroupByMbrIdQuery() + ") carp ON m.MBR_ID = carp.MBR_ID " +
                " ORDER BY ID_COLUMN ASC";
        return sql;
    }
        else {
            return super.compareRows(dataColumns, reverseTableName);
        }
    }
}