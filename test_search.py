from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
driver.get("https://www.wikipedia.org/")
driver.maximize_window()

search_input = driver.find_element(By.ID, "searchInput")
search_input.send_keys("Software testing")

search_button = driver.find_element(By.CSS_SELECTOR, "button[type='submit']")
search_button.click()

time.sleep(2)
assert "Software testing" in driver.title

driver.quit()
