/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.iot.integration.ui.pages.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wso2.iot.integration.ui.pages.UIConstants;
import org.wso2.iot.integration.ui.pages.UIElementMapper;

import java.io.IOException;

public class VirtualSampleViewPage {
    Log log = LogFactory.getLog(VirtualSampleViewPage.class);
    private WebDriver driver;
    private UIElementMapper uiElementMapper;

    public VirtualSampleViewPage(WebDriver driver) throws IOException {
        this.driver = driver;
        this.uiElementMapper = UIElementMapper.getInstance();
        WebDriverWait webDriverWait = new WebDriverWait(driver, UIConstants.webDriverTimeOut);
        if (!webDriverWait.until(ExpectedConditions.titleContains("Connected Coffee Cup"))) {
            throw new IllegalStateException("This is not the Connected cup device page");
        }
    }

    public boolean orderCoffee() {
        if (UIConstants.isElementPresent(log, driver, By.xpath(
                uiElementMapper.getElement("iot.sample.orderCoffee.xpath")))) {
            WebElement orderBtn = driver.findElement(By.xpath(
                    uiElementMapper.getElement("iot.sample.orderCoffee.xpath")));
            orderBtn.click();
            return true;
        }
        return false;
    }

    public boolean changeTemperature(String val) {
        if (UIConstants.isElementPresent(log, driver, By.xpath(
                uiElementMapper.getElement("iot.sample.temperature.xpath")))) {
            WebElement tempSlider = driver.findElement(By.xpath(
                    uiElementMapper.getElement("iot.sample.temperature.xpath")));
            tempSlider.clear();
            tempSlider.sendKeys(val);
            return true;
        }
        return false;
    }

    public boolean changeCoffeeLevel(String level) {
        if (UIConstants.isElementPresent(log, driver, By.xpath(
                uiElementMapper.getElement("iot.sample.coffee.level.xpath")))) {
            WebElement tempSlider = driver.findElement(By.xpath(
                    uiElementMapper.getElement("iot.sample.coffee.level.xpath")));
            tempSlider.clear();
            tempSlider.sendKeys(level);
            return true;
        }
        return false;
    }
}