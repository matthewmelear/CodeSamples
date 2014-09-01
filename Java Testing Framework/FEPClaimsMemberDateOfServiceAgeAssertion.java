package com.cambiahealth.test.ahs.assertion.fep;

import com.cambiahealth.test.ahs.annotation.DefaultConnection;
import com.cambiahealth.test.ahs.annotation.TargetConnection;
import com.cambiahealth.test.ahs.connection.ConnectionType;
import com.cambiahealth.test.ahs.service.BasicDatabaseService;
import com.cambiahealth.test.ahs.service.RowCompareService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by r627023 on 6/17/2014.
 */
@Component
public class FEPClaimsMemberDateOfServiceAgeAssertion {
    public static final String CLAIM_TABLE = "CLM_MED_DETL";
    public static final String MBR_DT_OF_SVC_AGE_COLUMN = "MBR_DT_OF_SVC_AGE";
    public static final String MBR_BRTH_DT_COLUMN = "MBR_BRTH_DT";
    public static final String CLM_LN_SVC_FROM_DT_COLUMN = "CLM_LN_SVC_FROM_DT";

    @Resource
    @TargetConnection(ConnectionType.DESTINATION)
    private BasicDatabaseService dbService;

    @Resource
    private RowCompareService rowCompareService;



    @Transactional
    @DefaultConnection(value = {"etlSource", "etlTarget"}, type = {ConnectionType.SOURCE, ConnectionType.DESTINATION})
    public FEPClaimsMemberDateOfServiceAgeResults incorrectlyCalculatedMbrDtOfSvcAgeValues() {
        final String destSql = "SELECT DISTINCT CONCAT(CONCAT(Trim(Both ' ' FROM FEP_CLM_NUM), Trim(Both ' ' FROM FEP_TRANS_ID)), Trim(Both ' ' FROM CLM_LN_SEQ_NUM)) AS ID_COLUMN, MBR_DT_OF_SVC_AGE, " +
                "CLM_MED_DETL_ID FROM CLM_MED_DETL WHERE CLM_SRC_CD = 'FEP' ORDER BY ID_COLUMN ASC";

        final String sourceSql = "SELECT * FROM (" +
                "SELECT CONCAT(CONCAT(Trim(Both ' ' FROM CLAIM_NUMBER_SHBR),Trim(Both ' ' FROM TRANSACTION_ID_SHBR)),REGEXP_REPLACE(FAC_LINE_NUMBER_M1,'^0+','')) AS ID_COLUMN, " +
                "Floor(Months_Between(FAC_SERVICE_BEGIN_DATE_M1, CLAIM_BIRTH_DATE_M1)/12) AS CALCULATED_AGE FROM M1_RESPONSE_FACILITY_CLAIM " +
                "UNION " +
                "SELECT CONCAT(CONCAT(Trim(Both ' ' FROM CLAIM_NUMBER_SHBR),Trim(Both ' ' FROM TRANSACTION_ID_SHBR)),REGEXP_REPLACE(PROF_LINE_NUMBER_M1,'^0+', '')) AS ID_COLUMN, " +
                "Floor(Months_Between(PROF_SERVICE_BEGIN_DATE_M1, CLAIM_BIRTH_DATE_M1)/12) AS Calculated_Age FROM M1_RESPONSE_PROFESSIONAL_CLAIM)" +
                "ORDER BY ID_COLUMN ASC";

        final FEPClaimsMemberDateOfServiceAgeResults results = new FEPClaimsMemberDateOfServiceAgeResults();
        if (isSane(results)){
            final Set<String> DEST_COLUMNS = new HashSet <String>(1);
            final List<String> DEST_COLUMNS_LIST = new ArrayList<String>(1);
            {
                DEST_COLUMNS_LIST.add("MBR_DT_OF_SVC_AGE");
                DEST_COLUMNS.addAll(DEST_COLUMNS_LIST);
            }
            final List<String> SOURCE_COLUMNS = new ArrayList<String>(1);
            {
                SOURCE_COLUMNS.add("CALCULATED_AGE");
            }

            FEPClaimsMemberDateOfServiceAgeCallback callback = new FEPClaimsMemberDateOfServiceAgeCallback(results);
            results.processRowStatus(rowCompareService.compareRowsUsingSQL(sourceSql, destSql, SOURCE_COLUMNS, DEST_COLUMNS_LIST, callback));
        }
        return results;
    }

    public boolean isSane(FEPClaimsMemberDateOfServiceAgeResults results){
        if(dbService.tableExists(CLAIM_TABLE) && dbService.columnExistsInTable(CLAIM_TABLE, CLM_LN_SVC_FROM_DT_COLUMN) &&
                dbService.columnExistsInTable(CLAIM_TABLE, MBR_BRTH_DT_COLUMN) && dbService.columnExistsInTable(CLAIM_TABLE, MBR_DT_OF_SVC_AGE_COLUMN)){
            results.setEnvironmentExists(true);
        } else {
            results.setEnvironmentExists(false);
        }
        return results.getEnvironmentExists();
    }
}
