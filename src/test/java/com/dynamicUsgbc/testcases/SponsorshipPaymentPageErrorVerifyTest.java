package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodSponsorship;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class SponsorshipPaymentPageErrorVerifyTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"SponsorshipSheet","PaymentSheet", "SignInSheet"})
	public void SponsorshipPaymentPageErrorVerify(int rowNum, String sponsorshipSheet,String paymentSheet, String SignInSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("SponsorshipPaymentPageErrorVerify Test", "Verifies Online sponsorship Functionality").assignCategory("CheckSponsorship");
		CommonMethod.setUrl(SponsorshipUrl);
		
		ReusableMethodSponsorship reuse = new ReusableMethodSponsorship();
		ReusableMethodPayment reusePay = new ReusableMethodPayment();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		
		
		try {
			
			reuse.Sponsorship(rowNum, sponsorshipSheet);
			reuseSign.SignIn(rowNum, SignInSheet);
			reusePay.CommunityRegistrationPaymentPageErrorMessageVerify();
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("SponsorshipPaymentPageErrorVerify");
			throw e1;
		}
	}
}