- When the user enters the link /list-payments, he/she will load a page which requests 5 payments 
(amount, currency, date, source and destination account number) to be made.
- Once the payments have been added and the user clicks on the submit button, the data inputted is first validated.
- If validation is successful, the user is redirected to the /payments page, where he/she can view the payments added.
- If validation is not successful, whether the inputs are missing or the payment added is a negative value, the user 
remains in the /list-payments with the relevant error messages.
- When the user is taken to the /payments page, he/she will be able to sort the view of the payments by selecting from the drop down
selection box, either sort by payment date or by amount.
- When either has been selected, an event has been triggered to collect the value of the option selected, adding it to an ajax call of 
getting the payments stored, but sorted in its requested order.
- When the user has selected another value from the drop down, the data would reload again, populating the values with the requested order
again.
