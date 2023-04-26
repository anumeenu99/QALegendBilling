package com.qalegendbilling.dataprovider;


import org.testng.annotations.DataProvider;

import com.qalegendbilling.utilities.ExcelUtility;
public class DataProviders {
	ExcelUtility excel=new ExcelUtility();
    @DataProvider(name="InvalidUserCredentials")
    public Object[][] InvalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }
}
