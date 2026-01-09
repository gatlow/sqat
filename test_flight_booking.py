from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
driver.get("https://blazedemo.com/")
driver.maximize_window()

driver.find_element(By.NAME, "fromPort").send_keys("Boston")
driver.find_element(By.NAME, "toPort").send_keys("London")
driver.find_element(By.CSS_SELECTOR, "input[type='submit']").click()

time.sleep(2)
driver.find_element(By.XPATH, "//table/tbody/tr[1]/td[1]/input").click()

time.sleep(2)
driver.find_element(By.ID, "inputName").send_keys("Gauharbek")
driver.find_element(By.ID, "address").send_keys("Almaty")
driver.find_element(By.ID, "city").send_keys("Almaty")
driver.find_element(By.ID, "creditCardNumber").send_keys("123456789")

driver.find_element(By.CSS_SELECTOR, "input[type='submit']").click()
time.sleep(2)

assert "BlazeDemo Confirmation" in driver.title
driver.quit()
