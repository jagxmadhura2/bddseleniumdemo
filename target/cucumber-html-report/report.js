$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Shopping.feature");
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
formatter.background({
  "line": 4,
  "name": "User is Logged In",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User Selects the Browser, Launches it and Maximises it",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User Navigates to the URL provided",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Validate home page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User sign in using username and password",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.user_Selects_the_Browser_Launches_it_and_Maximises_it()"
});
formatter.result({
  "duration": 1844798925,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_Navigates_to_the_URL_provided()"
});
formatter.result({
  "duration": 6678309473,
  "status": "passed"
});
formatter.match({
  "location": "Login.validate_home_page()"
});
formatter.result({
  "duration": 5895003,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_sgin_in_using_username_and_password()"
});
formatter.result({
  "duration": 12163960464,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "online shopping",
  "description": "",
  "id": "do-online-shopping;online-shopping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@Shopping"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User navigates to women category",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User applies filters",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User add selected items to cart",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Proceed to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User enters shipping details",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "User add incorrect payment details",
  "keyword": "And "
});
formatter.match({
  "location": "Shopping.user_navigates_to_women_category()"
});
formatter.result({
  "duration": 6275443319,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_applies_filters()"
});
formatter.result({
  "duration": 8739414549,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_add_selected_items_to_cart()"
});
formatter.result({
  "duration": 24991505790,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.proceed_to_checkout()"
});
formatter.result({
  "duration": 3182532242,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_enters_shipping_details()"
});
formatter.result({
  "duration": 36785622597,
  "status": "passed"
});
formatter.match({
  "location": "Shopping.user_add_incorrect_payment_details()"
});
formatter.result({
  "duration": 7999992006,
  "status": "passed"
});
});