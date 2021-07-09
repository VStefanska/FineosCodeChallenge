package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Role {

    String SALES_TEAM = "Sales Team";
    String CUSTOMER = "Customer";
    List<String> roles = new ArrayList<>(Arrays.asList(SALES_TEAM, CUSTOMER));

}
