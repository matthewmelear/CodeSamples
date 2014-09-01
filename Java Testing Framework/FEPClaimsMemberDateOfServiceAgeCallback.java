package com.cambiahealth.test.ahs.assertion.fep;

import com.cambiahealth.test.ahs.service.IRowCompareCallback;
import com.cambiahealth.test.ahs.service.fep.FEPMemberDateOfServiceAgeHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by r627023 on 6/18/2014.
 */
public class FEPClaimsMemberDateOfServiceAgeCallback implements IRowCompareCallback {

    private FEPClaimsMemberDateOfServiceAgeResults results;
    private Integer numberOfFailedAssertions = 0;
    private Exception exception;
    private String exhaustedKey;


    public FEPClaimsMemberDateOfServiceAgeCallback(FEPClaimsMemberDateOfServiceAgeResults results) {
        this.results = results;

    }

    @Override
    public boolean compare(String key, Map<String, Object> sourceData, Map<String, Object> destinationData) {
        BigDecimal mbrDateOfSvcAge = (BigDecimal) destinationData.get("MBR_DT_OF_SVC_AGE");
        BigDecimal calculatedAge = (BigDecimal) sourceData.get("CALCULATED_AGE");

        if (!calculatedAge.equals(mbrDateOfSvcAge)){
            this.setNumberOfFailedAssertions(this.getNumberOfFailedAssertions() + 1);
            results.setStatus(FEPClaimsMemberDateOfServiceAgeResultType.FAILED_ASSERTIONS);
            if (results.getListOfIncorrectValues() != null) {
                results.getListOfIncorrectValues().add(new FEPMemberDateOfServiceAgeHelper(key, calculatedAge, mbrDateOfSvcAge));
            } else {
                List<FEPMemberDateOfServiceAgeHelper> incorrectValue = new ArrayList<FEPMemberDateOfServiceAgeHelper>();
                incorrectValue.add(new FEPMemberDateOfServiceAgeHelper(key, calculatedAge, mbrDateOfSvcAge));
                results.setListOfIncorrectValues(incorrectValue);
            }
        }
        return true;
    }

    @Override
    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public void setExhaustedKey(String key) {
        this.exhaustedKey = exhaustedKey;
    }


    public Integer getNumberOfFailedAssertions() {
        return numberOfFailedAssertions;
    }

    public void setNumberOfFailedAssertions(Integer numberOfFailedAssertions) {
        this.numberOfFailedAssertions = numberOfFailedAssertions;
    }
}