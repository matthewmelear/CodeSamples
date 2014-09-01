package com.cambiahealth.test.ahs.assertion.fep;

import com.cambiahealth.test.ahs.service.RowCompareStatus;
import com.cambiahealth.test.ahs.service.fep.FEPMemberDateOfServiceAgeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r627023 on 6/18/2014.
 */
public class FEPClaimsMemberDateOfServiceAgeResults {
    private List<FEPMemberDateOfServiceAgeHelper> listOfIncorrectValues = new ArrayList<FEPMemberDateOfServiceAgeHelper>();
    private FEPClaimsMemberDateOfServiceAgeResultType status = FEPClaimsMemberDateOfServiceAgeResultType.SUCCESS;
    private boolean environmentExists;
    private Exception exception;
    private String exhaustedKey;


    public void processRowStatus(RowCompareStatus rowCompareStatus) {
        switch (rowCompareStatus) {
            case NO_SOURCE_ROWS:
                status = FEPClaimsMemberDateOfServiceAgeResultType.NO_SOURCE_ROWS;
                break;
            case NO_DESTINATION_ROWS:
                status = FEPClaimsMemberDateOfServiceAgeResultType.NO_DESTINATION_ROWS;
                break;
            case SQL_EXCEPTION:
                status = FEPClaimsMemberDateOfServiceAgeResultType.ERRORS;
                break;
        }
    }

    public List<FEPMemberDateOfServiceAgeHelper> getListOfIncorrectValues(){
        return listOfIncorrectValues;
    }

    public void setListOfIncorrectValues(List<FEPMemberDateOfServiceAgeHelper> listOfIncorrectValues) {
        this.listOfIncorrectValues = listOfIncorrectValues;
    }

    public boolean getEnvironmentExists() {
        return environmentExists;
    }

    public void setEnvironmentExists(boolean environmentExists) {
        this.environmentExists = environmentExists;
    }

    public FEPClaimsMemberDateOfServiceAgeResultType getStatus() {
        return status;
    }

    public void setStatus(FEPClaimsMemberDateOfServiceAgeResultType status) {
        this.status = status;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public String getExhaustedKey() {
        return exhaustedKey;
    }

    public void setExhaustedKey(String exhaustedKey) {
        this.exhaustedKey = exhaustedKey;
    }
}
