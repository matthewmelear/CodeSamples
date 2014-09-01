package com.cambiahealth.test.ahs.fixture.fep;

import com.cambiahealth.test.ahs.assertion.fep.FEPClaimsMemberDateOfServiceAgeAssertion;
import com.cambiahealth.test.ahs.assertion.fep.FEPClaimsMemberDateOfServiceAgeResults;
import com.cambiahealth.test.ahs.connection.ConnectionType;
import com.cambiahealth.test.ahs.connection.DataIntentions;
import com.cambiahealth.test.ahs.fixture.SpringFixture;
import com.cambiahealth.test.ahs.service.fep.FEPMemberDateOfServiceAgeHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static util.ListUtility.list;


@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class FEPClaimsMemberDateOfServiceAge extends SpringFixture {

    @Autowired
    private DataIntentions intentions;

    @Autowired
    private FEPClaimsMemberDateOfServiceAgeAssertion assertion;

    public FEPClaimsMemberDateOfServiceAge(final String sourceConnection, final String destinationConnection){
        intentions.setTargetFor(ConnectionType.SOURCE, sourceConnection);
        intentions.setTargetFor(ConnectionType.DESTINATION, destinationConnection);
    }

    public List doTable(List<List<String>> table){
        FEPClaimsMemberDateOfServiceAgeResults results = assertion.incorrectlyCalculatedMbrDtOfSvcAgeValues();
        return processResults(table, results);
    }

    private List processResults(List<List<String>> table, FEPClaimsMemberDateOfServiceAgeResults results) {
        List<List<String>> returnTable = table;
        int rowCount = 0;
        if (results.getEnvironmentExists()) {
            if (results.getListOfIncorrectValues().size() != 0) {
                List<String> errorHeaders = new ArrayList<String>(3);
                errorHeaders.add("Record with the Key Value");
                errorHeaders.add("Should have been");
                errorHeaders.add("But was");
                returnTable.add(errorHeaders);
                for (FEPMemberDateOfServiceAgeHelper row : results.getListOfIncorrectValues()) {
                    List<String> currentFailedAssertion = new ArrayList<String>();
                    currentFailedAssertion.add(row.getKeyValue());
                    currentFailedAssertion.add(row.getCalculatedAge().toString());
                    currentFailedAssertion.add(row.getMbrDtOfSvcAge().toString());
                    returnTable.add(currentFailedAssertion);
                    rowCount++;
                    if (rowCount == 5) {
                        returnTable.add(list("There were " + results.getListOfIncorrectValues().size() + " incorrectly calculated values total"));
                        break;
                    }
                }
            } else {
                returnTable = list(list("","","pass"));
            }
        } else {
            returnTable = list(list("Unable to find table/columns", "", "fail"));
        }
        return returnTable;
    }
}
