package com.mphasis.main.cui;

import com.mphasis.contracts.sailor;
import com.mphasis.entities.helicopter;
import com.mphasis.entities.riverBarage;
import com.mphasis.entities.seaplane;
import com.mphasis.contracts.flyer;
public class Main {

    public static void main(String[] args){
        Main bostonharbor = new Main();
        riverBarage barage =  new riverBarage();
        seaplane sPlane = new seaplane();
        bostonharbor.givePermissionToDock( barage);
        bostonharbor.givePermissionToDock(sPlane);
    }
    private void  givePermissionToDock(sailor s){
        s.dock();
    }
}
