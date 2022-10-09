package sshukla.java.custom.arraylist;

import java.util.ArrayList;

/**
 * @author 'Seemant Shukla' on '09/10/2022'
 */
public class CustomArrayListWithoutDuplicates extends ArrayList {

    @Override
    public boolean add(Object inputObject) {
        if(this.contains(inputObject)){
//            throw new RuntimeException("Duplicate Elements!!!");
            return true;
        }
        return super.add(inputObject);
    }
}
