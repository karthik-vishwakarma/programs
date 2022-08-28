package com.kk.structural.adaptor;

interface WebDriver {
    void getElement();

    void selectElement();
}

class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get element from Chrome Driver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from chrome Driver");
    }
}

class IEDriver {
    public void findElement() {
        System.out.println("Find element from IE Driver");
    }

    public void clickElement() {
        System.out.println("Click element from IE Driver");
    }
}


class WebDriverAdaptor implements WebDriver {
    IEDriver ieDriver;

    public WebDriverAdaptor(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }


    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

public class Adaptor {
    public static void main(String[] args) {
        ChromeDriver cd = new ChromeDriver();
        cd.getElement();
        cd.selectElement();

        IEDriver ieD = new IEDriver();
        ieD.findElement();
        ieD.clickElement();

        WebDriver wd = new WebDriverAdaptor(ieD);
        wd.getElement();
        wd.selectElement();
    }
}
