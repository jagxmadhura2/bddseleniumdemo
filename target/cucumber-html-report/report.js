$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login into the ZFJ Cloud Application",
  "description": "",
  "id": "login-into-the-zfj-cloud-application",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Launch website",
  "description": "",
  "id": "login-into-the-zfj-cloud-application;launch-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User Selects the Browser, Launches it and Maximises it",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User Navigates to the URL provided",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate home page",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.user_Selects_the_Browser_Launches_it_and_Maximises_it()"
});
formatter.result({
  "duration": 1791038005,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_Navigates_to_the_URL_provided()"
});
formatter.result({
  "duration": 6990297032,
  "status": "passed"
});
formatter.match({
  "location": "Login.validate_home_page()"
});
formatter.result({
  "duration": 3884083,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Sign in to website",
  "description": "",
  "id": "login-into-the-zfj-cloud-application;sign-in-to-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User sign in using username and password",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.user_sgin_in_using_username_and_password()"
});
formatter.result({
  "duration": 12508838423,
  "status": "passed"
});
formatter.uri("Shopping.feature");
formatter.feature({
  "line": 2,
  "name": "Do online shopping",
  "description": "",
  "id": "do-online-shopping",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Shopping"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "online shopping",
  "description": "",
  "id": "do-online-shopping;online-shopping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Shopping"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User navigates to women category",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User applies filters",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User add selected items to cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Proceed to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User enters shipping details",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "User add incorrect payment details",
  "keyword": "And "
});
formatter.match({
  "location": "Shopping.user_navigates_to_women_category()"
});
formatter.result({
  "duration": 6828535972,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_applies_filters()"
});
formatter.result({
  "duration": 3661987307,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_add_selected_items_to_cart()"
});
formatter.result({
  "duration": 11723445487,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.proceed_to_checkout()"
});
formatter.result({
  "duration": 4465472174,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_enters_shipping_details()"
});
formatter.result({
  "duration": 17456150390,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_add_incorrect_payment_details()"
});
formatter.result({
  "duration": 18931,
  "status": "passed"
});
});