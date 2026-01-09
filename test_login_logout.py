from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
driver.get("https://the-internet.herokuapp.com/login")
driver.maximize_window()

driver.find_element(By.ID, "username").send_keys("tomsmith")
driver.find_element(By.ID, "password").send_keys("SuperSecretPassword!")
driver.find_element(By.CSS_SELECTOR, "button.radius").click()

time.sleep(2)
message = driver.find_element(By.ID, "flash")
assert "You logged into a secure area!" in message.text

driver.find_element(By.XPATH, "//a[@href='/logout']").click()
time.sleep(2)

assert "Login Page" in driver.title
driver.quit()
