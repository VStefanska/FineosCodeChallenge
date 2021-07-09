package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Customer {

    String COMPANY_AAA = "Company AAA";
    String COMPANY_BBB = "Company BBB";
    List<String> companies = new ArrayList<>(Arrays.asList(COMPANY_AAA, COMPANY_BBB));

}
