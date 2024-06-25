package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductImgBtn;

}
