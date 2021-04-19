import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class assigment {


    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Hasitha\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.theathletesfoot.com.au/");
        driver.manage().window().maximize();

        //Click on user icon
        WebElement userIconButton = driver.findElement(By.xpath("//a[@href='https://www.theathletesfoot.com.au/customer/account/login/']"));

        userIconButton.click();

        //Verify My Account page ex: Login button exists or not

        if (driver.findElements(By.xpath("//button[@id='send2']")).size() >0){
            System.out.println("Login button is displayed");
        }
        else{
            System.out.println("Login button is not displayed");
        }



        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='send2']"));

        //empty field validation
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Boolean emailFieldErrorMessage = driver.findElement(By.xpath("//div[@id='email-error']")).isDisplayed();
        Boolean passwordFieldErrorMessage = driver.findElement(By.xpath("//div[@id='pass-error']")).isDisplayed();

        if (emailFieldErrorMessage && passwordFieldErrorMessage){
            System.out.println("Empty field validation is added");
        }
        else {
            System.out.println("Empty field validation is not added");
        }

        //email format validation

        emailTextBox.sendKeys("williamjacob802.com");
        passwordTextBox.sendKeys("Abc123$$");
        submitButton.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if (emailFieldErrorMessage && passwordFieldErrorMessage){
            System.out.println("format validation is added");
        }
        else {
            System.out.println("format validation is not added");
        }

        emailTextBox.clear();
        passwordTextBox.clear();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //signing in

        //emailTextBox.sendKeys("williamjacob802@gmail.com");
        emailTextBox.sendKeys("hasithaofficial@gmail.com");
        passwordTextBox.sendKeys("Abc123$$");
        submitButton.click();

        //4. Verify My account user name: ‘william jacob’

        String userName = driver.findElement(By.xpath("//div[@class='box box-information']/div/p")).getAttribute("innerText").split("\n")[0];

        System.out.println(userName);
        if (userName.equals("Hasitha Sanujaya")){
            System.out.println("My account user name is correct");
        }
        else
            System.out.println("user name is wrong");


        //get cart quntity
        String cartQuantity= driver.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span")).getAttribute("class");

        //Get the item count
        String cartQuantityCount = driver.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']/span")).getText();


        System.out.println(cartQuantity);
        System.out.println("Cart quantity = "+cartQuantityCount);

        if (cartQuantity.equals("counter qty empty") ) {
            System.out.println("Cart is empty");
        }
        else {
            System.out.println("cart is not empty");
            //Open shopping cart
            WebElement shoppingCartIcon = driver.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']"));
            shoppingCartIcon.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Thread.sleep(5000);
            int i = Integer.parseInt(cartQuantityCount);

            while (i >0){

                //Remove items from cart
                WebElement shoppingItem = driver.findElement(By.xpath("//a[@title='Remove item'][last()]"));
                shoppingItem.click();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                Thread.sleep(5000);
                driver.findElement(By.xpath("//button[contains(@class,'accept')]")).click();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                Thread.sleep(5000);
                i--;
            }

            //close shopping cart
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement shoppingCartIcon1 = driver.findElement(By.xpath("//header/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", shoppingCartIcon1);

        }

        //open category section dropdown(Kids)
        WebElement mainCategory = driver.findElement(By.xpath("//span[@id='mi-1-3']"));
        Actions action = new Actions(driver);
        action.moveToElement(mainCategory).perform();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //select subcategory(Run)

        WebElement subCategory = driver.findElement(By.xpath("//a[@href='https://www.theathletesfoot.com.au/kids/kids-run.html']"));
        subCategory.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement selectItem;
        String title;
        int priceBox;

        do {
            //Generate random number
            Random random = new Random();
            int randomInt = 0;
            while (randomInt<=0)
                randomInt = random.nextInt(50);

            System.out.println("random number = "+ randomInt);

            //Select random item
            selectItem = driver.findElement(By.xpath("(//img[@class='product-image-photo'])["+randomInt+"]") );
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            title = selectItem.getAttribute("title");
            System.out.println("Title = "+title);

            // Verify the item is available

            priceBox = driver.findElements(By.xpath("//a[@title='"+title+"']/parent::strong/parent::div/div")).size();

        }
        while(priceBox<1);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        selectItem.click();

        Thread.sleep(5000);



        //select 1st avialable size

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (title.contains("(PS)")){
            WebElement selectSizeOption1 = driver.findElement(By.xpath("//div[@id='swatch-row-276']//div[@class='swatch-option text'][1]"));
            selectSizeOption1.click();
        }
        else {
            WebElement selectSizeOption2 = driver.findElement(By.xpath("//div[@id='swatch-row-277']//div[@class='swatch-option text'][1]"));
            selectSizeOption2.click();
        }
        Thread.sleep(5000);

        //Click add to cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
        addToCartButton.click();

        Thread.sleep(5000);

        //view shopping cart
        WebElement shoppingCartIcon = driver.findElement(By.xpath("//span[@class='showcart-trigger header-sidebar-link -cart']"));
        shoppingCartIcon.click();
        Thread.sleep(5000);

        //9. Go to cart and verify item price and name

        //navigate to View Cart
        WebElement viewCart = driver.findElement(By.xpath("//a[@href='https://www.theathletesfoot.com.au/checkout/cart/']"));
        viewCart.click();

        String itemName = driver.findElement(By.xpath("(//div[@class='item-details']//strong//a)[1]")).getText();
        String itemPrice = driver.findElement(By.xpath("(//tbody[@class='cart item']//tr//td//span//span[@class='price'])[1]")).getText();

        System.out.println("Item Name = "+itemName);
        System.out.println("Item Price = "+itemPrice);


        //Verify First and last name in checkout page
        WebElement processToCheckout = driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
        processToCheckout.click();

        WebElement firstName = driver.findElement(By.xpath("//div[@name='shippingAddress.firstname']//div//input"));
        WebElement lastName = driver.findElement(By.xpath("//div[@name='shippingAddress.lastname']//div//input"));

        String firstNameValue = firstName.getAttribute("value");
        String lastNameValue = lastName.getAttribute("value");

        System.out.println("First Name = "+firstNameValue);
        System.out.println("Last Name = "+lastNameValue);

        if (firstNameValue.equals("Hasitha") && lastNameValue.equals("Sanujaya") ){
            System.out.println("First name and Last name are correct");
        }

        else {
            System.out.println("First name and Last name are incorrect");
        }

        //11. Validate Continue button function without adding mandatory values
        WebElement continueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
        continueButton.click();

        boolean addressMandatoryErrorMessage = driver.findElement(By.xpath("(//div[@class='field-error mage-error']/span)[1]")).isDisplayed();
        boolean suburbMandatoryErrorMessage = driver.findElement(By.xpath("(//div[@class='field-error mage-error']/span)[2]")).isDisplayed();
        boolean stateMandatoryErrorMessage = driver.findElement(By.xpath("(//div[@class='field-error mage-error']/span)[3]")).isDisplayed();
        boolean postcodeMandatoryErrorMessage = driver.findElement(By.xpath("(//div[@class='field-error mage-error']/span)[4]")).isDisplayed();
        boolean phonenumberMandatoryErrorMessage = driver.findElement(By.xpath("(//div[@class='field-error mage-error']/span)[5]")).isDisplayed();

        if (addressMandatoryErrorMessage && suburbMandatoryErrorMessage && stateMandatoryErrorMessage && postcodeMandatoryErrorMessage && phonenumberMandatoryErrorMessage){
            System.out.println("Mandatory field validation is added in Checkout page");
        }
        else{
            System.out.println("Mandatory field validation is not added in Checkout page");
        }


        //Add mandatory fields
        //Address
        WebElement address = driver.findElement(By.xpath("//div[@name='shippingAddress.street.0']/div/input"));
        address.sendKeys("61  Grandis Road");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //postcode
        WebElement postCode = driver.findElement(By.xpath("//div[@name='shippingAddress.postcode']/div/input"));
        postCode.sendKeys("2000");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@name='shippingAddress.postcode']/div/input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//div[@name='shippingAddress.postcode']/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        //phone number
        WebElement phoneNumber = driver.findElement(By.xpath("(//input[@placeholder='0XXX XXX XXX'])[1]"));
        phoneNumber.sendKeys("075456123");

        Thread.sleep(5000);

        //13.Validate Delivery options if available

        Select deliveryDropdown = new Select (driver.findElement(By.xpath("//select[@name='delivery_notes']")));
        List<WebElement> dropdownValues = deliveryDropdown.getOptions();

        if (dropdownValues.size() > 0)
            System.out.println("Delivery options are available");
        else
            System.out.println("Delivery options are not available");

        deliveryDropdown.selectByValue("Leave near front door");


        Thread.sleep(5000);

        //Click on continue button

        continueButton.click();

        //select cc as payment method


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ccRadioButton = driver.findElement(By.xpath("//label[@for='braintree']"));

        ccRadioButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        // CC mndatory field validation
        //cc number field mndatory validation
        WebElement placeOrder = driver.findElement(By.xpath("//div[@class='opc-submit-step']//button[@title='Place Order']"));
        placeOrder.click();

        Thread.sleep(5000);

        Boolean creditCardNumberValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[1]")).isDisplayed();

        //expire date field mndatory validation
        WebElement creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.sendKeys("5500 0000 0000 0004");
        driver.switchTo().defaultContent();

        placeOrder.click();
        Thread.sleep(5000);

        Boolean expireDateValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[2]")).isDisplayed();

        //CCV field mndatory validation

        creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.sendKeys("5500 0000 0000 0004");
        driver.switchTo().defaultContent();

        WebElement expireDate = driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(By.xpath("//input[@id='expiration']"));
        expireDate.sendKeys("10/2024");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        placeOrder.click();

        Boolean ccvCodeValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[3]")).isDisplayed();

        System.out.println(creditCardNumberValidation +" , " +expireDateValidation +" , "+ ccvCodeValidation);

        if (creditCardNumberValidation && expireDateValidation && ccvCodeValidation)
            System.out.println("CC mandatory validation error message is added");
        else
            System.out.println("CC mandatory validation error message is not added");



        // CC field format validation

        //cc number field format validation
        creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.clear();
        creditCardNumber.sendKeys("5500");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        placeOrder.click();

        creditCardNumberValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[1]")).isDisplayed();

        //expire date field format validation

        creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.clear();
        creditCardNumber.sendKeys("5500 0000 0000 0004");
        driver.switchTo().defaultContent();


        expireDate = driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(By.xpath("//input[@id='expiration']"));
        expireDate.clear();
        expireDate.sendKeys("10/3030");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        placeOrder.click();

        expireDateValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[2]")).isDisplayed();

        //ccv field format validation

        creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.clear();
        creditCardNumber.sendKeys("5500 0000 0000 0004");
        driver.switchTo().defaultContent();

        Thread.sleep(5000);

        expireDate = driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(By.xpath("//input[@id='expiration']"));
        expireDate.clear();
        expireDate.sendKeys("10/2024");
        driver.switchTo().defaultContent();

        Thread.sleep(5000);


        WebElement ccvCode = driver.switchTo().frame("braintree-hosted-field-cvv").findElement(By.xpath("//input[@id='cvv']"));
        ccvCode.sendKeys("1");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        placeOrder.click();

        ccvCodeValidation  = driver.findElement(By.xpath("(//div[@class='hosted-error'])[3]")).isDisplayed();

        Thread.sleep(5000);

        System.out.println(creditCardNumberValidation +" , " +expireDateValidation +" , "+ ccvCodeValidation);

        if (creditCardNumberValidation && expireDateValidation && ccvCodeValidation)
            System.out.println("CC format validation error message is added");
        else
            System.out.println("CC format validation error message is not added");



        //enter valid CC number

        creditCardNumber = driver.switchTo().frame("braintree-hosted-field-number").findElement(By.xpath("//input[@id='credit-card-number']"));
        creditCardNumber.clear();
        creditCardNumber.sendKeys("5500 0000 0000 0004");
        driver.switchTo().defaultContent();

        Thread.sleep(5000);

        //enter expire date

        expireDate = driver.switchTo().frame("braintree-hosted-field-expirationDate").findElement(By.xpath("//input[@id='expiration']"));
        expireDate.clear();
        expireDate.sendKeys("10/2024");
        driver.switchTo().defaultContent();

        Thread.sleep(5000);

        //enter CCV
        ccvCode = driver.switchTo().frame("braintree-hosted-field-cvv").findElement(By.xpath("//input[@id='cvv']"));
        ccvCode.clear();
        ccvCode.sendKeys("123");
        driver.switchTo().defaultContent();

        Thread.sleep(5000);


        driver.quit();


    }



}
