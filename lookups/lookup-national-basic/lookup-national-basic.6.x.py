# Download the Python helper library from twilio.com/docs/python/install
import os
from twilio.rest import Client

# Your Account Sid and Auth Token from twilio.com/user/account
account_sid = os.environ['TWILIO_ACCOUNT_SID']
# To set up environmental variables, see http://twil.io/secure
auth_token = os.environ['TWILIO_AUTH_TOKEN']
client = Client(account_sid, auth_token)

number = client.lookups.phone_numbers("+15108675310").fetch(country_code="US")

print(number.carrier['type'])
print(number.carrier['name'])
