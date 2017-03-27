# TestGoogle
A tiny example testing project.
It is created using Selenium webDriver according to PageObject pattern.
There is only one test added to this project so far.

Automated test case:<br/>
<strong>Prerequisites:</strong> <br/>
Open 'https://www.google.com' and wait until page is loaded.<br/>
<strong>Steps:</strong>
1. Enter 'Selenium' in search input.
2. Click on submit button.
>> Result list consists of 10 results.
>> There is a 'Selenium - Web Browser Automation' among results.
3. Click on 'Next'
>> Result list consists of 10 results.
>> There is no same result on the 2nd page
4. Click on 'Previous'
5. Click on 'Selenium - Web Browser Automation'.
>> Selenium official page is opened with 'Selenium - Web Browser Automation' page title.
